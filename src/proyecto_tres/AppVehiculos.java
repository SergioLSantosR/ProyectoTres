package proyecto_tres;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AppVehiculos {
    static MatrizOrtogonal matriz = new MatrizOrtogonal();
    
    //Método principal

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppVehiculos::menuPrincipal);
    }

    public static void menuPrincipal() {
        JFrame frame = new JFrame("Matriz Ortogonal de Vehículos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 1));

        JButton btnInsertar = new JButton("Insertar Vehículo");
        JButton btnBuscar = new JButton("Buscar Vehículo");
        JButton btnEliminar = new JButton("Eliminar Vehículo");
        JButton btnVisualizar = new JButton("Visualizar Matriz");
        JButton btnSalir = new JButton("Salir");

        btnInsertar.addActionListener(e -> insertarVehiculo());
        btnBuscar.addActionListener(e -> buscarVehiculo());
        btnEliminar.addActionListener(e -> eliminarVehiculo());
        btnVisualizar.addActionListener(e ->
            JOptionPane.showMessageDialog(null, matriz.visualizar())
        );
        btnSalir.addActionListener(e -> System.exit(0));

        frame.add(btnInsertar);
        frame.add(btnBuscar);
        frame.add(btnEliminar);
        frame.add(btnVisualizar);
        frame.add(btnSalir);

        frame.setVisible(true);
    }


    public static void insertarVehiculo() {
    try {
        String placa = JOptionPane.showInputDialog("Placa:");
        String color = JOptionPane.showInputDialog("Color:");
        String linea = JOptionPane.showInputDialog("Línea:");
        int modelo = Integer.parseInt(JOptionPane.showInputDialog("Modelo:"));
        String propietario = JOptionPane.showInputDialog("Propietario:");

        Vehiculo v = new Vehiculo(placa, color, linea, modelo, propietario);

        // Buscar posiciones libres
        ArrayList<int[]> libres = matriz.obtenerPosicionesLibres();

        if (libres.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La matriz está llena. No se puede insertar el vehículo.");
            return;
        }

        // Escoger una posición libre al azar
        int[] pos = libres.get((int)(Math.random() * libres.size()));
        matriz.insertar(pos[0], pos[1], v);

        JOptionPane.showMessageDialog(null, "Vehículo insertado en [" + pos[0] + "," + pos[1] + "].");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Datos inválidos.");
    }
}

    public static void buscarVehiculo() {
        String[] criterios = {"placa", "color", "linea", "modelo"};
        String criterio = (String) JOptionPane.showInputDialog(null, "Buscar por:", "Buscar",
                JOptionPane.QUESTION_MESSAGE, null, criterios, criterios[0]);
        if (criterio == null) return;

        String valor = JOptionPane.showInputDialog("Valor:");
        if (valor == null) return;

        ArrayList<Nodo> encontrados = matriz.buscar(criterio, valor);
        if (encontrados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No encontrado.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Nodo n : encontrados) {
                sb.append("[").append(n.fila).append(",").append(n.columna).append("] -> ")
                  .append(n.vehiculo).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString());
        }
    }

    public static void eliminarVehiculo() {
        String[] criterios = {"placa", "color", "linea", "modelo"};
        String criterio = (String) JOptionPane.showInputDialog(null, "Eliminar por:", "Eliminar",
                JOptionPane.QUESTION_MESSAGE, null, criterios, criterios[0]);
        if (criterio == null) return;

        String valor = JOptionPane.showInputDialog("Valor:");
        if (valor == null) return;

        boolean eliminado = matriz.eliminar(criterio, valor);
        String mensaje = eliminado ? "Vehículo eliminado." : "Vehículo no encontrado.";
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
        
     
        

    

