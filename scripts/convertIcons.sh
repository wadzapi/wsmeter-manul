#!/bin/bash

### TODO Попробовать конвертить через imagemagick с доп. аргументами
#-contrast-stretch black-point


#convert -adaptive-resize 32x32 -resample 32x32 -monitor -interpolate bicubic -flatten -filter Parzen -fft -enhance -comment 'Иконка для сервиса wsMeterManul' -normalize -quality 3 wsMeterManul.png wsMeterManul32x32.png


#convert -adaptive-resize 16x16 -resample 16x16 -monitor -interpolate bicubic -flatten -filter Parzen -fft -enhance -comment 'Иконка для сервиса wsMeterManul' -normalize -quality 3 wsMeterManul.png wsMeterManul16x16.png

echo "Конвертация 16х16" &&
convert  -gravity center -crop 16x16+0+0 -flatten -colors 256 manul16.ppm manul16x16.jpg &&
echo "Конвертация 32x32" &&
convert  -gravity center -crop 32x32+0+0 -flatten -colors 256 manul32.ppm manul32x32.jpg


