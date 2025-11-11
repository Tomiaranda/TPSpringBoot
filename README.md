# 🧾 TP Spring Boot – Sistema de Gestión de Tareas (UTN)

## 📌 Descripción General

Este proyecto implementa un **sistema de gestión de tareas** desarrollado con **Spring Boot**, correspondiente al **Trabajo Práctico de Fundamentos de Spring Boot** de la materia **Desarrollo de Software – UTN Facultad Regional Mendoza**.

El sistema permite administrar tareas con diferentes prioridades, mostrando un flujo completo desde la capa de datos hasta la lógica de negocio.  
Incluye **inyección de dependencias**, **configuración externa**, **profiles de entorno** y **ejecución automática** con `CommandLineRunner`.

## ⚙️ Tecnologías Utilizadas

| Tecnología | Uso principal |
|-------------|----------------|
| **Java 21** | Lenguaje de programación |
| **Spring Boot 3.5.7** | Framework principal |
| **Gradle** | Herramienta de build |
| **Spring Context / Beans** | Inyección de dependencias |
| **CommandLineRunner** | Ejecución automática al iniciar la app |

## 🚀 Ejecución del Proyecto

### ✅ Requisitos Previos
- Tener instalado **JDK 21**
- Tener configurado **Gradle**
- IDE recomendado: **IntelliJ IDEA**

---

### ▶️ Ejecución desde IntelliJ

1. Abrí el proyecto.
2. Verificá el perfil activo en  
   `src/main/resources/application.properties`:
   spring.profiles.active=dev
     o cambiá a:
   spring.profiles.active=prod
 
   Ejecutá la aplicación con Run ▶ TareasApplication.
   
   CAPTURA DE LA CONSOLA EN LOS DOS PROFILES
   
   Profile=PROD
<img width="711" height="543" alt="image" src="https://github.com/user-attachments/assets/fe7831fc-f4f8-42ed-88f8-7d868dfd5344" />

 Profile=DEV
 
<img width="714" height="537" alt="image" src="https://github.com/user-attachments/assets/f95a7c54-dd2d-4d3f-b409-205a2041df8f" />
<img width="554" height="96" alt="image" src="https://github.com/user-attachments/assets/98a8fdc0-a517-4f73-881f-cf93addc1c5f" />

Conclusiones
Se aplicaron correctamente los principios de Spring Boot y la inyección de dependencias.
Se configuraron dos perfiles de entorno (dev y prod) usando @Profile.
La aplicación demuestra un flujo completo de negocio, con tareas agregadas, listadas y completadas.
El sistema es completamente configurable y extensible gracias al uso de propiedades externas.

 Autor
Tomás Aranda
Estudiante de Ingeniería en Sistemas – UTN FRM
📍 Mendoza, Argentina



   
