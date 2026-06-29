FROM openjdk:17-jdk-slim
LABEL authors="jkaru"

EXPOSE 8060

# Set working directory
WORKDIR /app

COPY target/*.jar /app/product-service.jar


ENTRYPOINT ["java", "-jar", "/app/product-service.jar"]