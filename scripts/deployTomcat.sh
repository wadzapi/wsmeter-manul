#!/bin/bash
TOMCAT_HOME="/home/jee/apache-tomcat-7.0.63/webapps/"
WEBAPP_NAME="wsmeter-manul-1.0-SNAPSHOT.war"

#cd .. &&
mvn clean install &&
cp target/${WEBAPP_NAME} ${TOMCAT_HOME}/${WEBAPP_NAME}
