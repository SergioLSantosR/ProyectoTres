package proyecto_tres;
import javax.swing.JOptionPane;
public class Proyecto_Tres {

    public static void main(String[] args) {
        
        
        Lista lista = new Lista(10,10);
while (true) {
    String[] opciones = { "Insertar Vehículo", "Buscar Vehículo", "Eliminar Vehículo", "Mostrar Vehículos", "Salir" };
    int seleccion = JOptionPane.showOptionDialog(null, "Seleccione una opción", "Menú Principal",
            JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

    switch (seleccion) {
        case 0:
            String placa = JOptionPane.showInputDialog("Ingrese la placa del vehículo:");
            String color = JOptionPane.showInputDialog("Ingrese el color del vehículo:");
            String linea = JOptionPane.showInputDialog("Ingrese la línea del vehículo:");
            String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehículo:");
            String propietario = JOptionPane.showInputDialog("Ingrese el propietario del vehículo:");
            Vehiculo vehiculo = new Vehiculo(placa, color, linea, modelo, propietario);
            lista.insertar(0, 0, vehiculo);
            break;
        case 1:
            String placaBuscar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a buscar:");
            Nodo nodo = lista.buscarPorPlaca(placaBuscar);
            if (nodo != null) {
                JOptionPane.showMessageDialog(null, nodo.vehiculo.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
            }
            break;
        case 2:
            String placaEliminar = JOptionPane.showInputDialog("Ingrese la placa del vehículo a eliminar:");
            lista.eliminarPorModelo(placaEliminar);
            break;
        case 3:
            lista.mostrar(); // Asegúrate de que este método muestre con JOptionPane o System.out
            break;
        case 4:
            JOptionPane.showMessageDialog(null, "¡Hasta luego!");
            System.exit(0);
            break;
        default:
            JOptionPane.showMessageDialog(null, "Opción no válida.");
            break;
    }
}

    }
    
}
