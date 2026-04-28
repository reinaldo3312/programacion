package TrabajoFinal;

public class Buque {

    private int id;
    private String nombre;

    public Buque(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String toString() {
        return "Buque ID: " + id + ", Nombre: " + nombre;
    }
    
}
