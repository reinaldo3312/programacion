package Producto;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int CantidadStock;

    //contructor
    public Producto(int id, String nombre, double precio, int cantidadStock){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.CantidadStock=cantidadStock;

    }
    //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadStock() {
        return CantidadStock;
    }

    public void setCantidadStock(int cantidadStock) {
        CantidadStock = cantidadStock;
    }
//metodo toString

    @Override
    public String toString() {
        return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", CantidadStock=" + CantidadStock
                + "]";
    }

   
    

}

    

    
    

