FROM java:8-jdk-alpine

ADD target/my-consumer-events.jar /usr/app/app.jar

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","app.jar" ]
