package Semana7;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Stack;

public class  ej{
    public static void main(String[] args) {

        Stack<String> pila = new Stack<>();

        // Verificar si la pila está vacía
        System.out.println("¿Pila vacía? " + pila.empty()); // true

        //================= PUSH =================
        pila.push("Maria Jose");
        pila.push("Dalmar");
        pila.push("Samuel");
        pila.push("Yolian");

        //Mostrar la pila
        System.out.println("Pila: " + pila); //[Maria Jose, Dalmar, Samuel, Yolian]

        // PEEK 
        System.out.println("Elemento en el tope (peek): " + pila.peek()); //Yolian

        // POP 
        System.out.println("Elemento eliminado (pop): " + pila.pop()); //Yolian

        //Mostrar la pila
        System.out.println("Pila después de pop: " + pila);

        // SIZE 
        System.out.println("Tamaño de la pila: " + pila.size());

        //ITERATOR 
        Iterator<String> it = pila.iterator();
        System.out.println("Recorrido con Iterator:");
        while(it.hasNext()) {
            String elem = it.next();
            System.out.println(elem);
            //Eliminar "Dalmar" mientras se recorre
            if(elem.equals("Dalmar")) {
                it.remove();
            }
        }
        System.out.println("Pila después de Iterator: " + pila);

        // STREAM 
        System.out.println("Elementos que contienen 'a' (stream):");
        pila.stream()
            .filter(e -> e.toLowerCase().contains("a"))
            .forEach(System.out::println);

        // SPLITERATOR 
        Spliterator<String> sp = pila.spliterator();
        System.out.println("Recorrido con Spliterator:");
        sp.tryAdvance(System.out::println); //primer elemento
        sp.forEachRemaining(System.out::println); //resto de elementos

        // SEARCH
        System.out.println("Buscar Samuel: " + pila.search("Samuel")); //1
        System.out.println("Buscar Maria Jose: " + pila.search("Maria Jose")); //2

        // CLEAR 
        pila.clear();
        System.out.println("Pila después de clear: " + pila); //[]
        System.out.println("Tamaño de la pila después de clear: " + pila.size()); //0
    }
}