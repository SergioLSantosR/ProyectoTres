package proyecto_tres;
import javax.swing.JOptionPane;

//esta clase contiene a la lista ortogonal
public class Lista {

    
    private Nodo[][] matriz;
    private int filas;
    private int columnas;

    public Lista(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new Nodo[filas][columnas];
    }

    public void insertar(int fila, int columna, Vehiculo vehiculo) {
        if (fila < filas && columna < columnas) {
            Nodo nuevo = new Nodo(vehiculo);
            matriz[fila][columna] = nuevo;
            if (fila > 0) {
                matriz[fila][columna].arriba = matriz[fila - 1][columna];
                matriz[fila - 1][columna].abajo = matriz[fila][columna];
            }
            if (columna > 0) {
                matriz[fila][columna].anterior = matriz[fila][columna - 1];
                matriz[fila][columna - 1].siguiente = matriz[fila][columna];
            }
        } else {
            JOptionPane.showMessageDialog(null, "Índices fuera de rango.");
        }
    }

    
    public Nodo buscarPorPlaca(String placa) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null && matriz[i][j].vehiculo.getPlaca().equals(placa)) {
                    return matriz[i][j];
                }
            }
        }
        return null;
    }
    
    public Nodo buscarPorModelo(String modelo) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null && matriz[i][j].vehiculo.getModelo().equals(modelo)) {
                    return matriz[i][j];
                }
            }
        }
        return null;
    }

    public Nodo buscarPorPropietario(String propietario) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null && matriz[i][j].vehiculo.getPropietario().equals(propietario)) {
                    return matriz[i][j];
                }
            }
        }
        return null;
    }

    public Nodo buscarPorLinea(String linea) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != null && matriz[i][j].vehiculo.getLinea().equals(linea)) {
                    return matriz[i][j];
                }
            }
        }
        return null;
    }

    public void eliminarPorModelo(String modelo) {
        Nodo nodo = buscarPorModelo(modelo);
        if (nodo != null) {
            if (nodo.arriba != null) {
                nodo.arriba.abajo = nodo.abajo;
            }
            if (nodo.abajo != null) {
                nodo.abajo.arriba = nodo.arriba;
            }
            if (nodo.anterior != null) {
                nodo.anterior.siguiente = nodo.siguiente;
            }
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nodo.anterior;
            }
            nodo = null;
            JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    public void eliminarPorPropietario(String propietario) {
        Nodo nodo = buscarPorPropietario(propietario);
        if (nodo != null) {
            if (nodo.arriba != null) {
                nodo.arriba.abajo = nodo.abajo;
            }
            if (nodo.abajo != null) {
                nodo.abajo.arriba = nodo.arriba;
            }
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nodo.anterior;
            }
            if (nodo.anterior != null) {
                nodo.anterior.siguiente = nodo.siguiente;
            }
            nodo = null;
            JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    public void eliminarPorLinea(String linea) {
        Nodo nodo = buscarPorLinea(linea);
        if (nodo != null) {
            if (nodo.arriba != null) {
                nodo.arriba.abajo = nodo.abajo;
            }
            if (nodo.abajo != null) {
                nodo.abajo.arriba = nodo.arriba;
            }
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nodo.anterior;
            }
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nodo.anterior;
            }
            nodo = null;
            JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }
    
    public void mostrar() { 
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < columnas; j++) {
            if (matriz[i][j] != null) {
                sb.append(matriz[i][j].toString());
            } else {
                sb.append("null");
            }
            sb.append("\t"); // tabulador para separación
        }
        sb.append("\n"); // salto de línea por fila
    }
    System.out.println(sb.toString());
}
    
}
