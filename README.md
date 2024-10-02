# Sistema de Gestión de Cuentas Bancarias

Este proyecto es un sistema de gestión de cuentas bancarias desarrollado en Java utilizando Spring y PrimeFaces. Permite almacenar cuentas bancarias en una base de datos MySQL y realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre los registros de cuentas. La interfaz de usuario, desarrollada con PrimeFaces, muestra una tabla con los datos de las cuentas bancarias y proporciona botones para agregar, actualizar y eliminar cuentas.

## Características

- **Listado de Cuentas:** Visualiza una lista de todas las cuentas bancarias registradas.
- **Agregar Cuenta:** Permite agregar nuevas cuentas al sistema.
- **Editar Cuenta:** Permite editar la información de las cuentas existentes.
- **Eliminar Cuenta:** Permite eliminar cuentas del sistema.

## Tecnologías Utilizadas

- **Java:** Lenguaje de programación.
- **Spring Framework:** Framework para el desarrollo de aplicaciones Java.
- **PrimeFaces:** Biblioteca de componentes de interfaz de usuario para JSF.
- **MySQL:** Sistema de gestión de bases de datos.

## Estructura del Proyecto

- **src/main/java/gian/cuentas/controller:** Contiene los controladores de Spring.
- **src/main/java/gian/cuentas/model:** Contiene las clases de modelo.
- **src/main/java/gian/cuentas/service:** Contiene los servicios de Spring.
- **src/main/java/gian/cuentas/repository:** Contiene los repositorios de Spring.
- **src/main/resources/templates:** Contiene las plantillas de PrimeFaces.

## Instrucciones de Uso

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/gianpoker1/SistemaCuentas
   ```
2. **Configurar el Entorno:**
  Asegúrate de tener instalado Java y Maven.
  Configura tu base de datos MySQL y actualiza las configuraciones en el archivo
  `application.properties`
  
3. **Compilar y Ejecutar:**

   ```
   mvn clean install
   mvn spring-boot:run ```

4. **Acceder a la Aplicación:**

   Abre tu navegador y visita `http://localhost:8080/index.xhtml`
