package proyecto_tres;
import javax.swing.JOptionPane;

//esta clase contiene a la lista ortogonal
public class MatrizOrtogonal {
    
    
    Nodo inicio;

    public MatrizOrtogonal() {
        inicio = null;
    }

    public void insertarVehiculo(Vehiculo vehiculo) {
        Nodo nuevo = new Nodo(vehiculo);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
            nuevo.anterior = temp;
        }
    }

    public Nodo buscarVehiculo(String criterio) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.vehiculo.placa.equals(criterio) ||
                temp.vehiculo.color.equals(criterio) ||
                temp.vehiculo.linea.equals(criterio) ||
                temp.vehiculo.modelo.equals(criterio) ||
                temp.vehiculo.propietario.equals(criterio)) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

    public void eliminarVehiculo(String placa) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.vehiculo.placa.equals(placa)) {
                if (temp.anterior != null) {
                    temp.anterior.siguiente = temp.siguiente;
                } else {
                    inicio = temp.siguiente;
                }
                if (temp.siguiente != null) {
                    temp.siguiente.anterior = temp.anterior;
                }
                return;
            }
            temp = temp.siguiente;
        }
    }

    public void mostrarVehiculos() {
        Nodo temp = inicio;
        while (temp != null) {
            System.out.println(temp.vehiculo);
            temp = temp.siguiente;
        }
    }  
    
}
