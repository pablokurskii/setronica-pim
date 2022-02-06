## Spring MVC + REST API Product Management Application

1. Excecute docker/runDb.bat
2. Run SetronicaPimApplication.java or `mvnw spring-boot:run`

All products page + Homepage \
http://localhost:8080/

New product page \
http://localhost:8080/new

Edit product page \
http://localhost:8080/edit/{id}


Stack:
- Java 1.8
- Spring Boot 2.6+
- REST, OpenAPI
- Flyway
- PostgreSQL
- Logback
- Thymeleaf
- VueJS
- Bootstrap

[API documentation](http://localhost:8080/swagger-ui.html) \
Application configs are located in `src/main/resources/setronica.yml` file. \
Credits are located in HELP.md file.

### Example REST queries

* `GET product/{id}`

Request:

`localhost:8080/api/product/3?language=us&currency=usd`

Response:

`{
"id": 3,
"name": "[{\"name\":\"table\",\"lang\":\"us\"}]",
"description": "[{\"description\":\"table description\",\"lang\":\"us\"}]",
"prices": "[{\"price\":0.01,\"cur\":\"usd\"}]",
"createdDate": 1644161477583,
"modifiedDate": 1644161477583
}`

* `GET product` 

Request: 

`localhost:8080/api/product?name=table&language=us&currency=usd` 

Response: 

`[
    {
        "id": 3,
        "name": "[{\"name\":\"table\",\"lang\":\"us\"}]",
        "description": "[{\"description\":\"table description\",\"lang\":\"us\"}]",
        "prices": "[{\"price\":0.01,\"cur\":\"usd\"}]",
        "createdDate": 1644161477583,
        "modifiedDate": 1644161477583
    }
]`





