
# Pizza Builder Backend Application

## The study project for pizza constructor

The app uses EAV table and class structure for dynamic entity/attribute/value grow, as well as REST API endpoint to create these data.

## Prerequisites
* **JDK >=11.0.7**;
* **Apache Maven >= 3.6.**
* **Docker version >= 19.**
* **docker-compose >= 1.**


## Use:
- to setup a mysql db, from src folder run
```
docker-compose up -d && docker exec **project_name**_db_1 mysql -uroot -proot pizza < pizza1.sql1
```
- to run application
```
mvn clean install && mvn spring-boot:run
```
- to install frontend application please go: https://github.com/Kateryna-Matvieieva/pizza-constructor
