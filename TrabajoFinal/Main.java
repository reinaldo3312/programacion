package TrabajoFinal;

import java.util.Scanner;

public class Main {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Puerto puerto = new Puerto();

        int opcion;

        
        do{


    System.out.println("====MENU====");
    System.out.println("1. Registrar Buque");
    System.out.println("2. Registrar contenedor");
    System.out.println("3. Mostrar peso total");
    System.out.println("4. Listar origen contenedores");
    System.out.println("5. SALIR"                 );


         opcion = sc.nextInt();
         sc.nextLine();

         switch (opcion) {
            case 1:
                System.out.println("ID Buque:");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.println("Nombre Buque:");
                String nombre = sc.nextLine();

                Buque b =new Buque (id, nombre);
                puerto.registrarBuque(b);

                break;

                case 2:

                    System.out.println("Puestos disponibles:");
                    puerto.mostrarMatriz();

                    System.out.println("ID contenedor:");
                    int idc = sc.nextInt();

                    System.out.println("Peso");
                    double peso = sc.nextDouble();
                    sc.nextLine();

                    System.out.println("Origen");
                    String origen = sc.nextLine();

                    System.out.println("columna (0-9):");
                    int columna = sc.nextInt();

                    Contenedor c = new Contenedor (idc, peso, origen);
                    puerto.agregarContenedor(c, columna);

                    puerto.mostrarMatriz();

                    break;

                    case 3:
                    
                    System.out.println("Peso total:"+ puerto.pesoTotal());

                    break;

                    case 4:
                       puerto.listarOrigen();

                    break;

                    case 5:
                        System.out.println("Aplicacion finalizada");
                        break;

                        

                        }

                         }while (opcion !=5);



            


         }
}
