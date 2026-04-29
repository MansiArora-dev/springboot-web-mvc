# 🌐 Spring Boot Web MVC

A Spring Boot application demonstrating REST APIs with layered architecture, input validation, exception handling, and consistent response transformation using H2 in-memory database.

---

## ☁️ Core Concepts Overview

| Concept | Description |
|---------|-------------|
| REST APIs | GET, POST, PUT, PATCH, DELETE endpoints |
| Layered Architecture | Controller → Service → Repository pattern |
| Input Validation | Jakarta Bean Validation with custom constraint annotation |
| Exception Handling | Global exception handler with custom exceptions |
| Response Transformation | Consistent API response wrapper for all endpoints |
| DTO Pattern | Entity ↔ DTO mapping via ModelMapper |

---

## 🔑 Core Features

### 📋 Employee CRUD
- Get all employees, get by ID
- Create, update (full & partial), delete
- `@RequestParam` support for filtering and sorting

### ✅ Input Validation
- Jakarta Bean Validation — `@NotBlank`, `@Email`, `@Size`, `@Min`, `@Max`, `@Digits`, `@DecimalMin`, `@DecimalMax`, `@PastOrPresent`, `@AssertTrue`
- Custom constraint annotation `@EmployeeRoleValidation` — validates role is `USER` or `ADMIN`

### 🌐 Consistent API Response
- `GlobalResponseHandler` — wraps every response in `ApiResponse<T>`
- `ApiResponse<T>` — contains `timestamp`, `data`, and `error` fields
- All success and error responses follow same structure

### ⚠️ Exception Handling
- `GlobalExceptionHandler` — handles `ResourceNotFoundException`, `MethodArgumentNotValidException`, and generic exceptions
- `ApiError` — structured error with `status`, `message`, and `subErrors` list
- Validation errors return all field-level messages together

---

## 📡 API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `/employees` | Get all employees |
| `GET` | `/employees/{employeeId}` | Get employee by ID |
| `POST` | `/employees` | Create new employee |
| `PUT` | `/employees/{employeeId}` | Full update employee |
| `PATCH` | `/employees/{employeeId}` | Partial update employee |
| `DELETE` | `/employees/{employeeId}` | Delete employee |

---

## 🔧 Core Concepts Demonstrated

### Custom Constraint Annotation
```java
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Constraint(validatedBy = {EmployeeRoleValidator.class})
public @interface EmployeeRoleValidation {
    String message() default "Role of Employee can either be USER or ADMIN";
}
```

### Consistent API Response Structure
```java
@Data
public class ApiResponse<T> {
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;
}
```

### Global Exception Handler
```java
@ExceptionHandler(MethodArgumentNotValidException.class)
public ResponseEntity<ApiResponse<?>> handleInputValidationErrors(...) {
    // Returns all validation error messages together
}
```

---

## 🚀 Quick Start

**Prerequisites:** Java 21+, Maven

```bash
git clone https://github.com/MansiArora-dev/springboot-web-mvc.git
cd springboot-web-mvc
```

**Using IntelliJ IDEA (Recommended):**
1. Open project in IntelliJ
2. Run → **Edit Configurations**
3. Environment variables: `SPRING_PROFILES_ACTIVE=local`
4. Click **Run ▶️**

**Using Maven:**
```bash
mvn spring-boot:run
```

**H2 Console:** `http://localhost:8080/h2-console`

---

## 📂 Project Structure
```
src/main/java/com/springbootweb/
├── advices/
│   ├── ApiError.java                  # Structured error response
│   ├── ApiResponse.java               # Generic response wrapper
│   ├── GlobalExceptionHandler.java    # Centralized exception handling
│   └── GlobalResponseHandler.java     # Response transformation
├── annotations/
│   ├── EmployeeRoleValidation.java    # Custom constraint annotation
│   └── EmployeeRoleValidator.java     # Validator logic
├── configs/
│   └── MapperConfig.java              # ModelMapper bean
├── controllers/
│   └── EmployeeController.java        # REST endpoints
├── dto/
│   └── EmployeeDTO.java               # DTO with validations
├── entities/
│   └── EmployeeEntity.java            # JPA Entity
├── exceptions/
│   └── ResourceNotFoundException.java # Custom runtime exception
├── repositories/
│   └── EmployeeRepository.java        # JPA Repository
└── services/
├── EmployeeService.java            # Service interface
└── EmployeeServiceImpl.java        # Service implementation

```

## 💻 Technologies

- **Java 21** | **Spring Boot** | **Maven**
- **Spring Web MVC** | **Spring Data JPA** | **H2 Database**

---

## 🌟 Key Takeaways
- **Layered Architecture** — Clean separation of concerns
- **Custom Validation** — Reusable constraint annotation for role validation
- **Consistent Responses** — Every API returns same `ApiResponse<T>` structure
- **Centralized Error Handling** — All exceptions handled in one place

---

## 👩‍💻 Developer
**Mansi Arora** — Software Engineer


