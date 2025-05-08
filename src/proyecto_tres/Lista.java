
package proyecto_tres;
import javax.swing.JOptionPane;

//esta clase contiene a la lista ortogonal
public class Lista {

    
    private Nodo inicio;

    public Lista() {
        inicio = null;
    }

    public void insertar(Vehiculo vehiculo) {
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

    public Nodo buscarPlaca(String placa) {
        Nodo temp = inicio;
        while (temp != null) {
            if (temp.vehiculo.getPlaca().equals(placa)) {
                return temp;
            }
            temp = temp.siguiente;
        }
        return null;
    }

     
    public void eliminar(String placa) {
        Nodo nodo = buscarPlaca(placa);
        if (nodo != null) {
            if (nodo.anterior != null) {
                nodo.anterior.siguiente = nodo.siguiente;
            }
            if (nodo.siguiente != null) {
                nodo.siguiente.anterior = nodo.anterior;
            }
            if (nodo == inicio) {
                inicio = nodo.siguiente;
            }
            nodo = null;
            JOptionPane.showMessageDialog(null, "Vehículo eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Vehículo no encontrado.");
        }
    }

    public void mostrar() {
        Nodo temp = inicio;
        StringBuilder sb = new StringBuilder();
        while (temp != null) {
            sb.append(temp.vehiculo.toString()).append("\n");
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    
}
