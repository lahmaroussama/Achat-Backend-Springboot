FROM openjdk:11

# Set the working directory
WORKDIR /app

RUN git clone https://github.com/lahmaroussama/Achat-Backend-Springboot.git /app
