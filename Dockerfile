#FROM gradle:7.2.0-jdk17 AS build
#COPY . .
#FROM  openjdk:17.0.1-jdk-slim
#COPY --from=build /hngtask1api-0.0.1-SNAPSHOT.jar hngtask1api.jar

#EXPOSE 8080
#ENTRYPOINT ["java","-jar","hngtask1api.jar"]

FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./gradlew bootjar --no-daemon

FROM openjdk:17-jdk-slim
EXPOSE  8080
COPY --from=build /build/libs/hngtask1api.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]