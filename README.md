
# Pizza Builder Backend Application

## The study project for pizza constructor

The app uses EAV table and class structure for dynamic entity/attribute/value grow, as well as REST API endpoint to create these data.

## Prerequisites
* **JDK >=11.0.7**;
* **Apache Maven >= 3.6.*

## Use:
- to setup a mysql db, from src folder run
```
docker-compose up -d && mysql -uroot -h127.0.0.1 -e 'create database pizza' && mysql -uroot -h127.0.0.1 < pizza1.sql
```
- to run application
```
mvn spring-boot:run
```
- to install frontend application please go: https://github.com/Kateryna-Matvieieva/pizza-constructor
