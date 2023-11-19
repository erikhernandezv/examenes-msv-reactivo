# examenes-msv-reactivo

_This is an demo application for Cedesistemas course, to learn Microservices Reactives with Spring Boot. The application has the following functionalities. Search, save, uodate and get all test, etc._

```
- 📦 Mircoservicio Reactivo en Spring Boot con WebFlux
```

## Comenzando 🚀

_Estas instrucciones te permitirán obtener una copia del proyecto en funcionamiento en tu máquina local para propósitos de desarrollo y pruebas._


### Pre-requisitos 📋

_Para desplegar la aplicación recuerda tener instaladas las herramientas necesaria como:_

```
Java 17, Spring Boot, Docker, PostgreSql
```

## Estructura de la App 📦

- `docker-compose.yml`: Es el archivo que define los servicios de Spring Boot y Postgres, así como sus propiedades y dependencias.
- `Dockerfile`: Es el archivo que describe cómo construir la imagen de Docker para la aplicación de Spring Boot.
- `README.md`: Es este archivo que contiene la documentación del proyecto.
- `src/main/java`: Es el directorio que contiene el código fuente de la aplicación de Spring Boot, organizado por paquetes.
- `src/main/resources`: Es el directorio que contiene los recursos de la aplicación de Spring Boot, como el archivo de propiedades.
- `src/test/java`: Es el directorio que contiene el código de prueba de la aplicación de Spring Boot, usando JUnit y Mockito.

## Ejecutando la App 📦

Para ejecutar el proyecto, solo tienes que ejecutar el siguiente comando desde el directorio raíz:


docker compose up


Este comando creará las imágenes de Docker para Spring Boot y Postgres, y las ejecutará en contenedores. También creará una red interna para que los contenedores se comuniquen entre sí.

Puedes verificar el estado de los contenedores con el siguiente comando:


docker compose ps


Deberías ver una salida similar a esta:


Name                     Command              State           Ports

app java -jar app.jar Up 0.0.0.0:6090->6090/tcp db docker-entrypoint.sh Up 0.0.0.0:5432->5432/tcp postgres


Esto significa que la aplicación de Spring Boot está escuchando en el puerto 6090, y la base de datos Postgres está escuchando en el puerto 5432.

## Construido con 🛠️

_La aplicación fue desarrollada con _

* [Java 17](https://www.java.com/en/) - Java is a set of computer software and specifications that provides a software platform for developing application software and deploying it in a cross-platform computing environment. Java is used in a wide variety of computing platforms from embedded devices and mobile phones to enterprise servers and supercomputers.
* [Spring Boot](https://spring.io/projects/spring-boot/) - Spring Boot Extension es la solución de convención sobre configuración de Spring destinada a ayudar a crear aplicaciones Spring de nivel de producción con cantidades mínimas de configuración.
* [Postgres](https://getbootstrap.com/) - Botor de Base de datos relacional, Open Source


## Versionado 📌

Usamos [git](https://git-scm.com/) para el versionado. Para todas las versiones disponibles, mira los [tags en este repositorio](https://github.com/erikhernandezv/librero-mcs-one).

## Autor ✒️

* **Erik Darío Hernández Vásquez** - *Trabajo Inicial* - [erikhernandezv](https://github.com/erikhernandezv)

## Expresiones de Gratitud 🎁

* Este proyecto lo desarrolle durante el curso de microservicios con Spring Boot ofrecido a en Bancolombia e impartido por Cedesistemas 📢
* Agradezco tus colaboraciones o sugerencias y nuevos retos, brindemos virtualmente con una 🍺 o un café.
* Puerdes escribirme en @ErikHernandezV o erikdhv@gmail.com 🤓.
* etc.



---
⌨️ con ❤️ por [erikhernandezv](https://github.com/erikhernandezv) 😊
