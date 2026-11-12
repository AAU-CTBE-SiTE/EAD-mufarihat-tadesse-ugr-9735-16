# LAB 6 : Employee Management System Using Spring AOP

## 1. Project Description

This project demonstrates Aspect-Oriented Programming (AOP)
using Spring Boot.

It implements a simple Employee Management System with
CRUD operations and uses AOP to separate cross-cutting
concerns from the main business logic.

## 2. Technologies Used

- Java 23
- Spring Boot 4.1.2
- Maven
- Spring AOP
- AspectJ

## 3. Application Features

- Add employees
- Retrieve employees by ID
- Update employee information
- Delete employees
- Display all employees
- Prevent duplicate employee IDs
- Handle employee-related exceptions

## 4. AOP Concepts Implemented

### LoggingAspect
- @Before
- @After
- @AfterReturning

### PerformanceAspect
- @Around
- Method execution time measurement

### ExceptionAspect
- @AfterThrowing
- Exception monitoring

## 5. Project Structure

- model: Contains the Employee class.
- service: Contains employee business logic.
- aspect: Contains AOP implementations.

## 6. How to Run

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Reload Maven dependencies.
4. Run AopDemoApplication.java.
5. Observe the console output.

## 7. Storage

Employee records are stored temporarily in an ArrayList.
Data is not persisted after application shutdown.
