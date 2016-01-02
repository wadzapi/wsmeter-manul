#!/bin/bash
TOMCAT_HOME="/home/jee/apache-tomcat-7.0.63/webapps/"
WEBAPP_NAME="restService01-1.0.0-SNAPSHOT.war"

mvn clean install &&
cp target/${WEBAPP_NAME} ${TOMCAT_HOME}/${WEBAPP_NAME}
