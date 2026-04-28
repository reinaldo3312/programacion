package Producto;

public class Inventario {
    private Producto[] productos;
    private int contador;

    //constructor
    public  Inventario(int  tamaño){
        productos = new Producto[tamaño];
        contador=0;
    }

    //agregar producto
    public void agregarProducto(Producto P) {
        if (contador < productos.length) {
            productos[contador] = P;
            contador++;
            
        }else {
            System.out.println("inventario lleno, no se puede agregar el producto");
        }
        
    }
//buscar por ID
public Producto buscarPorId( int id){
    for (int i =0; i < contador; i++) {
        if (productos[i] != null && productos[i].getId() == id) {
            return productos[i];
        }
        
    }
    return null;
        
}

//Actualizar Stock
public void actualizarStock(int id, int nuevaCantidad){
    Producto p = buscarPorId(id);
        if (p != null) {
            p.setCantidadStock(nuevaCantidad);
            }else {
            System.out.println("Producto no encontrado con. " );
        }
    }
    //generar informe valor total
    public double generarInformeValorTotal(){
        double total = 0;
        for (int i=0; i < contador; i++) {
            if (productos[i] != null) {
                total += productos[i].getPrecio() * productos[i].getCantidadStock();
            }
        }
        return total;
    }
    //obtener productos agotados <5
    public Producto[] obtenerProductosAgotados(){
        int cantidad = 0;
        
        for(int  i = 0; i < contador; i++) {
            if (productos[i] != null && productos[i].getCantidadStock() <5) {
                cantidad++;
            }
        }
        Producto[] agotados = new Producto[cantidad];
        int j = 0;
        for (int i = 0; i < contador; i++) {
            if (productos[i] != null && productos[i].getCantidadStock() < 5) {
                agotados[j] = productos[i];
                j++;
                
       }
    }
    return agotados;
}
//ordenar por precio decendente (burbuja)
public void ordenarPorPrecioDescendente() {
    
    for (int i = 0; i < contador - 1; i++) {
        for(int j= 0; j < contador - 1 - i; j++){
            if (productos[j].getPrecio() < productos[j + 1].getPrecio()){
                Producto temp = productos[j];
                productos[j] = productos[j + 1];
                productos[j + 1] = temp;
            }

        }
        
    }
    
}

//metodo para mostrar productoa
public void mostrarProductos() {
    for (int i = 0; i < contador; i++) {
        if (productos[i] != null) {
            System.out.println(productos[i]);
        }
    }
}
}