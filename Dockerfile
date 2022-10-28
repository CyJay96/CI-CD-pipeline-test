FROM openjdk:11-jre-slim

EXPOSE 8080

WORKDIR /app

ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} /app/app.jar

ENTRYPOINT ["java","-jar","/app/app.jar"]
