Skip The Dishes & VanHack
===

The purpose of this project is to provide an API of rewards for the restaurant's customers.

# Stack

* Java 8
* Spring Boot
* MySQL
* Docker
* Heroku
* Swagger

# Running

You need to have the MySQL running on default port to the project run properly. 

This is also required to run the unit tests.  

````bash
# run all the required applications
$ docker-compose up
````

## Locally
```
mvn -Dspring.profiles.active=local spring-boot:run
```

## Heroku
The auto deployment is enabled using the *master* git branch

```
https://vh-skipthedishes-backend.herokuapp.com/
```


# API Documentation

The API is auto-generated using the Swagger pattern and is accessible through the following URI:

```
http://localhost:8080/swagger-ui.html
```
