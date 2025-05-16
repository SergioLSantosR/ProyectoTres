# Manual de Usuario - Sistema de Gestión de Vehículos en Matriz Ortogonal

Este sistema permite registrar, buscar, eliminar y visualizar vehículos en una matriz bidimensional mediante una interfaz gráfica intuitiva. A continuación se le explica cómo utilizar cada funcionalidad paso a paso.

## Requisitos del sistema

- Java 8 o superior
- Entorno gráfico compatible con Swing
- IDE como NetBeans, IntelliJ IDEA o Eclipse (opcional)

## Iniciar el sistema

1. Compile el proyecto en su IDE o ejecute el archivo principal AppVehiculos.java.
2. Aparecerá una ventana titulada **"Matriz Ortogonal de Vehículos"** con cinco botones principales.

## Funcionalidades del sistema

### 1. Insertar Vehículo

- Presione el botón **"Insertar Vehículo"**.
- Ingrese los siguientes datos cuando se le solicite:
  - **Placa** del vehículo (texto)
  - **Color** del vehículo (texto)
  - **Línea** del vehículo (texto)
  - **Modelo** del vehículo (número entero)
  - **Propietario** (nombre del propietario)
- El sistema seleccionará automáticamente una posición disponible en la matriz y le mostrará la ubicación donde se insertó.

### 2. Buscar Vehículo

- Presione **"Buscar Vehículo"**.
- Seleccione el criterio de búsqueda: placa, color, linea o modelo.
- Ingrese el valor a buscar.
- Si se encuentra uno o más vehículos con dicho valor, se mostrará su información y posición en la matriz.
- En caso contrario, se notificará que no fue encontrado.

### 3. Eliminar Vehículo

- Presione **"Eliminar Vehículo"**.
- Elija el criterio de eliminación: placa, color, linea o modelo.
- Ingrese el valor asociado al vehículo que desea eliminar.
- Si se encuentra un vehículo con dicho valor, se eliminará y se le mostrará un mensaje de confirmación.
- Si no se encuentra, se le indicará que no existe coincidencia.

### 4. Visualizar Matriz

- Al presionar **"Visualizar Matriz"**, se mostrará una lista de todos los vehículos actualmente almacenados, junto con su posición en la matriz.

### 5. Salir

- Presione **"Salir"** para cerrar la aplicación de manera segura.

## Recomendaciones de uso

- Evite dejar campos vacíos al insertar un vehículo.
- Ingrese correctamente los datos (modelo debe ser un número).
- Para un uso óptimo, evite insertar múltiples vehículos con la misma placa.
