FROM adoptopenjdk/openjdk8-openj9:jre8u292-b10_openj9-0.26.0-alpine

WORKDIR /usr/src/app

RUN mkdir /logs && \
    adduser --disabled-password -u 1000 app1-svc

USER app1-svc

COPY ./target/app1-*.jar /usr/src/app/app1.jar

CMD [ "java", "-Djava.io.tmpdir=/home/app1-svc", "-jar", "/usr/src/app/app1.jar" ]