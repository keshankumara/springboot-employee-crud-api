
# Spring Boot Employee CRUD API

A simple RESTful API for managing employees, built with **Spring Boot** and connected to a **MySQL database**. It supports full **CRUD operations** and has been tested using **Postman**.

---

## 🚀 Features

- Create a new employee
- View all employees
- View employee by ID
- Update employee details
- Delete employee
- Proper error handling

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman

---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.ruhuna.employee
│   │       ├── Employee.java
│   │       ├── EmployeeRepository.java
│   │       ├── EmployeeRestController.java
│   │       └── EmployeeApplication.java
│   └── resources
│       ├── application.properties
│       └── employee-directory.sql
```

---

## 📦 API Endpoints

| Method | Endpoint                  | Description              |
|--------|---------------------------|--------------------------|
| GET    | `/api/getAllEmployee`     | Get all employees        |
| GET    | `/api/findEmployee/{id}`  | Get employee by ID       |
| POST   | `/api/addEmployee`        | Add a new employee       |
| PUT    | `/api/update/{id}`        | Update employee by ID    |
| DELETE | `/api/deleteEmployee/{id}`| Delete employee by ID    |

✅ All endpoints tested using Postman

---

## ⚙️ Configuration

### MySQL (Recommended):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

---

## ▶️ Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/springboot-employee-crud-api.git
   cd springboot-employee-crud-api
   ```

2. Edit `application.properties` with your DB config.

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Test endpoints with Postman or curl.

---


## ✍️ Author

- [Keshan Kumara](https://github.com/keshankumara)

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).
