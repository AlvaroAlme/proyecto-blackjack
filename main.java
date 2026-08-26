package BLACKJACK;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * Punto de entrada del juego. Antes este archivo estaba vacio y el proyecto
 * no llegaba a compilar; aqui se implementa una ronda de blackjack jugable
 * por consola usando las clases Carta y Mano.
 */
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Carta> baraja = crearBaraja();
        Collections.shuffle(baraja);

        Mano jugador = new Mano();
        Mano banca = new Mano();

        jugador.addCarta(baraja.remove(0));
        banca.addCarta(baraja.remove(0));
        jugador.addCarta(baraja.remove(0));
        banca.addCarta(baraja.remove(0));

        System.out.println("=== BLACKJACK ===");
        System.out.println("Carta visible de la banca: " + banca.getCartas().get(0).getNumCarta());

        while (!jugador.pasado) {
            System.out.println("Tu mano suma: " + jugador.sumaCartas());
            System.out.print("¿Quieres pedir carta? (s/n): ");
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                jugador.addCarta(baraja.remove(0));
            } else {
                break;
            }
        }

        if (jugador.pasado) {
            System.out.println("Te has pasado con " + jugador.sumaCartas() + ". Pierdes la ronda.");
            scanner.close();
            return;
        }

        System.out.println("Turno de la banca...");
        while (banca.sumaCartas() < 17) {
            banca.addCarta(baraja.remove(0));
        }

        int totalJugador = jugador.sumaCartas();
        int totalBanca = banca.sumaCartas();

        System.out.println("Tu mano final: " + totalJugador);
        System.out.println("Mano final de la banca: " + totalBanca);

        if (banca.pasado || totalJugador > totalBanca) {
            System.out.println("¡Ganas la ronda!");
        } else if (totalJugador == totalBanca) {
            System.out.println("Empate.");
        } else {
            System.out.println("Gana la banca.");
        }

        scanner.close();
    }

    private static List<Carta> crearBaraja() {
        List<Carta> baraja = new ArrayList<>();
        for (int palo = 0; palo < 4; palo++) {
            for (int numCarta = 1; numCarta <= 13; numCarta++) {
                baraja.add(new Carta(numCarta));
            }
        }
        return baraja;
    }
}
