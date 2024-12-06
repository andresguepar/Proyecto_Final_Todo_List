# Documentación de Ejecución del Proyecto

Este documento describe las dos formas principales de ejecutar el proyecto: localmente con Java/Maven y usando Docker.

## 1. Ejecución Local con Java/Maven

### Requisitos Previos
- Java JDK 17
- Maven (o usar el Maven Wrapper incluido)
- PostgreSQL instalado localmente
- Redis instalado localmente

### Pasos de Ejecución

1. **Configurar Base de Datos Local**
   - Asegúrate de tener PostgreSQL ejecutándose en el puerto 5432
   - Crea una base de datos llamada `todolist`
   ```sql
   CREATE DATABASE todolist;
   ```

2. **Configurar Redis Local**
   - Asegúrate de tener Redis ejecutándose en el puerto 6379
   ```bash
   redis-server
   ```

3. **Construir el Proyecto**
   ```bash
   ./mvnw clean package
   ```

4. **Ejecutar la Aplicación**
   ```bash
   ./mvnw spring-boot:run
   ```

5. **Verificar la Ejecución**
   - La aplicación estará disponible en `http://localhost:8080`
   - Puedes probar los endpoints:
     * GET `http://localhost:8080/api/tasks`
     * POST `http://localhost:8080/api/tasks`
     * etc.

### Problemas Comunes en Ejecución Local
- **Error de conexión a PostgreSQL**: Verifica que PostgreSQL esté ejecutándose y las credenciales sean correctas
- **Error de conexión a Redis**: Asegúrate que Redis esté iniciado correctamente
- **Error de puertos**: Verifica que los puertos 8080, 5432 y 6379 estén disponibles

## 2. Ejecución con Docker

### Requisitos Previos
- Docker
- Docker Compose

### Pasos de Ejecución

1. **Construir y Ejecutar con Docker Compose**
   ```bash
   docker-compose up -d
   ```
   Este comando:
   - Construye la imagen de la aplicación
   - Inicia PostgreSQL en el puerto 5434
   - Inicia Redis en el puerto 6379
   - Inicia la aplicación en el puerto 8080

2. **Verificar los Contenedores**
   ```bash
   docker-compose ps
   ```
   Deberías ver tres contenedores ejecutándose:
   - todolist_app
   - todolist_db (PostgreSQL)
   - redis

3. **Verificar la Ejecución**
   - La aplicación estará disponible en `http://localhost:8080`
   - Los logs se pueden ver con:
     ```bash
     docker-compose logs -f todolist_app
     ```

### Detener los Servicios
```bash
docker-compose down
```

### Problemas Comunes en Docker
- **Error de puertos en uso**: Verifica que los puertos 8080, 5434 y 6379 estén libres
- **Error de permisos**: Asegúrate de tener permisos para ejecutar Docker
- **Error de memoria**: Verifica que Docker tenga suficientes recursos asignados

## 3. Ejecutar Pruebas

Las pruebas se pueden ejecutar en ambos entornos:

### Local
```bash
./mvnw test
```

### Docker
```bash
docker-compose run todolist_test
```
## 4. Notas Importantes
- Asegúrate de que la base de datos esté configurada correctamente en `application.properties` para evitar problemas de conexión.
- Si experimentas problemas al iniciar la aplicación, verifica los logs de la consola para obtener más información sobre los errores.
