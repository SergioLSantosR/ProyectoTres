package proyecto_tres;
import javax.swing.JOptionPane;
public class Proyecto_Tres {

    public static void main(String[] args) {
        
        Lista matriz = new Lista();
        String[] opciones = {"Insertar Vehículo", "Buscar Vehículo", "Eliminar Vehículo", "Mostrar Vehículos", "Salir"};
        int opcion;
        do {
            opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Vehículos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
            switch (opcion) {
                case 0:
                    String placa = JOptionPane.showInputDialog("Ingrese la placa:");
                    String color = JOptionPane.showInputDialog("Ingrese el color:");
                    String linea = JOptionPane.showInputDialog("Ingrese la línea:");
                    String modelo = JOptionPane.showInputDialog("Ingrese el modelo:");
                    String propietario = JOptionPane.showInputDialog("Ingrese el propietario:");
                    Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
                    matriz.insertarVehiculo(vehiculo);
                    break;
                case 1:
                    String[] criterios = {"Placa", "Color", "Línea", "Modelo", "Propietario"};
                    String criterio = (String) JOptionPane.showInputDialog(null, "Seleccione el criterio de búsqueda",
                            "Buscar Vehículo", JOptionPane.QUESTION_MESSAGE, null, criterios, criterios[0]);
                    if (criterio != null) {
                        String valor = JOptionPane.showInputDialog("Ingrese el valor a buscar:");
                        Nodo encontrado = matriz.buscarVehiculo(valor);
                        if (encontrado != null) {
                            JOptionPane.showMessageDialog(null, "Vehículo encontrado: " + encontrado.vehiculo);
                        } else {
                            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
                        }
                    }
                    break;
                case 2:
                    String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a eliminar:");
                    matriz.eliminarVehiculo(placaEliminar);
                    break;
                case 3:
                    StringBuilder lista = new StringBuilder();
                    Nodo temp = matriz.inicio;
                    while (temp != null) {
                        lista.append(temp.vehiculo).append("\n");
                        temp = temp.siguiente;
                    }
                    JOptionPane.showMessageDialog(null, lista.toString());
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    break;
            }
        } while (opcion != 4);
    }
        
        
        
        
    
        
}        
//        Lista lista = new Lista(10,10);
//while (true) {
//    String[] opciones = { "Insertar Vehículo", "Buscar Vehículo", "Eliminar Vehículo", "Mostrar Vehículos", "Salir" };
//    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
//            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);
//
//    switch (seleccion) {
//        case 0:
//            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
//            String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
//            String linea = JOptionPane.showInputDialog("Ingrese la línea del vehículo:");
//            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
//            String propietario = JOptionPane.showInputDialog("Ingrese el propietario del vehículo:");
//            Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
//            lista.insertar(vehiculo);
//            break;
//        case 1:
//            String placaBuscar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");
//            Nodo nodo = lista.buscarPorPlaca(placaBuscar);
//            if (nodo != null) {
//                JOptionPane.showMessageDialog(null, nodo.vehiculo.toString());
//            } else {
//                JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
//            }
//            break;
//        case 2:
//            String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a eliminar:");
//            lista.eliminarPorModelo(placaEliminar);
//            break;
//        case 3:
//            lista.mostrar(); // Asegúrate de que este método muestre con JOptionPane o System.out
//            break;
//        case 4:
//            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
//            System.exit(0);
//            break;
//        default:
//            JOptionPane.showMessageDialog(null, "Opción no válida.");
//            break;
//    }
//}
//
//    }
    

