# Spring Boot Cricket Management System

A Spring Boot web application developed to manage cricket-related information using two entities: **Team** and **Cricketer**. The project demonstrates a layered architecture using **Controller, Service, Repository, and View** layers, and supports **Create, Read, and Update** operations through JSP pages.

## Project Overview

This application was built as part of a Spring Boot assignment to understand how a full-stack Java web application works using:

- Spring Boot
- Spring MVC
- Spring Data JPA
- H2 Database
- JSP
- JSTL
- Maven
- JUnit and Mockito

The system manages cricket data by maintaining records of teams and cricketers. Each cricketer belongs to one team, and each team can have multiple cricketers.

## Features

- Create new teams
- Create new cricketers
- View list of all teams
- View list of all cricketers
- Update existing cricketer details
- Custom JPQL query using inner join between `Cricketer` and `Team`
- Sample data automatically inserted into the database
- Basic exception handling for invalid or duplicate data
- Unit testing for service and repository layers

## Entity Relationship Design

The application contains the following two entities:

### 1. Team
Attributes:
- `id`
- `name`
- `coach`

Relationship:
- One team can have many cricketers

### 2. Cricketer
Attributes:
- `id`
- `name`
- `role`
- `runs`
- `team`

Relationship:
- Each cricketer belongs to one team

### Relationship Type

- `@OneToMany` in `Team`
- `@ManyToOne` in `Cricketer`

This represents a **one-to-many** relationship between Team and Cricketer.

## Tech Stack

| Technology | Purpose |
|-----------|---------|
| Spring Boot | Application framework |
| Spring MVC | Web layer and controllers |
| Spring Data JPA | Database operations |
| H2 Database | In-memory database |
| JSP | View layer |
| JSTL | JSP data rendering |
| Maven | Build and dependency management |
| JUnit | Unit testing |
| Mockito | Mocking in service tests |

## Project Structure

```text
src
├── main
│   ├── java
│   │   └── com.akshitha.cricketmanagement
│   │       ├── config
│   │       ├── controller
│   │       ├── entity
│   │       ├── repository
│   │       ├── service
│   │       └── CricketManagementApplication.java
│   ├── resources
│   │   └── application.properties
│   └── webapp
│       └── WEB-INF
│           └── jsp
│               ├── team-list.jsp
│               ├── team-form.jsp
│               ├── cricketer-list.jsp
│               ├── cricketer-form.jsp
│               └── cricketer-edit.jsp
└── test
    └── java
        └── com.akshitha.cricketmanagement
```

## Database Population

The database is automatically created using JPA and populated with sample data at startup.

### Sample Team Data
- RCB – Andy Flower
- MI – Mark Boucher
- CSK – Stephen Fleming
- KKR – Chandrakant Pandit
- RR – Kumar Sangakkara
- SRH – Daniel Vettori
- DC – Ricky Ponting
- GT – Ashish Nehra
- PBKS – Trevor Bayliss
- LSG – Justin Langer

### Sample Cricketer Data
- Virat Kohli
- Faf du Plessis
- Rohit Sharma
- Jasprit Bumrah
- MS Dhoni
- Ravindra Jadeja
- Shreyas Iyer
- Sanju Samson
- Pat Cummins
- Rishabh Pant

A total of **10 records** are inserted into each table to satisfy the assignment requirement.

## CRUD Operations

### Create Operation

The application provides JSP forms to add new teams and cricketers.

#### Team Create
- User enters team name and coach
- Data is submitted to the controller
- Controller passes data to the service layer
- Service saves data through repository

#### Cricketer Create
- User enters cricketer name, role, runs, and selects team
- Form is submitted to the controller
- Controller validates and sends data to service
- Service saves cricketer in database

### Read Operation

The application displays:

- List of all teams
- List of all cricketers
- Inner join result showing cricketer details along with team name

The controller fetches data from the service layer and sends it to JSP pages using the model object.

### Update Operation

The application allows updating cricketer details.

- Existing cricketer data is loaded into the edit form
- User changes details such as name, role, runs, or team
- Updated information is submitted to controller
- Service updates the record in database

## Repository Layer

Repository interfaces extend `JpaRepository` for database operations.

### TeamRepository
Handles all database operations related to teams.

### CricketerRepository
Handles all database operations related to cricketers.

Includes custom JPQL query:

```java
@Query("SELECT c.name, c.role, c.runs, t.name FROM Cricketer c INNER JOIN c.team t")
List<Object[]> fetchCricketerTeamDetails();
```

This query performs an **inner join** between `Cricketer` and `Team`.

## Service Layer

The service layer contains business logic and connects the controller layer with the repository layer.

### TeamService
- Save team
- Get all teams
- Get team by ID

### CricketerService
- Save cricketer
- Get all cricketers
- Get cricketer by ID
- Update cricketer
- Fetch joined cricketer-team data

## Controller Layer

The controller layer handles incoming HTTP requests and maps them to the appropriate service methods.

### TeamController
Handles:
- View teams
- Show add team form
- Save team

### CricketerController
Handles:
- View cricketers
- Show add cricketer form
- Save cricketer
- Show edit form
- Update cricketer

## View Layer

The view layer is implemented using **JSP pages** and styled with simple CSS.

### JSP Pages Used
- `team-list.jsp`
- `team-form.jsp`
- `cricketer-list.jsp`
- `cricketer-form.jsp`
- `cricketer-edit.jsp`

### UI Features
- Clean table-based display
- Styled forms
- Navigation buttons between pages
- Basic responsive layout with CSS styling

## Validation and Exception Handling

The application uses validation annotations such as:

- `@NotBlank`
- `@Min`
- `@NotNull`

Exception handling is added in service and controller layers to manage:
- Invalid form data
- Integrity violations
- Missing records

## Testing

Unit testing is done using:

- **JUnit**
- **Mockito**

### Tests Included
- Repository test for custom join query
- Service test for saving cricketer data

These tests ensure the correctness of core business logic and database interaction.

## How to Run the Project

### Prerequisites
- Java 17
- Maven
- IntelliJ IDEA / Eclipse / VS Code

### Steps to Run

1. Clone the repository:
```bash
git clone https://github.com/KOTHAAKSHITHAGOUD/BDA2.git
```

2. Navigate to the project folder:
```bash
cd BDA2
```

3. Build the project:
```bash
mvn clean install
```

4. Run the application:
```bash
mvn spring-boot:run
```

5. Open in browser:
```text
http://localhost:9099/teams
http://localhost:9099/cricketers
```

> Note: Port may vary based on `application.properties`.

## H2 Database Console

If enabled, the H2 database console can be accessed at:

```text
http://localhost:9099/h2-console
```

### Example H2 Settings
- JDBC URL: `jdbc:h2:mem:cricketdb`
- Username: `sa`
- Password: *(leave empty)*

## Challenges Faced

Some of the challenges faced during development included:

- Understanding entity relationships and JPA mapping
- Configuring Spring Boot with JSP
- Writing a custom JPQL inner join query
- Handling validation and update operations
- Fixing dependency and port configuration issues during execution

## How the Challenges Were Solved

- Referred to Spring Boot and JPA documentation
- Used proper annotations for entity mapping
- Added required Maven dependencies for JSP, validation, and JPA
- Fixed package imports for Spring Boot 3 using `jakarta.*`
- Configured application port manually in `application.properties`

## Learning Outcomes

This project helped in understanding:

- Spring Boot layered architecture
- MVC flow in Java web applications
- JPA relationships and database operations
- JSP form handling and data binding
- Repository, service, and controller integration
- Unit testing with JUnit and Mockito

## Future Improvements

The project can be extended further by adding:

- Delete functionality
- Search and filter options
- Better UI design with Bootstrap
- Authentication and login
- MySQL integration instead of H2
- REST API version of the same project

## Author

**Kotha Akshitha Goud**  
BSc Computer Science, BITS Pilani  
Student ID: 2024EB01531

## GitHub Repository

Repository Link:  
[https://github.com/KOTHAAKSHITHAGOUD/BDA2](https://github.com/KOTHAAKSHITHAGOUD/BDA2)
