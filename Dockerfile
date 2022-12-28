FROM openjdk:8-jdk-alpine
LABEL maintainer="xadyniangnd@gmail.com"
VOLUME /main-app
ADD target/dema-test 0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]
