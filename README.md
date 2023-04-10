# Simple Todo REST API 
This is a simple Todo REST API built with Java Spring Boot that allows users to create, read, update and delete task.

## Table of Contents
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Endpoints](#endpoints)


## Technologies Used
- Java Spring Boot
- Spring Data JPA
- Hibernate 
- Flyway for DB migration 
- PostgreSQL 
- Build Tool: Gradle 

## Installation
To install this app, follow these steps:
1. Clone this repository to your local machine.
2. Clone Simple To Do App(https://github.com/emma-kang/react-todolist) to your local machine and follow installation steps.
3. Create Local DB with Docker
```
docker run -d -p 5432:5432 --name todo_local -e POSTGRES_PASSWORD=localdb123 postgres
```
4. Create `todo_local` database 
5. Open the project in your preferred IDE. 
6. Run the application 
7. The API will be available at `http://localhost:8080/v1/todos`

## Endpoints
The API has the following endpoints:
- GET `/v1/todos` Returns a list of all todo tasks 
- GET `/v1/todos?accountId={accountId}` Returns a list of all todo task by account ID
- GET `/v1/todos/{todoId}` Return todo task by ID
- POST `/v1/todos` Create a new task
- PUT `/v1/todos/{todoId}` Update an existing task by ID
- DELETE `/v1/todos/{todoId}` Delete a task by ID

