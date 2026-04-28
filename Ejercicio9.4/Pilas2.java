import java.util.Scanner;
import java.util.Stack;

public class Pilas2 {

   

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> p1 = new Stack<>();
        Stack<Integer> p2 = new Stack<>();
        Stack<Integer> p3 = new Stack<>();
        Stack<Integer> p4 = new Stack<>();
        Stack<Integer> p5 = new Stack<>();

        int i = 1;
        int j;

        while (i != 0) {

            i = sc.nextInt();

            if (i != 0) {

                j = sc.nextInt();

                if (i == 1) {
                    if (j > 0) {
                        p1.push(j);
                    } else if (j < 0 && !p1.isEmpty()) {
                        p1.pop();
                    }
                }

                if (i == 2) {
                    if (j > 0) {
                        p2.push(j);
                    } else if (j < 0 && !p2.isEmpty()) {
                        p2.pop();
                    }
                }

                if (i == 3) {
                    if (j > 0) {
                        p3.push(j);
                    } else if (j < 0 && !p3.isEmpty()) {
                        p3.pop();
                    }
                }

                if (i == 4) {
                    if (j > 0) {
                        p4.push(j);
                    } else if (j < 0 && !p4.isEmpty()) {
                        p4.pop();
                    }
                }

                if (i == 5) {
                    if (j > 0) {
                        p5.push(j);
                    } else if (j < 0 && !p5.isEmpty()) {
                        p5.pop();
                    }
                }
            }
        }

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
    }
}