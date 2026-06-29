FROM maven:3.9-ibm-semeru-17-focal AS build
COPY . .
RUN mvn clean package -DskipTests
LABEL authors="jkaru"

FROM ibm-semeru-runtimes:open-17-jre-focal
COPY --from=build /target/*.jar product-service.jar

EXPOSE 8060

ENTRYPOINT ["java", "-jar", "product-service.jar"]