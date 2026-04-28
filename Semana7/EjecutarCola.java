package Semana7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class EjecutarCola {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        Queue<Integer> cola = new ArrayDeque<>();
        List<Integer> contenedor = new ArrayList<>();

        //Insertar elementos a la cola
        cola.add(10);
        cola.add(15);
        cola.add(8);
        cola.add(20);
        cola.add(35);
        cola.add(12);

        //Mostrar los elementos de la cola
        System.out.println(cola);//[10,15,8,20,35,12]

        //verificar que elemento esta en la cabeza de la cola 
        System.out.println(cola.element());

      //Eliminar el primer elemento de la cola (cabeza) con método poll
        System.out.println("Elemento eliminado: " + cola.poll()); //10
 
        //Eliminar el primer elemento de la cola (cabeza) con método remove
        System.out.println("Elemento eliminado: " + cola.remove()); //15
 
        //Mostrar los elementos de la cola
        System.out.println(cola); //[8, 20, 35, 12, 55]

        //obtener el  tamaño de la cola
        System.out.println("tamaño de la cola:" + cola.size());

        //recorrer la lista forEach
        lista.forEach(elemento -> System.out.println(elemento));
        //obtener elemento por indice
        System.out.println(lista.get(1));

        //mostrar contenido del contenedo
        System.out.println(contenedor);

        //tamaño del contenedor 
        System.out.println("tamaño: "+ contenedor.size());

       //
        
}
  
}