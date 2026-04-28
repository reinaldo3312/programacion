package Producto;

public class Main {
    public static void main(String[] args){
        Inventario inventario = new Inventario(5);
        Producto p1 = new Producto(1, "Laptop", 1500.0, 10);
        Producto p2 = new Producto(2, "Smartphone", 800.0, 3);
        Producto p3 = new Producto(3, "Tablet", 500.0, 8);
        Producto p4 = new Producto(4, "Monitor", 300.0, 2);

        inventario.agregarProducto(p1);
        inventario.agregarProducto(p2);
        inventario.agregarProducto(p3);
        inventario.agregarProducto(p4);

        System.out.println("===  Productos ===");
        inventario.mostrarProductos();

        System.out.println("valor total inventario:" + inventario.generarInformeValorTotal());
        
        System.out.println("=== Productos Agotados (<5 unidades) ===");
        Producto[] agotados = inventario.obtenerProductosAgotados();
        for (int i = 0; i < agotados.length; i++) {
            System.out.println(agotados[i]);
        }

        System.out.println("=== ordenadas por precio descendente ===");
        inventario.ordenarPorPrecioDescendente();
        inventario.mostrarProductos();
    }
    
}
