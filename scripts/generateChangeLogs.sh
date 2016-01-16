#!/bin/bash
DRIVER_ID="org.postgresql.Driver"
DRIVER_LIB="target/lib/postgresql-9.4.1207.jre7.jar"
DB_JDBC_URL="jdbc:postgresql://localhost:5432/wrightemployees"
DB_USR="restadmin01"
DB_PWD="123456"
CHANGE_LOG_NAME="wrightEmployees.changelog.xml"
CHANGE_LOG_PATH="src/main/resources/org/wadzapi/employeeService/persist/dao/changelog/${CHANGE_LOG_NAME}"
BK_POSTFIX=".bk"

echo "Поиск файла ченжлога ${CHANGE_LOG_PATH}"
if [[ -f $CHANGE_LOG_PATH ]]; then
    echo "Найдена предыдущая версия. Бекапирование..."
    mv ${CHANGE_LOG_PATH} tmp/${CHANGE_LOG_NAME}${BK_POSTFIX}
fi

mvn clean install -Pjar-with-dependencies &&
liquibase --driver=$DRIVER_ID --classpath=$DRIVER_LIB --url=$DB_JDBC_URL --username=$DB_USR --password=$DB_PWD --logLevel=debug --changeLogFile=$CHANGE_LOG_PATH generateChangeLog  &&
mvn clean
