# GestorMagia
 
**Link al repositorio:** https://github.com/mbp4/GestorMagia.git 

**Participantes:** Miriam Blanco Ponce, Sira González-Madroño, Sonia Tejero Recio, Adrián Thierry Puyo Olías y Daniel Sousa

## Funcionamiento de la aplicación
- Para poder acceder hay que usar un usuario de los ya creados anteriormente. Estos son:
  - Miri con contraseña 1234 (Admin)
  - Antonio con contraseña 1234 (Admin)
  - Pepe con contraseña 1111 (User)
- En la primera pantalla se podrá ver una lista de hechizos creados y botones para crear más hechizos o ver una auditoría de los eventos mágicos (hechizos creados correctamente o no creados) y para cerrar sesión.
- Para acceder a las pantallas de Nuevo Hechizo y Auditoría hará falta permisos Admin. Si no, saldrá un mensaje de error 403.
- En la creación de hechizos se podrá crear cualquier hechizo cuyo mago no sea "Voldemort" o cuyo tipo de hechizo no sea "Pocima".
- En la auditoría, advertirá de los eventos que hayan sucedido (si se han creado correctamente o si se ha introducido un valor prohibido en algún campo).


## Resumen

- **`GestorMagiaApplication.java`**: Clase principal que inicializa el servidor de Spring Boot y configura la apertura automática del navegador web al puerto 8080.
- **`MainController.java`**: Controlador que redirige a la página de listado de eventos mágicos en la raíz del proyecto.
- **`EventoMagicoController.java`**: Controlador encargado de gestionar la creación de los eventos mágicos.
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

### `listaHechizos.html`

- **Descripción**: Página principal que muestra la lista de eventos mágicos registrados.
- **Funcionalidades**:
  - Listado de eventos con detalles.
  - Navegación entre la lista de eventos y acceso a la creacion y auditoría de los mismos.
    
### `listaAuditoría.html´
- **Descripción**: Muestra la lista de eventos mágicos.
- **Funcionalidades**:
  - Visualizar con detalles la lista de eventos.

### `formularioHechizo.html´
- **Descripción**: Permite la creación de hechizos.
- **Funcionalidades**:
 - Formulario de creación de hechizos.
 - Gestión de eventos en la creación de hechizos.
   
### `prohibido.html´
- **Descripción**: Muestra un mensaje de acceso restringido a aquellos perfiles no autorizados
- **Funcionalidades**:
 - Aviso de sección restingida a usuarios con permisos de administrador.   

  
