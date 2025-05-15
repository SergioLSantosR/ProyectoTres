package proyecto_tres;

import java.util.ArrayList;

class MatrizOrtogonal {
    ArrayList<Nodo> nodos = new ArrayList<>();
    final int MAX_FILAS = 10;
    final int MAX_COLUMNAS = 10;

    public boolean estaLlena() {
        return nodos.size() >= (MAX_FILAS * MAX_COLUMNAS);
    }

    public boolean posicionOcupada(int fila, int columna) {
        for (Nodo n : nodos) {
            if (n.fila == fila && n.columna == columna) {
                return true;
            }
        }
        return false;
    }

    public boolean insertar(int fila, int columna, Vehiculo vehiculo) {
        if (estaLlena()) return false;
        if (posicionOcupada(fila, columna)) return false;

        Nodo nuevo = new Nodo(fila, columna, vehiculo);

        for (Nodo n : nodos) {
            if (n.fila == fila) {
                if (n.columna == columna - 1) {
                    n.derecha = nuevo;
                    nuevo.izquierda = n;
                } else if (n.columna == columna + 1) {
                    n.izquierda = nuevo;
                    nuevo.derecha = n;
                }
            }
            if (n.columna == columna) {
                if (n.fila == fila - 1) {
                    n.abajo = nuevo;
                    nuevo.arriba = n;
                } else if (n.fila == fila + 1) {
                    n.arriba = nuevo;
                    nuevo.abajo = n;
                }
            }
        }

        nodos.add(nuevo);
        return true;
    }

    public ArrayList<Nodo> buscar(String criterio, String valor) {
        ArrayList<Nodo> encontrados = new ArrayList<>();
        for (Nodo n : nodos) {
            Vehiculo v = n.vehiculo;
            switch (criterio) {
                case "placa":
                    if (v.placa.equalsIgnoreCase(valor)) encontrados.add(n);
                    break;
                case "color":
                    if (v.color.equalsIgnoreCase(valor)) encontrados.add(n);
                    break;
                case "linea":
                    if (v.linea.equalsIgnoreCase(valor)) encontrados.add(n);
                    break;
                case "modelo":
                    if (String.valueOf(v.modelo).equals(valor)) encontrados.add(n);
                    break;
            }
        }
        return encontrados;
    }

    public boolean eliminar(String criterio, String valor) {
        for (Nodo n : nodos) {
            Vehiculo v = n.vehiculo;
            boolean coincide = switch (criterio) {
                case "placa" -> v.placa.equalsIgnoreCase(valor);
                case "color" -> v.color.equalsIgnoreCase(valor);
                case "linea" -> v.linea.equalsIgnoreCase(valor);
                case "modelo" -> String.valueOf(v.modelo).equals(valor);
                default -> false;
            };
            if (coincide) {
                desconectar(n);
                nodos.remove(n);
                return true;
            }
        }
        return false;
    }

    private void desconectar(Nodo n) {
        if (n.arriba != null) n.arriba.abajo = n.abajo;
        if (n.abajo != null) n.abajo.arriba = n.arriba;
        if (n.izquierda != null) n.izquierda.derecha = n.derecha;
        if (n.derecha != null) n.derecha.izquierda = n.izquierda;
    }

    public String visualizar() {
        if (nodos.isEmpty()) return "Matriz vacía.";
        StringBuilder sb = new StringBuilder();
        for (Nodo n : nodos) {
            sb.append("[").append(n.fila).append(",").append(n.columna).append("] → ")
                    .append(n.vehiculo).append("\n");
        }
        return sb.toString();
    }

    
    public ArrayList<int[]> obtenerPosicionesLibres() {
    ArrayList<int[]> libres = new ArrayList<>();
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            if (!posicionOcupada(i, j)) {
                libres.add(new int[]{i, j});
            }
        }
    }
    return libres;
    }
}
