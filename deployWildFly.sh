#!/bin/bash
WILDFLY_HOME="/home/jee/wildfly-9.0.2.Final/standalone/deployments"
WEBAPP_NAME="restService01-1.0-SNAPSHOT.war"

mvn clean install &&
cp target/${WEBAPP_NAME} ${WILDFLY_HOME}/${WEBAPP_NAME}
