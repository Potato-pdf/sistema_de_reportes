# Reportes Backend

Sistema de automatización de reportes personalizados para agentes de seguros.

## Tecnologías principales
- Spring Boot 3.2
- PostgreSQL (Docker)
- Spring Data JPA
- Spring Security + JWT
- Swagger/OpenAPI 3.0
- Thymeleaf
- Actuator + Micrometer
- JUnit 5, Mockito, Testcontainers
- Gmail API, Google Calendar API

## Estructura de carpetas
- src/main/java/com/quarksoft/reportes/[controller|service|repository|entity|dto|config|exception|util|integration]
- src/main/resources
- src/test/java/com/quarksoft/reportes

## Configuración de la base de datos
Levanta la base de datos PostgreSQL con Docker Compose:

```
docker-compose up -d
```

La base de datos estará disponible en localhost:5432 con:
- Base de datos: reportes_db
- Usuario: reportes_user
- Contraseña: reportes_pass

## Instrucciones de desarrollo
1. Configura el archivo `application.yml` para conectar con la base de datos.
2. Ejecuta el proyecto Spring Boot desde tu IDE o con `mvn spring-boot:run`.
3. Accede a la documentación Swagger en `/swagger-ui.html`.

## Control de versiones
- Utiliza ramas por versión (v1.0.0, v1.1.0, etc.) para mantener el control en GitHub.

---

Para más detalles, consulta la documentación interna y los comentarios en el código.
