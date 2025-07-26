<h1 align="center">Challenge LiterAlura 📚</h1> <p align="left"> <img src="https://img.shields.io/badge/STATUS-%20TERMINADO-green"> </p>
Aplicación Java con Spring Boot que consume la API pública de Gutendex para buscar libros, autores, idiomas y almacenar los resultados en una base de datos relacional. Además, permite realizar búsquedas, listados y estadísticas a través de un menú interactivo.

# 🔨 Funcionalidades principales
✅ Buscar libros por título desde la API.

✅ Guardar libros y autores en base de datos.

✅ Listar todos los libros registrados.

✅ Listar todos los autores registrados.

✅ Buscar autores nacidos antes de un año determinado.

✅ Listar libros por idioma.

✅ Mostrar estadísticas: cantidad de libros por idioma.

✅ Menú interactivo en consola.

# 🚀 Instrucciones de uso
Clonar el repositorio
```bash
git clone https://github.com/reganst93/conversor-de-monedas-desafio-alura.git
cd LiterAlura
```
Configurar base de datos (PostgreSQL)
Crea una base de datos llamada literalura y configura tu application.properties así:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
# 📁 Estructura del Proyecto
```src/

src/
├── main/
│   ├── java/
│   │   ├── com.liter.alura/
│   │   │   ├── api/                 ← Consumo de la API externa
│   │   │   ├── model/               ← Entidades JPA (Libro, Autor)
│   │   │   ├── repository/          ← Repositorios Spring Data JPA
│   │   │   ├── dto/                 ← Clases DTO para datos limpios
│   │   │   ├── service/             ← Lógica de conversión y búsqueda
│   │   │   └── Principal/       ← Clase principal con el menú interactivo
│   └── resources/
│       └── application.properties   ← Configuración de la base de datos
```

# 📦 Dependencias
Spring Boot Starter Web

Spring Boot Starter Data JPA

PostgreSQL Driver

Gson (para convertir JSON de la API a objetos Java)

# ⚙️ Tecnologías Utilizadas
<p align="center"> <img src="https://skillicons.dev/icons?i=java,spring,postgresql,git" /> </p> <img src="https://img.shields.io/badge/IDE-IntelliJ%20IDEA-blue?logo=intellij-idea&logoColor=white" />
Java 17+

Spring Boot 3

Gson para deserialización JSON

JPA + Hibernate

PostgreSQL como base de datos

Gutendex API para obtención de datos públicos de libros

# 🙌 Agradecimientos
Gracias a Gutendex por ofrecer una API abierta con datos literarios del Proyecto Gutenberg.
Este proyecto fue desarrollado con fines educativos como parte del programa de formación de Alura Latam + Oracle Next Education.