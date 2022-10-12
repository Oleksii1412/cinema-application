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

![3-tier](https://user-images.githubusercontent.com/96411307/195352492-87b76182-054a-496f-9553-c87b7846fe05.png)


#### Role functionality
The application provides access for the customer through the endpoints, which let ability monitor and interact with the application.
The web service utilizes the standard HTTP verbs, and arranges a set of the REST endpoints that cover the usual Create, Read, Update, and Delete (CRUD) operations.

The application supports three type of roles:
- User
- Admin
- Unauthorized(default)

Each role has limited access to the certain resources:

| HTTP<br/>VERB | DESCRIPTION                                                                                                                                 | ROLE PERMISSION |                                            Request URL pattern                                             |                                                                                                            Request Body                                                                                                            |                                    URL                                     |
|:-------------:|---------------------------------------------------------------------------------------------------------------------------------------------|:---------------:|:----------------------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------:|
|    `POST`     | Register a new account with role USER.                                                                                                      |   Permit All    |                                                                                                            |                                                                     `{"email":"your@email.com", "password":"your password", "repeatPassword":"your password"}`                                                                     |                                `/register`                                 |
|     `GET`     | Retrieve information about cinema halls, movies or available movies sessions by movie identifier.                                           |   ADMIN, USER   | a) `/cinema-halls`;<br/> b) `/movies`;<br/> c) `/movie-sessions/available?movieId=integer&date=dd.mm.yyyy` |                                                                                                               `None`                                                                                                               | a) `/cinema-halls`;<br/> b) `/movies`;<br/> c) `/movie-sessions/available` |
|     `GET`     | Find a particular user by email.                                                                                                            |      ADMIN      |                                   `/users/by-email?email=your@email.com`                                   |                                                                                                               `None`                                                                                                               |                             `/users/by-email`                              |
|    `POST`     | Add a new cinema hall, movie, or movie session via request body.                                                                            |      ADMIN      |                                                                                                            | a) `{"capacity":integer, "description":"Cinema hall description"}`;<br/> b) `{"title":"Movie title", "description":"Movie description"}`;<br/> c) `{"movieId":integer, "cinemaHallId":integer, "showTime": "yyyy-mm-ddThh:mm:ss"}` |      a) `/cinema-halls`;<br/> b) `/movies`;<br/> c) `/movie-sessions`      |
|     `PUT`     | Update an existing movie session by input movie session identifier.                                                                         |      ADMIN      |                                                                                                            |                                                                          `{"movieId":integer, "cinemaHallId":integer, "showTime": "yyyy-mm-ddThh:mm:ss"}`                                                                          |                           `/movie-sessions/{id}`                           |
|   `DELETE`    | Delete an existing movie session by input movie session identifier.                                                                         |      ADMIN      |                                                                                                            |                                                                                                               `None`                                                                                                               |                           `/movie-sessions/{id}`                           |
|     `GET`     | a) Retrieve order history based on current authenticated user.<br/> b) Find a particular shopping cart based on current authenticated user. |      USER       |                                                                                                            |                                                                                                               `None`                                                                                                               |              a) `/orders`;<br/> b) `/shopping-carts/by-user`               |
|    `POST`     | Accomplish a particular order based on current authenticated user.                                                                          |      USER       |                                                                                                            |                                                                                                               `None`                                                                                                               |                             `/orders/complete`                             |
|     `PUT`     | Update an existing shopping based on current authenticated user and by input movie session identifier.                                      |      USER       |                          `/shopping-carts/movie-sessions?movieSessionId=integer`                           |                                                                                                              `false`                                                                                                               |                      `/shopping-carts/movie-sessions`                      |



## :wrench: Application technologies used

- Java 11
- Maven
- MySQL
- Tomcat
- Hibernate
- Spring Framework Core
- Spring MVC
- Spring Security

## How to run this application? 

1. Clone this project to your IDE as Maven project then open it.
2. Check a pom.xml file if any errors are occurred - fix them.
3. Configure a Tomcat. In the deployment: add the artifact cinema-application:war exploded and Set application context field as "/". Use a URL as http://localhost:8080/
4. Install and configure a MySQL with Workbench.
5. Create a schema in the MySQL Workbench.
6. At the src.main.resources.db.properties use a driver, path to the schema, your username and password, for connection to DB.
7. Run the project.
8. To test the application use a Postman or analog platform.

On the initial start up the application creates a user with role _ADMIN_ which has basic email = "admin@cinema.com" and password = "admin123".
You have ability to create a new User with role User(by default). For example, to be authorized through the Postman, you must add a new header, then enter your email and password which you used during registration process.

## Application structure

![structure](https://user-images.githubusercontent.com/96411307/195362127-6f2243d5-6124-4d10-9cdf-092dc7fcb4c1.png)

## Author
_Oleksii Akishev_