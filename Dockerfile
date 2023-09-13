FROM gradle:7.2.0-jdk17 AS build
COPY . .
FROM  openjdk:17.0.1-jdk-slim
COPY --from=build/target/hngtask1api=0.0.1=SNAPSHOT.jar hngtask1api.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","hngtask1api.jar"]