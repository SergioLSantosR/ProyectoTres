package proyecto_tres;

public class Nodo {
    Nodo siguiente;
    Nodo anterior;
    String dato;
    
    public Nodo(String dato){
        this.dato = dato;
        siguiente = null;
        anterior = null;
        
    }
    
}
