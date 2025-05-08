package proyecto_tres;

public class Nodo {
    Vehiculo vehiculo;
    Nodo siguiente;
    Nodo anterior;
    Nodo arriba;
    Nodo abajo;
    
    public Nodo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        this.siguiente = null;
        this.anterior = null;
        this.arriba = null;
        this.abajo = null;
        
    }
    
}
