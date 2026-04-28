package TrabajoFinal;

public class Contenedor {
    private int id;
    private double peso;
    private String origen;

    public Contenedor(int id, double peso, String origen) {
        this.id = id;
        this.peso = peso;
        this.origen = origen;
    }
    public int getId() {
        return id;
    }
    public double getPeso() {
        return peso;
    }
    public String getOrigen() {
        return origen;
    }
    public String toString() {
        return "Contenedor ID: " + id + ", Peso: " + peso + ", Origen: " + origen;
    }

}
