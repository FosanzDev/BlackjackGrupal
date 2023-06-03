package com.nolete19.BlackJack.Jugadores;
import com.nolete19.BlackJack.Cartas.Valores;
import com.nolete19.BlackJack.Mesa;
import com.nolete19.BlackJack.Cartas.Carta;


public abstract class Jugador {

    protected String nombre;
    protected Mano mano;
    protected int saldo;
    protected int puntuacion;
    protected Mesa mesa;

    //Constructor
    public Jugador(String nombre, int saldo, Mesa mesa) {
        this.nombre = nombre;
        this.saldo = saldo;
        mano = new Mano();
        this.mesa = mesa;
    }

    /**
     * Añade una carta a la mano del jugador
     * @param carta Carta a añadir
     */
    public void addCarta(Carta carta) {
        mano.addCarta(carta);
    }


    /**
     * Calcula la puntuación de la mano del jugador
     * @return Integer con la puntuación de la mano
     */
    public int calcularPuntuacion() {
        puntuacion = 0;
        int numAces = 0;

        for (Carta carta : mano) {
            if (carta.getValor() == Valores.AS) {
                numAces++;
                puntuacion += 11;
            } else {
                puntuacion += carta.getValor().getIntegerValue();
            }
        }

        while (puntuacion > 21 && numAces > 0) {
            puntuacion -= 10;
            numAces--;
        }

        return puntuacion;
    }

    // @FosanzDev: Es necesario este método?

    //Método para mostrar las cartas en la mano del jugador
    public void mostrarMano() {
        System.out.println("La mano del jugador es:");
        for (Carta carta : mano) {
            System.out.println(carta);
            //Se muestra cada una de las cartas de la mano del jugador
        }
    }

    /**
     * Método para obtener la mano del jugador (sus cartas)
     * @return Objeto Mano con la mano del jugador
     */
    public Mano getMano() {
        return mano;
    }

    /**
     * Limpia la mano del jugador
     */
    public void clear() {
        mano.clear();
    }

    public abstract Opciones opcion();
    public abstract int apuesta();

}



