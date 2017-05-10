Kotlin App Engine starter
------------------------

This is a starter project for appengine apps writen in kotlin.

It uses

 * Kotlin 1.1.2
 * Jersey 2


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
 * Set the ${PROJECT_NAME} in [appengine-web.xml](src/main/webapp/WEB-INF/appengine-web.xml)
 * Create credentials of type [Service account key](https://console.developers.google.com/apis/credentials/serviceaccountkey) as json
 * Copy the key into the project
 
        mv ~/Downloads/<key_name.json> gae.json
 
 * Encrypt the key
 
        travis encrypt-file gae.json --add before_deploy
        
 * Commit the changes and push
 
        git add gae.json.enc
        git commit -am 'Updated project name and added auth key for gae'
        git push