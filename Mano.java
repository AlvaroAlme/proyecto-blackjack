package BLACKJACK;

import java.util.ArrayList;
import java.util.List;

/*
 * Representa la mano de cartas de un jugador (o de la banca) durante una ronda.
 */
public class Mano {

    private List<Carta> cartas = new ArrayList<>();
    public boolean blackjack = false;
    public boolean pasado = false;

    public void addCarta(Carta carta) {
        cartas.add(carta);
        actualizarEstado();
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    // Suma el valor de las cartas de la mano. Si la suma se pasa de 21 y hay
    // algun As contado como 11, se recalcula contandolo como 1 (regla estandar del blackjack).
    public int sumaCartas() {
        int suma = 0;
        int ases = 0;

        for (Carta carta : cartas) {
            suma += carta.getValor();
            if (carta.esAs()) {
                ases++;
            }
        }

        while (suma > 21 && ases > 0) {
            suma -= 10;
            ases--;
        }

        return suma;
    }

    private void actualizarEstado() {
        int total = sumaCartas();
        this.blackjack = (cartas.size() == 2 && total == 21);
        this.pasado = total > 21;
    }
}
