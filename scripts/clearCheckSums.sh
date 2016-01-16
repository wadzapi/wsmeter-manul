#!/bin/bash

mvn -Pjar-with-dependencies clean install &&
liquibase --driver=org.postgresql.Driver --classpath=target/lib/postgresql-9.4.1207.jre7.jar --url="jdbc:postgresql://localhost:5432/wrightemployees" --username=restadmin01 --password=123456 --logLevel=debug --changeLogFile=src/main/resources/org/wadzapi/employeeService/persist/dao/changelog/wrightEmployees-changelog-01.xml clearCheckSums &&
mvn clean

#mvn org.liquibase:liquibase-maven-plugin:3.2.0:changelogSync -DclearCheckSums="true" -Durl="jdbc:postgresql://localhost:5432/wrightemployees" -Duser="restadmin01" -Dpassword="123456" -Ddriver="org.postgresql.Driver" -DoutputDefaultSchema="public" -Dverbose="true" -Dlogging="debug" -DchangeLogFile="src/main/resources/org/wadzapi/employeeService/persist/dao/changelog/wrightEmployees.changelog.xml"
