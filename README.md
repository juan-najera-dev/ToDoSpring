# TodoSpringRest

A Simple Backend for a Todo App using JPA with MySql and Docker for the deploy

## How to Run locally without Docker

Clone the repository, create a schema in MySQL

```sql
CREATE SCHEMA `todocrud` ;
```

Create an application.properties file in /src/main/resources

```application.properties
spring.application.name=app_todo

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
server.port=8080
```

Add the enviroment variables to your project

- DB_USER = Your user
- DB_PASSWORD = Your password
- DB_URL = jdbc:mysql://localhost:3306/todocrud?createDatabaseifNotExist=true&serverTimezone=UTC

## Test

In Postman, Thunder Client or your Rest API Client generate the requests

### Get all

```
http://localhost:8080/api/tasks/
```

### Get

```
http://localhost:8080/api/tasks/{id}
```

Ex:

```
http://localhost:8080/api/tasks/5
```

### Post

```
http://localhost:8080/api/tasks/
```

- Body

```json
{
  "title": "Test de la API",
  "description": "Check",
  "status": false
}
```

### Put

```
http://localhost:8080/api/tasks/{id}
```

Ex:

```
http://localhost:8080/api/tasks/5
```

- Body

```json
{
  "title": "Test de la API",
  "description": "Check",
  "status": false
}
```

### Delete

```
http://localhost:8080/api/tasks/2
```

## How to Run locally with Docker

Clone the repository, and modify the docker-compose file with the credentials that you want to use in your container

```
app_todo:
  environment:
    DB_URL: jdbc:mysql://todo:3306/todocrud?createDatabaseifNotExist=true&serverTimezone=UTC
        DB_USER:
	DB_PASSWORD:
todo:
  environment:
    MYSQL_ROOT_PASSWORD:
	MYSQL_PASSWORD:
	MYSQL_DATABASE: todocrud

```

in a terminal window go to the project and create the application JAR

```bash
cd Todo
chmod +x mvnw
./mvnw clean package -DskipTests
```

Create the image, generate, and run the container

```bash
docker-compose build
docker-compose up
```

You can test the API with the same method that locally
