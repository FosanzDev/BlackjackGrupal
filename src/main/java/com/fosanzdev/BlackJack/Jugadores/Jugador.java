package com.fosanzdev.BlackJack.Jugadores;
import com.fosanzdev.BlackJack.Mesa;
import com.fosanzdev.BlackJack.Cartas.Carta;
import com.fosanzdev.BlackJack.Cartas.Valores;
import com.fosanzdev.BlackJack.Utils.UIIO;


public abstract class Jugador {
    //Atributos
    protected String nombre;
    protected Mano mano;
    protected int saldo;
    protected int puntuacion;
    protected int apuesta;
    protected Mesa mesa;
    protected UIIO ioInterface;

    //Constructor
    public Jugador(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        mano = new Mano();
    }

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.saldo = 0;
        mano = new Mano();
    }

    //Setters
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
        this.ioInterface = mesa.getIoInterface();
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una carta a la mano del jugador
     * @param carta Carta a añadir
     */
    public void addCarta(Carta carta) {
        mano.addCarta(carta);
    }

    public int getApuesta() {
        return apuesta;
    }

    public void setApuesta(int apuesta) {
        this.apuesta = apuesta;
    }

    public int getSaldo() {
        return saldo;
    }

    public void addDinero(int dinero) {
        saldo += dinero;
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

    public void reset(){
        mano.clear();
        puntuacion = 0;
        apuesta = 0;
    }
    //Setters
    public void setBlackJack(boolean blackJack) {
        mano.setBlackJack(blackJack);
    }

    public abstract Opciones opcion();
    public abstract int apuesta();

}



