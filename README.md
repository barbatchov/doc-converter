# DOCUMENT CONVERTION WITH OPENOFFICE SDK

This service can convert documents into pdf and html using openoffice.

I am having problems under dockerizated build.

It works locally.

## Running locally

First of all, you must install oppenoffice. Then run it as a service.

Ex:
```shellscript
/opt/openoffice4/program/soffice -headless -nologo -nofirststartwizard -accept="socket,host=127.0.0.1,port=8100;urp" &
```
 
 Once you ran it. You can run the application:
 
```shellscript
mvn clean spring-boot:run -DskipTests
```

## Running under a container [not working well]

If you want to try running it under a container you can build it using maven.

Although when running it under a container you will see that the application can't connect with the openoffice service defined into run.sh.

```shellscript
# building and running a container.
mvn package -DskipTests docker:build

# running
docker-compose -f ./src/main/docker/docker-compose.yml up
```