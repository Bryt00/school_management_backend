# School Management API

A robust, enterprise-grade School Management API built with **Spring Boot** and **Clean Architecture** principles.

## 🚀 Features

- **Clean Architecture:** Strict separation of Domain, Application, and Infrastructure layers.
- **Secure Authentication:** JWT-based authentication with role-based access control (RBAC).
- **Automated Mapping:** MapStruct integration for boilerplate-free DTO/Entity mapping.
- **Interactive Documentation:** Fully integrated Swagger UI (OpenAPI 3).
- **Environment Management:** Native `.env` file support for secrets.
- **Global Error Handling:** Consistent JSON error responses across the entire API.

## 🛠️ Technology Stack

- **Core:** Java 25, Spring Boot 4.x
- **Persistence:** PostgreSQL with Spring Data JPA
- **Caching:** Redis
- **Security:** Spring Security, JJWT
- **API Docs:** SpringDoc OpenAPI
- **Build Tool:** Gradle

## 🏗️ Project Structure

```text
src/main/java/com/raven/school_mgt_api/
├── domain/             # Enterprise Business Rules (Entities, Repository Interfaces)
├── application/        # Application Business Rules (Use Cases, DTOs, Mappers)
└── infrastructure/     # Frameworks & Drivers (Web, Persistence, Security, Config)
```

## 🚦 Getting Started

### 1. Prerequisites

- Docker & Docker Compose
- JDK 25

### 2. Environment Setup

Create a `.env` file in the root directory:

```env
DB_URL=jdbc:postgresql://localhost:5432/school_mgt_db
DB_USER=postgres
DB_PASSWORD=yourpassword
JWT_SECRET=your_32_character_long_secret_key
```

### 3. Spin up Infrastructure

```bash
docker compose up -d
```

### 4. Run the Application

```bash
./gradlew bootRun
```

## 📖 API Documentation

Once the app is running, access the interactive Swagger UI at:
[http://localhost:8000/swagger-ui/index.html](http://localhost:8000/swagger-ui/index.html)

---

Developed by **Bryt00**
