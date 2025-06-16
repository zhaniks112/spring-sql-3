# Dockerfile
FROM openjdk:21
WORKDIR /app
COPY demo/target/demo-0.0.3.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
