# Task Management API

A RESTful API built with Java and Spring Boot for managing tasks.

This project was developed to practice backend development concepts such as layered architecture, REST APIs, DTOs, validation, exception handling, and database integration with Spring Data JPA.

## Technologies

* Java
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Maven
* Jakarta Bean Validation
* SpringDoc OpenAPI (Swagger)

## Features

* Create a task
* List all tasks
* Get a task by ID
* Update a task
* Delete a task
* Search tasks by title
* Search tasks by description
* List completed tasks
* List pending tasks
* Request validation
* Global exception handling
* API documentation with Swagger

## Project Structure

```text
src
├── controller
├── dto
├── exception
├── model
├── repository
└── service
```

The project follows a layered architecture:

* **Controller**: Handles HTTP requests and responses.
* **Service**: Contains the application's business logic.
* **Repository**: Provides database access using Spring Data JPA.
* **DTO**: Transfers data between the API and the client.
* **Exception**: Centralizes exception handling.

## API Endpoints

| Method | Endpoint                             | Description                 |
| ------ | ------------------------------------ | --------------------------- |
| POST   | `/tarefas`                           | Create a new task           |
| GET    | `/tarefas`                           | List all tasks              |
| GET    | `/tarefas/{id}`                      | Get a task by ID            |
| PUT    | `/tarefas/{id}`                      | Update a task               |
| DELETE | `/tarefas/{id}`                      | Delete a task               |
| GET    | `/tarefas/titulo/{titulo}`           | Search tasks by title       |
| GET    | `/tarefas/descricao?descricao=value` | Search tasks by description |
| GET    | `/tarefas/concluidas`                | List completed tasks        |
| GET    | `/tarefas/pendentes`                 | List pending tasks          |

## Running the Application

1. Clone the repository:

```bash
git clone https://github.com/tuidlara/api-tarefas-springboot
```

2. Configure your PostgreSQL database in `application.properties`.

3. Run the application:

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## API Documentation

After starting the application, the Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

## Learning Objectives

This project was developed to practice:

* REST API development
* Layered architecture
* CRUD operations
* Spring Data JPA
* Request and Response DTOs
* Bean Validation
* Exception handling with `@ControllerAdvice`
* Custom exceptions
* Repository query methods
* API documentation with Swagger

## Author

Arthur de Lara Zilli
