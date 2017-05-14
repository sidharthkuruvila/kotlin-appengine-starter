Kotlin App Engine starter
------------------------

[![Build Status](https://travis-ci.org/sidharthkuruvila/kotlin-appengine-starter.svg?branch=master)](https://travis-ci.org/sidharthkuruvila/kotlin-appengine-starter)

This is a starter project for appengine apps writen in kotlin.

The production branch is deployed on appengine [link](https://sidharth-165204.appspot.com/hello)

Deployment status: [![Build Status](https://travis-ci.org/sidharthkuruvila/kotlin-appengine-starter.svg?branch=production)](https://travis-ci.org/sidharthkuruvila/kotlin-appengine-starter)


It uses

 * Kotlin 1.1.2
 * Jersey 2.25.1
 * Jackson 2.8.8
 * Guice 4.1.0


Deploying to App Engine
-----------------------


### Using gradle

 * [Create a project](https://console.cloud.google.com/projectcreate)
 * Set the project name in appengine-web
 
        ./gradlew appengineUpdate
    

### Using travis

 * Install the travis cli
 
        gem install travis -v 1.8.8 --no-rdoc --no-ri

 * Create a branch named production
    
        git checkout -b production
    
 * [Create a project](https://console.cloud.google.com/projectcreate)
 * Set the PROJECT_NAME and other properties in [app_config.properties](src/main/webapp/WEB-INF/appengine-web.xml)
 * Create credentials of type [Service account key](https://console.developers.google.com/apis/credentials/serviceaccountkey) as json
 * Copy the key into the project
 
        mv ~/Downloads/<key_name.json> gae.json
 
 * Encrypt the secure files
 
       ./scripts/encrypt.sh
        
 * Reorder the commands in the before_deploy stage in .travis.yml so 
 that the call to replace_vars.py is after decryption of app-config.properties
 
 * Commit the changes and push
 
        git add secret.tar.enc
        git commit -am 'Updated project name and added auth key for gae'
        git push