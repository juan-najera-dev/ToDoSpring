# Stage 1: Build the Application

FROM eclipse-temurin:21-jdk

# Set the working directory
WORKDIR /app

# Copy the application code
COPY . .

# Build the Application (NOT WORKING) do it manually
RUN ./mvnw clean package -DskipTests

# Stage 2: Run the Application
FROM eclipse-temurin:21-jre

# Set the working directory
WORKDIR /app

# Copy the JAR file from the building stage
ARG JAR_FILE=target/todo-0.0.1.jar
COPY ${JAR_FILE} app_todo.jar

# Expose the port that the app will run on
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "app_todo.jar"]