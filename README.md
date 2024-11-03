# GestorMagia
 
**Link al repositorio:** https://github.com/mbp4/GestorMagia.git 

**Participantes:** Miriam Blanco Ponce, Sira González-Madroño, Sonia Tejero Recio, Adrián Thierry Puyo Olías y Daniel Sousa


## Resumen

- **`GestorMagiaApplication.java`**: Clase principal que inicializa el servidor de Spring Boot y configura la apertura automática del navegador web al puerto 8000.
- **`MainController.java`**: Controlador que redirige a la página de listado de eventos mágicos en la raíz del proyecto.
- **`EventoMagicoController.java`**: Controlador encargado de gestionar las operaciones CRUD de los eventos mágicos y la navegación en la aplicación.
- **`AuditoriaController.java`**: Proporciona un endpoint para listar los registros de auditoría de eventos mágicos.

## Módulos Principales

### Controladores

- **`MainController.java`**: Redirige al usuario a la lista de eventos mágicos desde la página principal.
- **`EventoMagicoController.java`**:
  - Listado de eventos mágicos.
  - Formulario para añadir nuevos eventos.
  - Guardado de eventos mágicos y validación de restricciones.
  - Manejo de la sesión de usuario y opciones de logout.
- **`AuditoriaController.java`**:
  - Muestra el registro de auditorías realizadas en el sistema.
  - Presenta los eventos auditados en una vista de lista.

### Seguridad

- **`SecurityConfig.java`**:
  - Configura la seguridad de acceso mediante `SecurityFilterChain`.
  - Define roles de usuarios y establece el método de autenticación.
- **`SeguridadServicio.java`**:
  - Proporciona métodos para obtener el rol y el nombre del usuario autenticado.

### Modelos y DAOs

- **`EventoMagico.java`**:
  - Representa la entidad de un evento mágico, con detalles como lugar, hechizo, mago, tipo y gravedad.
- **`Auditoria.java`**:
  - Representa un registro de auditoría con campos de usuario, fecha y acción realizada.
- **`EventoMagicoDao.java`** y **`AuditoriaDao.java`**:
  - Interfaz de acceso a datos para las entidades de eventos mágicos y auditoría.

### Servicios

- **`EventoMagicoServicio.java`**:
  - Gestiona la lógica de negocio de los eventos mágicos, incluyendo validaciones específicas y el guardado de eventos.
  - Rechaza eventos que incumplen ciertas restricciones (e.g., eventos con el mago Voldemort).
- **`ConfigAspect.java`**:
  - Implementa aspectos transversales para manejar la auditoría y otras operaciones relacionadas con los eventos mágicos.

## Pantallas

### `index.html`

- **Descripción**: Página principal que muestra la lista de eventos mágicos registrados.
- **Funcionalidades**:
  - Listado de eventos con detalles.
  - Formularios para añadir y gestionar eventos.
  - Navegación entre la lista de eventos y la vista de auditoría.

### Endpoints Principales

- **`/evento/list`**: Muestra la lista de eventos mágicos.
- **`/evento/formulario`**: Carga el formulario para registrar un nuevo evento mágico.
- **`/evento/guardar`**: Guarda un evento mágico tras validación.
- **`/auditoria/listar`**: Muestra el listado de registros de auditoría.
- **`/evento/salir`**: Permite a los usuarios cerrar sesión.

