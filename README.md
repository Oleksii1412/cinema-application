# 	:film_projector:Cinema application:film_projector:

## :pencil:General overview
A RESTful application developed utilized [Hibernate](https://hibernate.org/orm/what-is-an-orm/), [Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/index.html) frameworks
and represents a cinema tickets service based on roles access using registration and authentication policy.

## :woman_technologist:Project overview and architecture:man_technologist: 
The application adopts a **Dependency Injection (DI)** and **Inversion of Control (IoC)** patterns to achieve a good design of layered architecture 
and divides into three main categories: presentation, application, data. Each of the layers contains objects related to the particular concern it represents.

- The presentation layer (Controller). This layer provides the interaction between the user and the back-end resources and handles the input [HTTP](https://docs.oracle.com/cd/E19857-01/820-0258/abvns/index.html) requests from the client side.
- The application layer (Service). A business logic layer drives the core functionalities of the application.
- The data access layer (DAO). This layer is responsible for interacting with databases to save and restore the application data via [HQL](https://docs.jboss.org/hibernate/orm/3.3/reference/en-US/html/queryhql.html) queries.

![3-tier](https://user-images.githubusercontent.com/96411307/195382480-50c2196d-3738-420b-8818-c6b9b08d923f.png)

The application implements a **[Data Transfer Object](https://en.wikipedia.org/wiki/Data_transfer_object) (DTO)** Design Pattern which aggregates and encapsulates objects data for the transfer purpose. Models are mapped to DTOs and vice versa through a mapper component on the application layer.

## Feature set of the application
A customer can get access to the application through **[endpoints](https://kinsta.com/knowledgebase/api-endpoint/)**, which let ability monitor and interact with the application.
While a web service utilizes the standard HTTP verbs, and arranges a set of the REST endpoints that cover the usual Create, Read, Update, and Delete (CRUD) operations.

#### :technologist:The application supports three type of roles:
- User
- Admin
- Unauthorized(default)

Each role has restricted access to certain resources that can be accessed via the following endpoints:

| HTTP<br/>VERB | DESCRIPTION                                                                                                                                 | ROLE PERMISSION |                                                    REQUEST URL PATTERN                                                     |                                                                                                          REQUEST BODY                                                                                                           |                                   URL                                    |
|:-------------:|---------------------------------------------------------------------------------------------------------------------------------------------|:---------------:|:--------------------------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------:|
|    `POST`     | Register a new account with role **USER**.                                                                                                  |   Permit All    |                                                           `None`                                                           |                                                                   `{"email":"your@email.com", "password":"your password", "repeatPassword":"your password"}`                                                                    |                               `/register`                                |
|     `GET`     | Retrieve information about cinema halls and movies. Get available movie sessions by movie identifier and order date.                        |   ADMIN, USER   |          a) `/cinema-halls`<br/> b) `/movies`<br/> c) `/movie-sessions/available?movieId=integer&date=dd.mm.yyyy`          |                                                                                                             `None`                                                                                                              | a) `/cinema-halls`<br/> b) `/movies`<br/> c) `/movie-sessions/available` |
|     `GET`     | Find a particular user by email.                                                                                                            |      ADMIN      |                                           `/users/by-email?email=your@email.com`                                           |                                                                                                             `None`                                                                                                              |                            `/users/by-email`                             |
|    `POST`     | Add a new cinema hall, movie, or movie session via request body.                                                                            |      ADMIN      |                                                           `None`                                                           | a) `{"capacity":integer, "description":"Cinema hall description"}`<br/> b) `{"title":"Movie title", "description":"Movie description"}`<br/> c) `{"movieId":integer, "cinemaHallId":integer, "showTime":"yyyy-mm-ddThh:mm:ss"}` |      a) `/cinema-halls`<br/> b) `/movies`<br/> c) `/movie-sessions`      |
|     `PUT`     | Update an existing movie session by input movie session identifier.                                                                         |      ADMIN      |                                                 `/movie-sessions/integer`                                                  |                                                                         `{"movieId":integer, "cinemaHallId":integer, "showTime":"yyyy-mm-ddThh:mm:ss"}`                                                                         |                          `/movie-sessions/{id}`                          |
|   `DELETE`    | Delete an existing movie session by input movie session identifier.                                                                         |      ADMIN      |                                                 `/movie-sessions/integer`                                                  |                                                                                                             `None`                                                                                                              |                          `/movie-sessions/{id}`                          |
|     `GET`     | a) Retrieve order history based on current authenticated user.<br/> b) Find a particular shopping cart based on current authenticated user. |      USER       |                                                           `None`                                                           |                                                                                                             `None`                                                                                                              |              a) `/orders`<br/> b) `/shopping-carts/by-user`              |
|    `POST`     | Accomplish a particular order based on the current authenticated user.                                                                      |      USER       |                                                           `None`                                                           |                                                                                                             `None`                                                                                                              |                            `/orders/complete`                            |
|     `PUT`     | Update an existing shopping based on current authenticated user and by input movie session identifier.                                      |      USER       |                                  `/shopping-carts/movie-sessions?movieSessionId=integer`                                   |                                                                                                             `None`                                                                                                              |                     `/shopping-carts/movie-sessions`                     |

## :building_construction: Application technologies used

- Java 11
- Maven
- MySQL
- Tomcat
- Hibernate
- Spring Framework Core
- Spring MVC
- Spring Security

## :eyes:How to run this application?:eyes: 

1. Clone this project to your IDE as a Maven project then open it.
2. Check a pom.xml file if any errors have occurred - fix them.
3. Configure a Tomcat. In the deployment: add the artifact cinema-application:war exploded and Set application context field as "/". Use a URL as http://localhost:8080/
4. Install and configure a MySQL with Workbench.
5. Create a schema in the MySQL Workbench.
6. At the src.main.resources.db.properties use a driver, path to the schema, your username and password, for connection to DB.
7. Run the project.
8. To test the application use a Postman or analog platform.

:exclamation: On the initial start up the application creates a user with role **_ADMIN_** which has a basic email = "admin@cinema.com" and password = "admin123".
You are able to create a new User with role User (by default). For example, to be authorized through the Postman, you must add a new header, then enter your email and password which you used during the registration process.

## :bricks:Application structure

![structure](https://user-images.githubusercontent.com/96411307/195589249-74ca5873-c0c9-4f4f-af2e-3bf283fe683f.png)

## Author:man_student:
_Oleksii Akishev_
