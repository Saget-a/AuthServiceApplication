
FROM openjdk:17-jdk-slim

ARG JAR_FILE=target/auth-service-2.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080

# Команда запуску
ENTRYPOINT ["java", "-jar", "app.jar"]