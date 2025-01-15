package BLACKJACK;

public class Carta {

    private int numCarta;
    private int valor;
    private int sumaCartas = 0;
    int primeraCarta;
    int segundaCarta;

    public Carta(int numCarta, int valor) {
        this.numCarta = numCarta;
        this.valor = valor;
    }
    
    public int getNumCarta(){
        return this.numCarta;
    }

    public void setNumCarta(int numCarta){
        this.numCarta = numCarta;
    }

    public int getValor(){
        return this.valor;
    }
    
    public void setValor(int numCarta) {

        if (numCarta == 11) {
            valor = 10;
        } else if (numCarta == 12) {
            valor = 10;
        } else if (numCarta == 13) {
            valor = 10;
        } else if (numCarta == 1) {
            if (this.sumaCartas > 21) {
                valor = 1;
            } else {
                valor = 11;
            }
        } else {
            valor = numCarta;
        }
    }

    public void sumaCartas(int numCarta){
        int sumaCarta = numCarta + numCarta;
        System.out.println("Conteo de tu mano: " +  sumaCarta);
    }
}


