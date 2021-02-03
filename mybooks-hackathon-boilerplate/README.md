[![pipeline status](https://gitlab.stackroute.in/mehersupreeth/mybooks-hackathon-boilerplate/badges/master/pipeline.svg)](https://gitlab.stackroute.in/mehersupreeth/mybooks-hackathon-boilerplate/-/commits/master)
# MyBooks - A Case Study

## Problem Statement

Build a system to search for a book title, show results, add books to favourite list.

## Requirements

### A REST API where the user can register/login to the application
### A REST API to add book details, search books by title or author, get books details, add book to favourite list.
### User can add a book to favourite list and should be able to view the favourite list.

## Microservices/Modules
- UserService - should be able to manage user accounts.
- BookService -  should be able to
    - Add new book details
    - Search a book by title or author
    - View book details
- FavouriteService - should be able to store and retrieve all the favourite books for a user

## Tech Stack
- Spring Boot
- MySQL, MongoDB
- CI (Gitlab Runner)
- Docker, Docker Compose
- AOP(for implementation of logging)

## Flow of Modules

- Building the UserService
  1. Creating a server in Spring Boot to facilitate user registration and login using     JWT token and MySQL
  2. Writing swagger documentation
  3. Unit Testing
  4. Write CI Configuration
  5. Dockerize the application
  6. Update the docker-compose

- Building the Book Service
  1. Building a server in Spring Boot to facilitate CRUD operation over books    stored in MongoDB
  2. Writing Swagger Documentation
  4. Write Test Cases
  5. Write CI Configuration
  6. Secure the API using JWT Token Validation
  7. Dockerize the application
  8. Update the docker-compose


- Building the Favourite Service
  1. Building a server in Spring Boot to facilitate CRUD operation over favourite books    stored in MongoDB
  2. Writing Swagger Documentation
  4. Write Test Cases
  5. Write CI Configuration
  6. Secure the API using JWT Token Validation
  7. Dockerize the application
  8. Update the docker-compose
