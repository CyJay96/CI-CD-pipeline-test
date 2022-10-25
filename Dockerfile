FROM openjdk:11-jre-slim

EXPOSE 8080

WORKDIR /app

## Add the wait script to the image
ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.9.0/wait /wait
COPY /wait /app/
RUN chmod +x /wait

ARG JAR_FILE=/target/*.jar
COPY ${JAR_FILE} /app/app.jar

#CMD ./wait && java -jar /app/app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
