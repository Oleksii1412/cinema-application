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
The application provides access for the customer through the endpoints, which let ability monitor and interact with the application.
The web service utilizes the standard HTTP verbs, and arranges a set of the REST endpoints that cover the usual Create, Read, Update, and Delete (CRUD) operations:

- User
- Admin
- Unauthorized


| HTTP<br/>VERB | DESCRIPTION                                                | ROLE PERMISSION | Request Body                                                                                                                                | URL                                                     |
|---------------|------------------------------------------------------------|-----------------|---------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------|
| `POST`        | Enables to define custom backend and frontend templates.   | Permit All      | `{"email":"your@email.com", "password":"your password", "repeatPassword":"your password"}`                                                  | `/register`                                             |
| `GET`         | Enables to define custom backend and frontend templates.   | ADMIN, USER     | `None`                                                                                                                                      | `/cinema-halls`, `/movies`, `/movie-sessions/available` |
| `GET`         | Enables to define custom backend and frontend templates.   | ADMIN           | `None`                                                                                                                                      | `/users/by-email`                                       |
| `POST`        | Enables to define custom backend and frontend templates.   | ADMIN           | `{"capacity":integer, "description":"Cinema hall description"}`,<br/> `{"title":"Movie title", "description":"Movie description"}`,<br/> `` | `/cinema-halls`,<br/> `/movies`,<br/> `/movie-sessions`                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   |                 | `false`                                                                                                                                     | No                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   | Permit All      | `false`                                                                                                                                     | No                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   | Permit All      | `false`                                                                                                                                     | No                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   | Permit All      | `false`                                                                                                                                     | No                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   | Permit All      | `false`                                                                                                                                     | No                                                      |
| `DELETE`      | Enables to define custom backend and frontend templates.   | Permit All      | `false`                                                                                                                                     | No                                                      |


## :wrench: Application technologies used

- Java 11
- Maven
- MySQL
- Tomcat
- Hibernate
- Spring Framework Core
- Spring MVC
- Spring Security
