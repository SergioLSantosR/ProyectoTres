package proyecto_tres;

class Nodo {
    int fila, columna;
    Vehiculo vehiculo;
    Nodo arriba, abajo, izquierda, derecha;

    public Nodo(int fila, int columna, Vehiculo vehiculo) {
        this.fila = fila;
        this.columna = columna;
        this.vehiculo = vehiculo;
    }
}

