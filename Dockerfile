FROM alpine:3.14
RUN apk update && apk add openjdk11-jre
WORKDIR /opt
COPY target/XOs-1.0-SNAPSHOT.jar .
ENTRYPOINT java -jar XOs-1.0-SNAPSHOT.jar