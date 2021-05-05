FROM java:8-jdk-alpine

ADD target/springdemo-0.0.1-SNAPSHOT.jar /usr/app/app.jar

WORKDIR /usr/app

ENTRYPOINT ["java","-jar","app.jar" ]

EXPOSE 8080