FROM maven:3.9.6-eclipse-temurin-17 as builder
COPY src /sources/app/src
COPY pom.xml /sources/app
WORKDIR /sources/app
RUN mvn package -DskipTests

FROM eclipse-temurin:17.0.1_12-jdk-alpine
COPY --from=builder /sources/app/target/*.jar /app.jar
ENTRYPOINT ["java","-jar","/app.jar"]