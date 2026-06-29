FROM openjdk:21-ea-2-jdk-slim
LABEL authors="Gaming 15"

ENTRYPOINT ["top", "-b"]