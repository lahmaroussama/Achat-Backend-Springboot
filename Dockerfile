FROM openjdk:11-jre-slim

WORKDIR /app

COPY target/achat.jar achat.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "achat.jar"]
