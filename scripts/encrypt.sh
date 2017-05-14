#!/usr/bin/env bash

tar cvf secrets.tar gae.json app_config.properties
travis encrypt-file secrets.tar --add before_deploy