FROM maven:4.0.0-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests



FROM openjdk:17-jdk-slim
# Copy the jar file from the target directory to the working directory in the container
COPY target/BernabeuBack-0.0.1-SNAPSHOT.jar BernabeuBack.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
