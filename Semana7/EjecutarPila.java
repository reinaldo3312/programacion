package Semana7;

import java.util.Stack;

public class EjecutarPila {
    public static void main(String[] args) {
        
        Stack<String> pila = new Stack <>();

        System.out.println(pila.empty());// true

        //Insertar elementos a la pila
        pila.push("Maria jose");
        pila.push("Dalmar");
        pila.push("Samuel");
        pila.push("Yolian");

        //Mostrar la pila
        System.out.println(pila);//[Maria jose, Dalmar, Samuel, Yolian]

        //Mostar el tope de la pila sin eliminar el elemento
        System.out.println(pila.peek());//Yolian

        //Eliminar el tope de la pila
        System.out.println("elemento eliminadi"+ pila.pop());

         //Mostrar la pila
        System.out.println(pila);

        System.out.println("Buscar:" + pila.search("Samuel"));//1
       System.out.println("Buscar:" + pila.search("Dalmar"));//2
       System.out.println("Buscar:" + pila.search("Maria jose"));//3




    }
}
