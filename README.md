# Proyecto_PMDM

## Descripción
Proyecto de aprendizaje en **Kotlin/Android**, cuyo objetivo es construir una aplicación modular y escalable, utilizando buenas prácticas de programación y organización de componentes en un proyecto Android.  
Este repositorio sirve como base para futuras mejoras y como referencia de lo realizado durante el desarrollo.

---

## Tecnologías y herramientas
- **Lenguaje:** Kotlin
- **IDE:** Android Studio
- **Sistema de construcción:** Gradle / Kotlin DSL
- **Arquitectura:** Modular, orientada a componentes
- **Dependencias principales:** AndroidX, Material3, Compose UI

---

## Estructura del proyecto

```plaintext
Proyecto_PMDM/
│
├─ app/ # Módulo principal de la aplicación
│ ├─ src/main/
│ │ ├─ java/com/example/pmddm/
│ │ │ └─ ... # Código fuente Kotlin
│ │ └─ res/ # Recursos (drawable, layout, etc.)
│ └─ build.gradle.kts # Configuración de módulo
│
├─ build.gradle.kts # Configuración del proyecto
├─ settings.gradle.kts # Configuración de módulos
├─ gradle/ # Wrapper de Gradle
├─ gradlew # Script de ejecución Gradle
└─ README.md # Este archivo
```


---

## Funcionalidades principales
- Implementación de componentes **UI con Compose**
- Organización modular para facilitar escalabilidad
- Uso de **recursos locales** (imágenes, iconos, layouts)
- Puntos de partida para agregar nuevas funcionalidades futuras

---

## Instalación y ejecución
1. Clonar el repositorio:
   
   ```bash
   git clone https://github.com/RBD-20002/Proyecto_PMDM.git
   ```

2. Abrir el proyecto en Android Studio

3. Sincronizar Gradle

4. Ejecutar la app en un emulador o dispositivo físico

---

## Como Contribuir 

- Este proyecto es personal. Si te sirve como base para expandir lo que puede llegar a hacer, siéntete libre de hacer un **fork** y experimentar.  
- Si tienes alguna observación, sugerencia o consejo, me encantaría que me lo comentaras; tu punto de vista diferente me ayudaría a mejorar y reflexionar sobre el proyecto.

---

## Futuras Mejoras

- Documentación interna de las clases y componentes

- Implementación de pruebas unitarias e integración

- Manejo avanzado de estados y navegación Compose

- Optimización de recursos y modularización más granular

---

## Licencia

- Este proyecto es para fines educativos y personales. Puedes usarlo como referencia, pero no está bajo licencia de distribución pública específica.
