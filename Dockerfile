# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine



VOLUME /tmp

# Copy the jar file from the target directory to the working directory in the container
COPY target/BernabeuBack-0.0.1-SNAPSHOT.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
