FROM openjdk:11-jre-slim
WORKDIR /app
COPY asher_docker/publisher-post-manager-1.0-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]