- simple running app following
  https://www.codejava.net/frameworks/spring-boot/spring-boot-crud-example-with-spring-mvc-spring-data-jpa-thymeleaf-hibernate-mysql#Project
- updade to docker with
https://the-codeslinger.com/2020/04/26/integration-testing-with-docker-maven-plugin-postgresql-flyway/
- go to the rest goals
- swagger doc with
  https://www.baeldung.com/spring-rest-openapi-documentation


4 ПУНКТ
Списки продуктов должны возвращаться постранично
https://stackoverflow.com/questions/12168624/pagination-response-payload-from-a-restful-api


Трехслойная архитектура
https://alexkosarev.name/2018/07/27/n-tier-java-part1/
https://russianblogs.com/article/8297347415/


требования к интерфейсам
UI
Pages
/products
/product/:id (with get/update)
Data validation
Name* not null
CurPrice - list

Price* >0
Currency list (dropdown)

/product/create

Продукт
Аттрибуты
id
name
description
price
created_at
modified_at

Методы
get(id)
update(id)
create()

Список
getAll

https://www.baeldung.com/spring-boot-postgresql-docker

TBUpgraded
- product1 NCurrency-Price
Mat - RU-12
Mat - EUR-1
...

application.properties ??
postgres=# create database docker_db_testing;
CREATE DATABASE
postgres=# create role docker_db_testing WITH LOGIN NOSUPERUSER INHERIT CREATEDB NOCREATEROLE NOREPLICATION PASSWORD 'docker_db_testing';
CREATE ROLE
postgres=# GRANT CREATE, CONNECT ON DATABASE docker_db_testing TO docker_db_testing;
GRANT


DOCKER
//docker insert some data when mounted
//docker pack project into docker container

TESTS
//api tests