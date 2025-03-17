FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR file
COPY build/libs/grpc-ingestion-1.0.0.jar app.jar

# Expose the gRPC port
EXPOSE 9090

# Run the application
CMD ["java", "-jar", "app.jar"]
