# 🧩 API REST – Gestión de Usuarios

API REST desarrollada con **Spring Boot** para la gestión de usuarios mediante operaciones **CRUD** completas.
Implementa arquitectura en capas, persistencia con **Spring Data JPA** y base de datos **MySQL**.

Proyecto backend enfocado en demostrar buenas prácticas de desarrollo y conocimientos fundamentales en Spring Framework.

---

## 🚀 Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Postman (para pruebas de la API)

---

## 📂 Estructura del proyecto
```
src/main/java/com/demo/api
├── controller          # Controladores REST
├── service             # Interfaces de servicio
├── service/impl        # Implementaciones de servicio
├── repository          # Repositorios JPA
├── model               # Entidades
└── DemoApiApplication.java
```

---

## ⚙️ Configuración del proyecto

### 1️⃣ Crear la base de datos
```sql
CREATE DATABASE usuarios_db;
```

### 2️⃣ Configurar credenciales (Variables de entorno)

Por motivos de seguridad, las credenciales de la base de datos **no están incluidas en el repositorio**.

La aplicación utiliza **variables de entorno** para configurar el acceso a MySQL.

#### Variables requeridas
```bash
DB_USER=tu_usuario_mysql
DB_PASSWORD=tu_password_mysql
```

#### Ejemplo en Linux / macOS
```bash
export DB_USER=mi_usuario
export DB_PASSWORD=mi_password
```

#### Ejemplo en Windows (PowerShell)
```powershell
setx DB_USER "mi_usuario"
setx DB_PASSWORD "mi_password"
```

#### Configuración en IntelliJ IDEA

1. Ir a **Run > Edit Configurations**
2. Seleccionar la configuración de Spring Boot
3. Agregar las variables de entorno:
```
   DB_USER=mi_usuario
   DB_PASSWORD=mi_password
```
4. Guardar y ejecutar la aplicación

#### Archivo de referencia

El repositorio incluye el archivo `application-example.properties` como ejemplo de configuración. Este archivo no contiene credenciales reales.

> Spring Boot creará automáticamente la tabla `usuarios` al iniciar la aplicación.

---

## ▶️ Ejecución del proyecto

1. Clonar el repositorio:
```bash
git clone https://github.com/AnderssonEspinoza/springboot-api-usuarios.git
cd springboot-api-usuarios
```

2. Abrir el proyecto en IntelliJ IDEA

3. Ejecutar la clase principal:
```
   DemoApiApplication.java
```

4. La API estará disponible en:
```
   http://localhost:8080
```

---

## 📌 Endpoints disponibles

### ➕ Crear usuario
**POST** `/api/usuarios`
```json
{
  "nombre": "Leo",
  "email": "leo@example.com"
}
```

### 📄 Listar usuarios
**GET** `/api/usuarios`

### 🔍 Obtener usuario por ID
**GET** `/api/usuarios/{id}`

### ✏️ Actualizar usuario
**PUT** `/api/usuarios/{id}`
```json
{
  "nombre": "Leo Editado",
  "email": "leo.nuevo@gmail.com"
}
```

### ❌ Eliminar usuario
**DELETE** `/api/usuarios/{id}`

---

## 🧪 Pruebas con Postman

Todos los endpoints fueron probados utilizando Postman. Se recomienda importar las peticiones y validar los distintos métodos HTTP.

### Crear usuario
![Crear Usuario](screenshots/image-1.png)

### Listar usuarios
![Listar Usuarios](screenshots/image-2.png)

### Actualizar usuario
![Actualizar Usuario](screenshots/image-3.png)

### Eliminar usuario
![Actualizar Usuario](screenshots/image-4.png)

### Obtener usuario
![Actualizar Usuario](screenshots/image-5.png)
---

## 📈 Estado del proyecto

- ✔ CRUD funcional
- ✔ Conexión exitosa con MySQL
- ✔ Persistencia con JPA
- ✔ Arquitectura en capas

---

## 👨‍💻 Autor

**Andersson Espinoza M.**

- 💼 GitHub: [@AnderssonEspinoza](https://github.com/AnderssonEspinoza)
- 💼 LinkedIn: [Andersson Espinoza M.](https://www.linkedin.com/in/tu-perfil)
- 📧 Email: anderssonjunior.29@gmail.com

---

## 🧠 Próximas mejoras

- Validaciones (`@NotNull`, `@Email`)
- Manejo de errores (`@ExceptionHandler`)
- Documentación con Swagger / OpenAPI
- Tests unitarios con JUnit

---

## 📝 Licencia

Este proyecto es de código abierto y está disponible bajo la [Licencia MIT](LICENSE).

---

## 📞 Soporte

¿Necesitas ayuda? Contáctame:

- 📧 Email: anderssonjunior.29@gmail.com
- 💬 GitHub Issues: [Crear Issue](https://github.com/tu-usuario/tu-repositorio/issues)
- 💼 LinkedIn: [Mensaje directo](https://www.linkedin.com/in/tu-perfil)

---

<div align="center">

⭐ **Si este proyecto te fue útil, considera darle una estrella** ⭐
</div>

---

<div align="center">

Made with ❤️ by **Andersson Espinoza M.**

</div>
