# Todo List API

## Descripción del Proyecto
Este proyecto es una API RESTful de gestión de tareas (Todo List) implementada con Spring Boot. La aplicación proporciona operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para tareas, utilizando PostgreSQL como base de datos principal y Redis para caché, optimizando así el rendimiento de las operaciones de lectura frecuentes.

## Requisitos
- Java JDK 17 o superior
- Docker
- Docker Compose
- Maven (opcional, incluido en el wrapper)

## Instrucciones de Instalación

### 1. Clonar el Repositorio
```bash
git clone [URL_DEL_REPOSITORIO]
cd [NOMBRE_DEL_DIRECTORIO]
```

### 2. Instalación de Dependencias
El proyecto utiliza Maven para la gestión de dependencias. Las principales dependencias incluyen:
- Spring Boot 3.4.0
- Spring Data JPA
- Spring Data Redis
- PostgreSQL Driver
- Lombok
- Spring Boot Test
- Rest Assured (para pruebas)

Las dependencias se instalarán automáticamente al construir el proyecto.

### 3. Variables de Entorno
Las variables de entorno están configuradas en el archivo `compose.yml`:
- `DATABASE_URL`: URL de conexión a PostgreSQL
- `DATABASE_USERNAME`: Usuario de PostgreSQL
- `DATABASE_PASSWORD`: Contraseña de PostgreSQL
- `SPRING_REDIS_HOST`: Host de Redis
- `SPRING_REDIS_PORT`: Puerto de Redis

## Ejecución Local

### 1. Usando Docker Compose
```bash
# Iniciar todos los servicios
docker compose up -d

# La aplicación estará disponible en http://localhost:8080
```

Este comando iniciará:
- La aplicación Spring Boot (puerto 8080)
- PostgreSQL (puerto 5434)
- Redis (puerto 6379)

### 2. Usando Maven (Desarrollo)
```bash
# Construir el proyecto
./mvnw clean package

# Ejecutar la aplicación
./mvnw spring-boot:run
```

### Endpoints de la API
- `GET /api/tasks` - Listar todas las tareas
- `GET /api/tasks/{id}` - Obtener una tarea específica
- `POST /api/tasks` - Crear una nueva tarea
- `PUT /api/tasks/{id}` - Actualizar una tarea
- `DELETE /api/tasks/{id}` - Eliminar una tarea

## Pruebas

### Pruebas Unitarias
```bash
# Ejecutar pruebas unitarias
mvn test -Dtest=UnitTest
```
Estas pruebas verifican la lógica de negocio y los servicios individuales.

### Pruebas de Integración
```bash
# Ejecutar pruebas de integración con Redis
mvn test -Dtest=RedisTest
```
Verifican la integración correcta con Redis y el funcionamiento del caché.

### Pruebas de Sistema
```bash
# Ejecutar pruebas de sistema
mvn test -Dtest=SystemTest
```
Pruebas end-to-end que verifican el funcionamiento completo de la aplicación.

## Tecnologías Usadas

### Backend
- **Framework**: Spring Boot 3.4.0
- **Lenguaje**: Java 17
- **Gestión de Dependencias**: Maven

### Bases de Datos
- **Principal**: PostgreSQL 15
  - Almacenamiento persistente de tareas
- **Caché**: Redis
  - Mejora del rendimiento en operaciones de lectura

### Contenedorización
- Docker
- Docker Compose
  - Orquestación de servicios
  - Configuración de entorno de desarrollo

### Testing
- JUnit
- Spring Boot Test
- Rest Assured
- Embedded Redis (para pruebas)
- H2 Database (para pruebas)

### Herramientas de Desarrollo
- Lombok
- Spring Data JPA
- Spring Web
- Maven Wrapper
