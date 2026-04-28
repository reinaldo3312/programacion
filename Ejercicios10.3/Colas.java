import java.util.*;

public class Colas {

    static final int TOTAL_CARRITOS = 25;
    static final int NUM_CAJAS = 3;

    // Cola de carritos disponibles
    static Queue<Integer> carritosDisponibles = new LinkedList<>();

    // Colas de cada caja (cada cola contiene IDs de clientes)
    static Queue<Integer>[] cajas = new LinkedList[NUM_CAJAS];

    // Cola de clientes esperando carrito
    static Queue<Integer> clientesEsperando = new LinkedList<>();

    static int clienteActual = 0;
    static int pagosCompletados = 0;

    public static void main(String[] args) {
        // Inicializar carritos
        for (int i = 1; i <= TOTAL_CARRITOS; i++) {
            carritosDisponibles.add(i);
        }

        // Inicializar cajas
        for (int i = 0; i < NUM_CAJAS; i++) {
            cajas[i] = new LinkedList<>();
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("=== SIMULACIÓN SUPERMERCADO ===");
        System.out.println("Carritos disponibles: " + TOTAL_CARRITOS);
        System.out.println("Cajas de pago: " + NUM_CAJAS);

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Llega un cliente");
            System.out.println("2. Cliente paga en caja");
            System.out.println("3. Ver estado actual");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> clienteLlega();
                case 2 -> clientePaga();
                case 3 -> mostrarEstado();
                case 0 -> System.out.println("Cerrando supermercado...");
                default -> System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }

    static void clienteLlega() {
        clienteActual++;
        int id = clienteActual;

        if (carritosDisponibles.isEmpty()) {
            // No hay carritos: el cliente espera
            clientesEsperando.add(id);
            System.out.println("Cliente #" + id + " espera: no hay carritos disponibles.");
        } else {
            // Asignar carrito y unirse a la caja más corta
            int carrito = carritosDisponibles.poll();
            int cajaMenor = cajaMasCorta();
            cajas[cajaMenor].add(id);
            System.out.println("Cliente #" + id + " toma carrito #" + carrito
                    + " → se une a Caja " + (cajaMenor + 1)
                    + " (" + cajas[cajaMenor].size() + " en cola)");
        }
    }

    static void clientePaga() {
        // Buscar la caja con algún cliente (la más corta con gente)
        int cajaElegida = -1;
        for (int i = 0; i < NUM_CAJAS; i++) {
            if (!cajas[i].isEmpty()) {
                if (cajaElegida == -1 || cajas[i].size() < cajas[cajaElegida].size()) {
                    cajaElegida = i;
                }
            }
        }

        if (cajaElegida == -1) {
            System.out.println("No hay clientes en ninguna caja.");
            return;
        }

        int clienteId = cajas[cajaElegida].poll();
        pagosCompletados++;

        // Liberar el carrito (lo devolvemos al pool)
        carritosDisponibles.add(pagosCompletados); // carrito simbólico liberado

        System.out.println("Cliente #" + clienteId + " pagó en Caja "
                + (cajaElegida + 1) + ". Carrito liberado.");

        // Si alguien estaba esperando carrito, asignarlo
        if (!clientesEsperando.isEmpty()) {
            int clienteEnEspera = clientesEsperando.poll();
            int carrito = carritosDisponibles.poll();
            int cajaMenor = cajaMasCorta();
            cajas[cajaMenor].add(clienteEnEspera);
            System.out.println("Cliente #" + clienteEnEspera
                    + " (esperaba) recibe carrito #" + carrito
                    + " → se une a Caja " + (cajaMenor + 1));
        }
    }

    static int cajaMasCorta() {
        int menor = 0;
        for (int i = 1; i < NUM_CAJAS; i++) {
            if (cajas[i].size() < cajas[menor].size()) {
                menor = i;
            }
        }
        return menor;
    }

    static void mostrarEstado() {
        System.out.println("\n====== ESTADO ACTUAL ======");
        System.out.println("Carritos disponibles: " + carritosDisponibles.size());
        System.out.println("Clientes esperando carrito: " + clientesEsperando.size());
        if (!clientesEsperando.isEmpty()) {
            System.out.println("  → En espera: " + clientesEsperando);
        }

        System.out.println("\nColas de cajas:");
        for (int i = 0; i < NUM_CAJAS; i++) {
            System.out.println("  Caja " + (i + 1) + " (" + cajas[i].size() + " clientes): "
                    + (cajas[i].isEmpty() ? "libre" : cajas[i]));
        }

        System.out.println("\nPagos completados: " + pagosCompletados);
        System.out.println("===========================");
    }
}