# LAB 9 : Spring Boot Microservices

A simple microservices project built with Spring Boot, demonstrating communication between two independent services using **RestClient**.

## Services

### 1. Customer Service

- Port: `8080`
- Database: MongoDB
- Manages customer information (ID, name, and email).
- Supports CRUD operations.

### 2. Order Service

- Port: `8081`
- Database: MySQL
- Uses Spring Data JPA.
- Manages customer orders.
- Communicates with Customer Service using `RestClient`.
- Retrieves customer information using customer ID.

## Technologies Used

- Java
- Spring Boot
- Spring Data MongoDB
- Spring Data JPA
- MySQL
- MongoDB
- REST APIs
- RestClient
- Maven
- Postman

## Running the Project

1. Start MongoDB and MySQL.
2. Configure database credentials in each service's `application.properties` with your own MySQL password.
3. Run Customer Service on port `8080`.
4. Run Order Service on port `8081`.
5. Test the endpoints using Postman.

## Key Concept

The project demonstrates microservices architecture, where two independent services use separate databases and communicate through REST APIs using Spring's `RestClient`.

