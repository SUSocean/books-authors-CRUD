FROM eclipse-temurin:17-jdk-alpine
MAINTAINER frogadmirer.com
COPY target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
ENTRYPOINT ["java", "-jar", "/app.jar"]
