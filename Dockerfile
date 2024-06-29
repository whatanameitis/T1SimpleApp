FROM gradle:8.4.0-jdk21 AS builder
WORKDIR /builder
COPY . .

RUN gradle bootJar

FROM openjdk:21-slim

WORKDIR /app

EXPOSE 8080

COPY --from=builder /builder/build/libs/T1SimpleApp.jar app.jar

CMD ["java", "-jar", "app.jar"]

