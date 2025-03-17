FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file
COPY build/libs/mqtt-ingestion-1.0.0.jar app.jar

# Expose the MQTT ingestion service port
EXPOSE 8082

# Run the application
CMD ["java", "-jar", "app.jar"]
