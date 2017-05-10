#!/usr/bin/env bash

./gradlew appengineExplodeApp
chmod u+x ~/.gradle/appengine-sdk/appengine-java-sdk-1.9.52/bin/*.sh
~/.gradle/appengine-sdk/appengine-java-sdk-1.9.52/bin/appcfg.sh --service_account_json_key_file=gae.json update build/exploded-app
./gradlew clean
