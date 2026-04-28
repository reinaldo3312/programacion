import java.util.*;

public class Colas {

    public static void main(String[] args) {

        int TIEMPO_TOTAL = 420; // 7 horas en minutos
        int UMBRAL_CAJA4 = 20;  // abrir caja 4 si hay 20+ esperando

        Queue<Integer> fila = new LinkedList<>();
        Random rand = new Random();

        // Tiempos de atención por caja (min y max en minutos)
        int[][] rangos = {
            {1, 2},  // caja 1: entre 1.5 y 2.5 (usamos enteros simples)
            {2, 5},  // caja 2
            {2, 4},  // caja 3
            {2, 4}   // caja 4
        };

        boolean[] cajaOcupada = {false, false, false, false};
        boolean caja4Abierta = false;

        int clientesAtendidos = 0;
        int maxFila = 0;
        int sumaFila = 0;
        int muestras = 0;
        int maxEspera = 0;
        int tiempoCaja4 = 0;

        int proximaLlegada = rand.nextInt(3); // primer cliente llega en 0-2 min

        for (int t = 0; t < TIEMPO_TOTAL; t++) {

            // Llega un cliente en este minuto?
            if (t == proximaLlegada) {
                proximaLlegada = t + 1 + rand.nextInt(2); // siguiente en 1-2 min

                // Buscar caja libre
                int cajaLibre = -1;
                for (int i = 0; i < (caja4Abierta ? 4 : 3); i++) {
                    if (!cajaOcupada[i]) {
                        cajaLibre = i;
                        break;
                    }
                }

                if (cajaLibre == -1) {
                    // No hay caja libre, va a la fila
                    fila.add(t); // guarda el tiempo que llegó
                    System.out.println("t=" + t + " | Cliente llega → hace fila (fila: " + fila.size() + ")");
                } else {
                    // Hay caja libre, se atiende
                    cajaOcupada[cajaLibre] = true;
                    clientesAtendidos++;
                    System.out.println("t=" + t + " | Cliente llega → Caja " + (cajaLibre + 1));
                }
            }

            // Abrir/cerrar caja 4
            if (!caja4Abierta && fila.size() >= UMBRAL_CAJA4) {
                caja4Abierta = true;
                System.out.println("t=" + t + " | *** Caja 4 ABIERTA (fila=" + fila.size() + ") ***");
            }
            if (caja4Abierta && fila.isEmpty()) {
                caja4Abierta = false;
                System.out.println("t=" + t + " | *** Caja 4 CERRADA ***");
            }
            if (caja4Abierta) tiempoCaja4++;

            // Atender clientes de la fila si hay caja libre
            for (int i = 0; i < (caja4Abierta ? 4 : 3); i++) {
                if (!cajaOcupada[i] && !fila.isEmpty()) {
                    int tiempoLlegada = fila.poll();
                    int espera = t - tiempoLlegada;
                    if (espera > maxEspera) maxEspera = espera;

                    cajaOcupada[i] = true;
                    clientesAtendidos++;
                    System.out.println("t=" + t + " | Cliente pasa de fila → Caja " + (i + 1) + " (esperó " + espera + " min)");
                }
            }

            // Liberar cajas (simular que terminó la atención)
            for (int i = 0; i < 4; i++) {
                if (cajaOcupada[i]) {
                    int r = rangos[i][0] + rand.nextInt(rangos[i][1] - rangos[i][0] + 1);
                    if (rand.nextInt(r) == 0) { // probabilidad de terminar
                        cajaOcupada[i] = false;
                    }
                }
            }

            // Registrar estadísticas de fila
            sumaFila += fila.size();
            muestras++;
            if (fila.size() > maxFila) maxFila = fila.size();
        }

        // Resultados
        System.out.println("\n======= ESTADÍSTICAS =======");
        System.out.println("Clientes atendidos : " + clientesAtendidos);
        System.out.println("Tamaño medio fila  : " + (sumaFila / muestras));
        System.out.println("Tamaño máximo fila : " + maxFila);
        System.out.println("Espera máxima      : " + maxEspera + " minutos");
        System.out.println("Tiempo caja 4 abierta: " + tiempoCaja4 + " minutos");
        System.out.println("============================");
    }
}