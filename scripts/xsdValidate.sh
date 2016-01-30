#!/bin/bash


#функции
#
#

#
function checkEmptyString {
	INPUT_STRING="${1}"
	INPUT_DESCR="${2}"
	if [[ -z $INPUT_STRING ]]; then
		echo "Не задана строка ${INPUT_STRING}${INPUT_DESCR}"
		return 1;
	fi
}

function checkFilePath {
	FILE_PATH="${1}"
	INPUT_DESCR="${2}"
	if [[ ! -f $FILE_PATH ]]; then
		echo "Не найден файл ${FILE_PATH}${INPUT_DESCR}"
		return 1;
	fi
}

function splitString {
	INPUT_STRING=$1
	SEPARATOR_STRING=$2
	if ! checkEmptyString $INPUT_STRING ' строка парсинга'  || ! checkEmptyString  $SEPARATOR_STRING ' разделитель парсинга'; then
		return 1;
	fi
	SPLITTED_VALS=()
	IFS='${SEPARATOR_STRING}' read -ra ADDR <<< "$IN"
	for i in "${INPUT_STRING[@]}"; do
		echo 'добавление элемента ${i} в массив ${SPLITTED_VALS}'
	    SPLITTED_VALS=(${SPLITTED_VALS[@]} $1)
	done
	return $SPLITTED_VALS
}

function handleInteractiveInput {
	MESSAGE=$1
	TIMELIMIT=$2
	if ! checkEmptyString $MESSAGE ' сообщение' || ! checkEmptyString $TIMELIMIT ' таймаут'; then
		return 1
	fi
	echo
	echo -n "${MESSAGE} "
	read -t $TIMELIMIT
	echo "В ответ на сообщение: ${MESSAGE} введено: ${REPLY}"
}

#echo $PIPESTATUS
##echo $?
#echo $PWD
#echo $SECONDS #The number of seconds the script has been running.
#echo $SHELLOPTS
#



#
function checkArg {
	MODES="${1}"
	FILE="${2}"
	OPTS="${3}"
	echo "вызвана функция checkArg in MODE: $MODE for FILE: $FILE with OPTS: $OPTS"
	#
	echo "проверка режима вызова"
	if ! checkEmptyString $MODE ' режима проверки'; then
		return 1
	fi
	#TODO Сделать через парсинг по двоеточию
	MODES='NOT_EMPTY IS_FILE'
	RESULT_EXIT_CODE=1
	for selected_mode in $MODES
	do
		case $selected_mode in
			'NOT_EMPTY' ) RESULT_EXIT_CODE=$RESULT_EXIT_CODE && checkEmptyString $INPUT "${OPTS}" ;;
			'IS_FILE' ) RESULT_EXIT_CODE=$RESULT_EXIT_CODE && checkFilePath $INPUT "${OPTS}" ;;
		esac
		RESULT_EXIT_CODE=$RESULT_EXIT_CODE
	done
}





#
#&> /dev/null #Все выводы игнорит
#2>&1 stderr to stdout
#

function validateXsd {
	XSD_SCHEME="${1}"
	XML_DOC="${2}"
	OUT_FILE="${3}"
	echo "Запуск тулзы xmllint с валидацией по xsd : ${XSD_SCHEME} для xml-документа: ${XML_DOC} с выводом в файл ${OUT_FILE}"

	checkArg ${XSD_SCHEME} ' xsd-схемы' &&
	checkArg ${XML_DOC} ' xml-документа' &&


	if [[ -z  ${OUT_FILE} ]]; then
		OUT_FILE="./out.xml"
	fi
	if [[ -f $OUT_FILE ]]; then
		OUT_FILE_BK=${OUT_FILE}_bk
		echo "Попытка перезаписать файл вывода ${OUT_FILE}"
		echo "Сделан бекап в ${OUT_FILE_BK}"
		mv $OUT_FILE $OUT_FILE_BK
	fi
	echo "Вызов xmllint --c14n --encode UTF-8 --format --noout  --schema $1 $2"
	xmllint --c14n --encode UTF-8 --format --noout  --schema $1 $2
	exit 0
}


validateXsd $@ &> ./validateXsd.log