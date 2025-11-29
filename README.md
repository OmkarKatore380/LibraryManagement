A simple and modular Library Management System built using Java and Spring Boot.
This project demonstrates CRUD operations, layered architecture, and basic REST API development for managing books, users, and borrowing records.

Features

Add, update, delete, and view books

Manage members

Issue and return books

REST APIs for all major operations

Layered architecture (Controller → Service → Repository)

Uses Spring Boot JPA & MySQL (or H2)

Tech Stack
Layer	Technology
Backend	Java 17 / 21, Spring Boot
Database	MySQL / H2
Build Tool	Maven
Version Control	Git & GitHub
Project Structure
src/
 └─ main/
     ├─ java/com/example/library/
     │    ├─ controller/
     │    ├─ service/
     │    ├─ repository/
     │    ├─ model/
     │    └─ LibraryManagementApplication.java
     └─ resources/
          ├─ application.properties
          └─ data.sql (optional)

How to Run the Project
1. Clone the repo
git clone https://github.com/OmkarKatore380/LibraryManagement.git
cd LibraryManagement

2. Configure Database

Inside application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/library
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update

3. Run

Using Maven:

mvn spring-boot:run


Or run the main class in your IDE.

API Endpoints
Books
Method	Endpoint	Description
GET	/books	Get all books
GET	/books/{id}	Get book by ID
POST	/books	Add new book
PUT	/books/{id}	Update book
DELETE	/books/{id}	Delete book
Members

(similar pattern)

Future Enhancements

Authentication using Spring Security

Fine calculation

Admin dashboard UI

Email notifications

Author

Omkar Katore
Java Developer | Spring Boot | Backend
GitHub: OmkarKatore380
