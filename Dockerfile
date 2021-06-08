FROM openjdk:8-jdk-alpine
COPY build/libs/api-tiques-0.0.1.jar api-tiquet.jar
ENTRYPOINT ["java","-jar","api-tiquet.jar"]