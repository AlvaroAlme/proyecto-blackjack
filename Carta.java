package BLACKJACK;

public class Carta {

    private int numCarta;
    private int valor;

    public Carta(int numCarta) {
        this.numCarta = numCarta;
        setValor(numCarta);
    }

    public int getNumCarta() {
        return this.numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
        setValor(numCarta);
    }

    public int getValor() {
        return this.valor;
    }

    // El valor de la carta se calcula a partir de su numero (1-13).
    // El As (numCarta == 1) se asigna inicialmente a 11; es la mano (Mano.sumaCartas())
    // la que decide si debe contar como 1 cuando la suma total se pasa de 21.
    public void setValor(int numCarta) {
        if (numCarta == 11 || numCarta == 12 || numCarta == 13) {
            valor = 10;
        } else if (numCarta == 1) {
            valor = 11;
        } else {
            valor = numCarta;
        }
    }

    public boolean esAs() {
        return this.numCarta == 1;
    }
}
