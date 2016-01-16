#!/bin/bash


mvn org.liquibase:liquibase-maven-plugin:3.2.0:changelogSync -Durl="jdbc:postgresql://localhost:5432/wrightemployees" -Duser="restadmin01" -Dpassword="123456" -Ddriver="org.postgresql.Driver" -DoutputDefaultSchema="public" -Dverbose="true" -Dlogging="debug" -DchangeLogFile="/home/vadik/workspace/projects/active/wsmeter-manul/src/main/resources/org/wadzapi/employeeService/persist/dao/changelog/wrightEmployees.changelog.xml"
