# Manual Técnico - Sistema de Gestión de Vehículos en Matriz Ortogonal

Este documento describe la arquitectura, clases, y funcionamiento técnico del sistema desarrollado en Java para la gestión de vehículos mediante una estructura de matriz ortogonal.

## Estructura del Proyecto

- AppVehiculos.java: Clase principal con la interfaz gráfica e interacción con el usuario.
- MatrizOrtogonal.java: Manejo interno de la estructura ortogonal (almacenamiento y operaciones).
- Nodo.java: Representa un nodo de la matriz.
- Vehiculo.java: Modelo de datos del vehículo.

## Descripción de Clases

### AppVehiculos

- Clase principal con main().
- Crea una interfaz con botones:
  - Insertar
  - Buscar
  - Eliminar
  - Visualizar
  - Salir
- Cada acción ejecuta métodos que interactúan con la clase MatrizOrtogonal.

### MatrizOrtogonal

- Estructura de matriz ortogonal simulada con una lista de nodos enlazados.
- Principales métodos:
  - insertar(fila, columna, vehiculo)
  - buscar(criterio, valor)
  - eliminar(criterio, valor)
  - visualizar()
  - obtenerPosicionesLibres()
- Gestiona conexiones arriba, abajo, izquierda y derecha entre nodos contiguos.

### Nodo

- Atributos:
  - fila, columna: posición en la matriz.
  - vehiculo: objeto de tipo Vehiculo`.
  - Enlaces: arriba, abajo, izquierda, derecha`

### Vehiculo

- Atributos:
  - placa, color, linea, modelo, propietario.
- Método toString ( ) personalizado para mostrar la información del vehículo.

## Flujo General del Programa

1. El usuario inicia la aplicación.
2. Mediante la GUI, elige una acción (insertar, buscar, etc.).
3. Se llama a los métodos correspondientes de la matriz.
4. Los resultados se muestran mediante cuadros de diálogo (JOptionPane).

## Consideraciones Técnicas

- Se utiliza ArrayList<Nodo> como base de datos interna.
- La inserción se realiza automáticamente en una posición aleatoria disponible.
- La búsqueda y eliminación se basan en coincidencias de atributos.

## Mejores prácticas sugeridas

- Validar los datos ingresados antes de crear el objeto Vehiculo.
- Se puede extender el sistema para guardar o cargar información desde un archivo o base de datos.
- Se recomienda manejar excepciones específicas para una mejor experiencia de usuario.
