# Documentación de Ejecución de Aplicación y Pruebas en el Entorno Local

## 1. Requisitos Previos
- **Software necesario**:
  - Docker
  - Docker Compose
  - Java JDK 17
  - Maven
  - Redis (opcional, si se requiere para pruebas)

## 2. Ejecución de la Aplicación Localmente
Para construir y ejecutar la aplicación localmente, sigue estos pasos:
1. Asegúrate de que Java y Maven estén instalados en tu máquina.
2. Navega al directorio del proyecto donde se encuentra el archivo `pom.xml`.
3. Ejecuta el siguiente comando para construir la aplicación:
   ```bash
   mvn clean package
   ```
4. Una vez construido, ejecuta la aplicación con el siguiente comando:
   ```bash
   mvn spring-boot:run
   ```
5. La aplicación estará disponible en `http://localhost:8080`.

## 3. Ejecución de las Pruebas Localmente
Para ejecutar las pruebas dentro del entorno local, utiliza el siguiente comando:
```bash
mvn test
```

### Problemas Comunes
- **Error de conexión a Redis**: Si ves un error relacionado con la conexión a Redis, asegúrate de que Redis esté instalado y en ejecución. Puedes instalar Redis localmente siguiendo estos pasos:
  1. Descarga e instala Redis desde [redis.io](https://redis.io/download).
  2. Inicia el servidor Redis con el comando:
     ```bash
     redis-server
     ```

- **Deshabilitar Redis**: Si no necesitas Redis para tu aplicación, puedes comentar o eliminar las siguientes líneas en `src/main/resources/application.properties`:
  ```properties
  spring.data.redis.host=localhost
  spring.data.redis.port=6379
  spring.data.redis.database=0
  ```

## 4. Detener la Aplicación
Para detener la aplicación, simplemente interrumpe el proceso en la terminal (Ctrl + C).

## 5. Notas Importantes
- Asegúrate de que la base de datos esté configurada correctamente en `application.properties` para evitar problemas de conexión.
- Si experimentas problemas al iniciar la aplicación, verifica los logs de la consola para obtener más información sobre los errores.
