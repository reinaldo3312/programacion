import java.util.Scanner;
import java.util.Stack;

public class Pilas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<String> pila = new Stack<>();

        System.out.println("Ingrese la expresion:");
        String expresion = sc.nextLine();

        int i = 0;
        boolean equilibrado = true;

        while (i < expresion.length()) {

            String c = expresion.substring(i, i + 1);

            // Apertura
            if (c.equals("(") || c.equals("{") || c.equals("[")) {
                pila.push(c);
            }

            // Cierre
            if (c.equals(")") || c.equals("}") || c.equals("]")) {

                if (pila.isEmpty()) {
                    equilibrado = false;
                    break;
                }

                String ultimo = pila.pop();

                if (c.equals(")") && !ultimo.equals("(")) {
                    equilibrado = false;
                    break;
                }

                if (c.equals("}") && !ultimo.equals("{")) {
                    equilibrado = false;
                    break;
                }

                if (c.equals("]") && !ultimo.equals("[")) {
                    equilibrado = false;
                    break;
                }
            }

            i++;
        }

        if (!pila.isEmpty()) {
            equilibrado = false;
        }

        if (equilibrado) {
            System.out.println("La expresion esta equilibrada");
        } else {
            System.out.println("La expresion NO esta equilibrada");
        }
    }
}