# Customer Service

## Descripción

El **Customer Service** es un microservicio desarrollado en Java con Spring Boot, encargado de gestionar la información de los clientes dentro de una arquitectura de microservicios. Este servicio permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los clientes y envía eventos de creación o actualización de clientes a un sistema de mensajería basado en Apache Kafka, que pueden ser consumidos por otros microservicios, como `account-service`.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**: Para la persistencia en la base de datos MySQL.
- **MySQL**: Base de datos relacional utilizada para almacenar la información de los clientes.
- **Apache Kafka**: Utilizado para la mensajería entre microservicios.
- **Lombok**: Para reducir el código boilerplate.
- **Maven**: Gestión de dependencias y construcción del proyecto.

## Prerrequisitos

Antes de ejecutar este proyecto, asegúrate de tener instalado lo siguiente:

- **Java 17** o superior
- **Apache Maven 3.6** o superior
- **MySQL** (o una base de datos compatible)
- **Apache Kafka** y **Zookeeper**

## Configuración

### Configuración de la Base de Datos

1. Crea una base de datos en MySQL para el `customer-service`:

   ```sql
   CREATE DATABASE customerdb;
Actualiza las credenciales de la base de datos en el archivo application.yaml:

spring:
  datasource:
    url: jdbc:mysql://localhost:3306/customerdb
    username: your-username
    password: your-password

    
Configuración de Kafka
Asegúrate de que Apache Kafka y Zookeeper estén en funcionamiento en tu entorno.

Configura los servidores Kafka en el archivo application.yaml:

spring:
  kafka:
    bootstrap-servers: localhost:9092


Ejecución del Proyecto
Clona el repositorio:

git clone https://github.com/your-repo/customer-service.git
cd customer-service

Compila y empaqueta el proyecto con Maven:

mvn clean install

Ejecuta la aplicación:

mvn spring-boot:run
