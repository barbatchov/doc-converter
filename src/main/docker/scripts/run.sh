#!/bin/sh

/opt/openoffice4/program/soffice -headless -nologo -nofirststartwizard -accept="socket,host=127.0.0.1,port=8100;urp" &

java ${JAVA_OPTS} ${DEBUG_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar