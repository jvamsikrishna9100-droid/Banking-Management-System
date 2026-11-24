Banking Management System  :  

Project Overview  : 

The Banking Management System is a backend web application developed using **Java and Spring Boot**.

This application provides RESTful APIs to manage banking operations such as customer registration, bank account creation, deposits, withdrawals, balance inquiries, and customer details.

It follows a layered architecture to maintain clean, modular, and maintainable code.

Tools Used  :  

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate ORM
- MySQL Database
- Maven
- RESTful APIs
- Postman
- Render (Deployment)

Key Features  :  

- Customer Registration
- Create Bank Account
- Deposit Money
- Withdraw Money
- Check Account Balance
- View Customer Details
- REST API Integration
- MySQL Database Connectivity
- Exception Handling

Project Architecture  :  

The application follows a layered architecture:

1. **Controller Layer** – Handles HTTP requests and REST API endpoints.
2. **Service Layer** – Contains business logic.
3. **Repository Layer** – Handles database operations using Spring Data JPA.
4. **Entity Layer** – Defines database entities.
5. **DTO Layer** – Transfers data between client and server.

REST API Operations  :  

The application provides REST API endpoints for:

| HTTP Method | Operation |
|---|---|
| POST | Create Customer |
| POST | Create Bank Account |
| POST | Deposit Money |
| POST | Withdraw Money |
| GET | Check Account Balance |
| GET | View Customer Details |

Database  :  

**MySQL Database**

Spring Data JPA and Hibernate are used to interact with the MySQL database and perform database operations.

How to Run the Project  :  

1. Clone the repository.
2. Import the project into Eclipse IDE.
3. Configure MySQL database credentials in `application.properties`.
4. Update database connection details.
5. Build the project using Maven.
6. Run the Spring Boot application.
7. Test REST APIs using Postman.

Deployment  :  

The Spring Boot application is deployed using Render.

Learning Outcomes  :  

- Understanding Spring Boot application development.
- Building RESTful web services.
- Implementing CRUD operations.
- Working with Spring Data JPA and Hibernate.
- Integrating MySQL with Spring Boot.
- Understanding Controller, Service, Repository, and DTO layers.
- Testing REST APIs using Postman.
- Deploying Spring Boot applications.

Developer  :  

**Vamsi Krishna**

Java Full Stack Developer

MCA Post Graduate
