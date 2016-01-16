#!/bin/bash
DB_NAME="employees1"
DUMP_DIR="/home/workspace/projects/restService01/dumps"
DUMP_PREFIX="employees1"
TIMESTAPMPER=$(date -d "today" +"%d.%m.%Y_%H:%M")
DUMP_SUFFIX="sql"
OUTPUT="${DUMP_DIR}/${DUMP_PREFIX}_${TIMESTAPMPER}.${DUMP_SUFFIX}"
sudo -u postgres sh -c "pg_dump ${DB_NAME} > ${OUTPUT} && echo Dumped ${DB_NAME} to ${OUTPUT}"
