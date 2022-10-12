# Cinema application

## :pencil:General overview
A RESTful application developed utilized [Hibernate](https://hibernate.org/orm/what-is-an-orm/) and [Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/index.html) frameworks.
The application represents a cinema tickets service based on roles access using registration and authentication policy.

## Overview
The application adopts a **Dependency Injection (DI)** and **Inversion of Control (IoC)** patterns to achieve a good design of layered architecture 
and divides into three main categories: presentation, application, data. Each of the layers contains objects related to the particular concern it represents.

- The presentation layer (Controller). This layer provides the interaction between the user and the back-end resources and handles the input [HTTP](https://docs.oracle.com/cd/E19857-01/820-0258/abvns/index.html) requests from the client side.
- The application layer (Service). A business logic layer drives the core functionalities of the application.
- The data access layer (DAO). This layer is responsible for interacting with databases to save and restore the application data via HQL queries.




#### Role functionality
- User
    - `**Add** cinema halls, movies and movie sessions.`  
- Admin 
    - `**Add** tickets to cart, retrieve and overlook order history.`
- Unauthorized
    - `Register new profile.`

## :wrench: Application technologies used

- Java 11
- Maven
- MySQL
- Tomcat
- Hibernate
- Spring Framework Core
- Spring MVC
- Spring Security
