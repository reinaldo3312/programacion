package TrabajoFinal;

public class Puerto {

    Buque[] buques = new Buque[10];
    int contadorBuques = 0;
    Contenedor[][] matriz = new Contenedor[10][10];
    
    // Registrar buque
     public void registrarBuque(Buque b) {
        // verifica que no exista un buque con el mismo ID
        for (int i = 0; i < contadorBuques; i++) {
            if (buques[i].getId() == b.getId()) {
                System.out.println("Ya hay un buque con ese ID");
                return;
            }
        }
        if (contadorBuques < 10) {
            mostrarPuestosBuques(); // muestra los puestos antes de registrar
            buques[contadorBuques] = b;
            contadorBuques++;
            System.out.println("Buque registrado");
        } else {
            System.out.println("No hay espacio para mas buques");
        }
    }

    // muestra que puestos estan libres y cuales ocupados
    public void mostrarPuestosBuques() {
        for (int i = 0; i < 10; i++)
            System.out.println("[" + i + "] " + (buques[i] == null ? "libre" : "ocupado - " + buques[i].getNombre()));
    }

    public void agregarContenedor(Contenedor c, int columna) {
       
        if (columna < 0 || columna > 9) { System.out.println("Columna invalida"); return; }

        
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (matriz[i][j] != null && matriz[i][j].getId() == c.getId()) {
                    System.out.println("Ya hay un contenedor con ese ID");
                    return;
                }

       
        for (int i = 9; i >= 0; i--) {
            if (matriz[i][columna] == null) {
                matriz[i][columna] = c;
                System.out.println("Contenedor agregado en fila " + i);
                return;
            }
        }
        System.out.println("Esa columna esta llena");
    }

    
    public void mostrarMatriz() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++)
                System.out.print(matriz[i][j] != null ? "[X]" : "[ ]");
            System.out.println();
        }
    }

    
    public double pesoTotal() {
        double total = 0;
        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (matriz[i][j] != null) total = total + matriz[i][j].getPeso();
        return total;
    }

    public void listarOrigen() {
        
        String[] origenes = new String[100];
        int total = 0;

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 10; j++)
                if (matriz[i][j] != null) {
                    String org = matriz[i][j].getOrigen();
                    boolean existe = false;
                    for (int k = 0; k < total; k++)
                        if (origenes[k].equalsIgnoreCase(org)) { existe = true; break; }
                    if (!existe) { origenes[total] = org; total++; }
                }

        if (total == 0) { System.out.println("No hay contenedores"); return; }

        
        for (int k = 0; k < total; k++) {
            System.out.println("\nOrigen: " + origenes[k]);
            double peso = 0; int cantidad = 0;
            for (int i = 0; i < 10; i++)
                for (int j = 0; j < 10; j++)
                    if (matriz[i][j] != null && matriz[i][j].getOrigen().equalsIgnoreCase(origenes[k])) {
                        System.out.println("  " + matriz[i][j]);
                        peso = peso + matriz[i][j].getPeso();
                        cantidad++;
                    }
            System.out.println("  cantidad: " + cantidad + " peso: " + peso + " kg");
        }
    }
}