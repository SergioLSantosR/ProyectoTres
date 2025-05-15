package proyecto_tres;

class Vehiculo {
    String placa, color, linea, propietario;
    int modelo;

    public Vehiculo(String placa, String color, String linea, int modelo, String propietario) {
        this.placa = placa;
        this.color = color;
        this.linea = linea;
        this.modelo = modelo;
        this.propietario = propietario;
    }

    public String toString() {
        return "Placa: " + placa + ", Color: " + color + ", Línea: " + linea +
                ", Modelo: " + modelo + ", Propietario: " + propietario;
    }
}