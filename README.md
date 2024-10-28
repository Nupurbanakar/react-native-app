# React-native-app

# Form Application

A Spring Boot application with simple user registration and login functionality, including basic error handling and status responses. This application is designed as a REST API with endpoints for user authentication.

## Table of Contents
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [Endpoints](#endpoints)
  - [User Registration](#user-registration)
  - [User Login](#user-login)

## Features
- **User Registration**: Allows new users to register.
- **User Login**: Enables users to log in with error handling for invalid credentials.

## Technologies Used
- Java 22
- Spring Boot
  - Spring Web
  - Spring Boot Starter Actuator
- Spring Security
- JUnit & Mockito for unit testing

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6.0 or higher
- (Optional) Postman for testing API endpoints

### Installation
1. Clone the repository:
    ```bash
    git clone https://github.com/your-username/form-application.git
    cd form-application
    ```
2. Build the application:
    ```bash
    mvn clean install
    ```

### Running the Application
To run the application locally:
```bash
mvn spring-boot:run
