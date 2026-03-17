# 📝 SintraBajos

**Resumen corto:** Proyecto desarrollado en Java con Spring Boot, dividido en dos componentes principales (`SintraBajosAdmin` y `SintraBajosUser`). Este sistema está enfocado en la **gestión de citas médicas**.

## 🚀 Tecnologías Utilizadas

Este proyecto fue desarrollado utilizando el siguiente stack:

- **Lenguaje:** Java 11
- **Framework/Librería:** Spring Boot (v2.7.3), Spring Data JPA, Lombok, JCalendar y ITextPDF
- **Gestor de dependencias / Entorno:** Maven
- **Base de Datos:** MySQL y H2 (en memoria/pruebas)

## 🛠️ Instalación y Uso

Instrucciones rápidas para levantar el proyecto localmente. Debido a que el proyecto está dividido en dos aplicaciones (Administrador y Usuario), puedes ejecutar cada una de forma independiente.

```bash
# 1. Clonar el repositorio
git clone https://github.com/axelhuerta/SintraBajos.git

# 2. Entrar al directorio principal
cd SintraBajos

# 3. Entrar a uno de los módulos (ejemplo: Admin)
cd SintraBajosAdmin
# o cd SintraBajosUser

# 4. Ejecutar la aplicación en modo desarrollo utilizando Maven Wrapper
./mvnw spring-boot:run
```

*(Es probable que precises de una base de datos MySQL corriendo localmente o configurar las credenciales en el archivo `application.properties` correspondiente a cada módulo).*

## 👥 Contribuidores

Este proyecto fue realizado por:

| Avatar | Usuario | Rol / Aportación |
|:---:|:---|:---|
| <img src="https://github.com/Victxrgh.png" width="40px;" style="border-radius:50%;"/> | [@Victxrgh](https://github.com/Victxrgh) | Desarrollador del sistema |
| <img src="https://github.com/axelhuerta.png" width="40px;" style="border-radius:50%;"/> | [@axelhuerta](https://github.com/axelhuerta) | Desarrollador del sistema |
| <img src="https://github.com/OctavioSilvaZ.png" width="40px;" style="border-radius:50%;"/> | [@OctavioSilvaZ](https://github.com/OctavioSilvaZ) | Desarrollador del sistema |
| <img src="https://github.com/RASECRE.png" width="40px;" style="border-radius:50%;"/> | [@RASECRE](https://github.com/RASECRE) | Desarrollador del sistema |
| <img src="https://github.com/Ricard0Ponce.png" width="40px;" style="border-radius:50%;"/> | [@Ricard0Ponce](https://github.com/Ricard0Ponce) | Desarrollador del sistema |

## 🏛️ Contexto Académico

- **Institución:** Universidad Autónoma Metropolitana (UAM)
- **Unidad:** Iztapalapa
- **UEA:** Ingeniería de Software
