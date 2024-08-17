# Quiz Harvest Server

## Descripción
Quiz Harvest Server es una aplicación backend desarrollada en Java utilizando Spring Boot. Su propósito es gestionar y crear cuestionarios a partir de archivos XML y proporcionar una API para interactuar con estos cuestionarios.

## Características
- **Carga de archivos**: Permite cargar archivos XML para generar preguntas.
- **Creación de cuestionarios**: Genera cuestionarios basados en las preguntas almacenadas.
- **API REST**: Proporciona endpoints para interactuar con los cuestionarios y preguntas.

## Tecnologías Utilizadas
- **Java**
- **Spring Boot**
- **Maven**
- **MySQL**
- **XML**
- **JUnit**

## Instalación
1. Clona el repositorio:
    ```bash
    git clone https://github.com/tu-usuario/quiz-harvest-server.git
    ```
2. Navega al directorio del proyecto:
    ```bash
    cd quiz-harvest-server
    ```
3. Compila el proyecto con Maven:
    ```bash
    mvn clean install
    ```
4. Configura la base de datos en el archivo `application.properties`.
5. Ejecuta la aplicación:
    ```bash
    mvn spring-boot:run
    ```

## Testing
Para ejecutar los tests, utiliza el siguiente comando:
```bash
mvn test
