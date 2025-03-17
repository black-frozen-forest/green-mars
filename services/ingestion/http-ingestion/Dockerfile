FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file
COPY build/libs/http-ingestion-1.0.0.jar app.jar

# Expose the HTTP port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]