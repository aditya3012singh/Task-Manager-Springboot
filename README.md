# Task Manager — Practice Spring Boot

This repository contains a simple Task Manager application used to practice Spring Boot fundamentals.

## Overview

Purpose: learn and practice building a RESTful API with Spring Boot, Spring Data JPA, and a relational database.

Example features
- Create / read / update / delete tasks (CRUD)
- Mark tasks as complete
- Basic validation and error handling
- In-memory H2 profile for local testing, optional PostgreSQL configuration for production-like testing

## Tech stack

- Java 17+
- Spring Boot (2.7.x / 3.x)
- Spring Web, Spring Data JPA
- H2 (development) or PostgreSQL (optional)
- Maven

## Project structure (suggested)
- src/main/java/.../controller — REST controllers
- src/main/java/.../service — business logic
- src/main/java/.../repository — Spring Data repositories
- src/main/java/.../model — JPA entities / DTOs
- src/test — unit & integration tests
- src/main/resources — application.properties / application.yml

## Running locally

1. Install Java 17+ and Maven.
2. Build the project:
```bash
mvn clean package
```
3. Run with Maven:
```bash
mvn spring-boot:run
```
or run the JAR:
```bash
java -jar target/<artifact-name>.jar
```
4. Default API base: `http://localhost:8080`

## Application profiles

- Default: uses H2 in-memory database. Access H2 console at `/h2-console` (if enabled).
- To use PostgreSQL, configure `spring.datasource.*` properties in `application-postgres.yml` or set environment variables and run with `--spring.profiles.active=postgres`.

## Example API endpoints

- GET /api/tasks — list tasks
- GET /api/tasks/{id} — get task by id
- POST /api/tasks — create task
  - Example request body:
  ```json
  {
    "title": "Buy groceries",
    "description": "Milk, eggs, bread",
    "dueDate": "2026-02-01"
  }
  ```
- PUT /api/tasks/{id} — update task
- PATCH /api/tasks/{id}/complete — mark task complete
- DELETE /api/tasks/{id} — delete task

Example curl to create a task:
```bash
curl -X POST http://localhost:8080/api/tasks \
  -H "Content-Type: application/json" \
  -d '{"title":"Buy milk","description":"2 liters","dueDate":"2026-02-01"}'
```

## Tests

Add unit tests for services and controllers. For simple integration tests, use @SpringBootTest with an H2 profile.

## TODO / Improvements

- Add pagination and filtering on task list
- Add user authentication and task ownership
- Add DTOs and validation annotations
- Add OpenAPI / Swagger documentation

## License

MIT

---
Created by aditya3012singh (added via assistant)
