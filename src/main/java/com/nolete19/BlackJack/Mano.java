package com.nolete19.BlackJack;
import java.util.ArrayList;

public class Mano {
    private ArrayList<Carta> cartas;
    private int puntuacion;
    private boolean isBlackJack;

    // Constructor con el arrayList inicializado
    public Mano() {
        cartas = new ArrayList<>();
    }


    /*public int calcularPuntuacion(){

    }*/

    /**
     * Este método se encarga de recibir una carta de la clase baraja y agregarla a la mano
     * del jugador, para poder operar con las cartas sacadasd de la baraja.
     * @param cartaSacada Carta sacada de la baraja mezclada.
     * @return Devuelve true en caso de que la carta es añadida correctamente.
     */
    public boolean addCarta(Carta cartaSacada){
        cartas.add(cartaSacada);
        return true;
    }

    /**
     * Este método se encarga de eliminar todas las cartas que tiene el jugador en la mano,
     * de manera que la mano queda vaciada.
     */
    public void clear(){
        cartas.clear();
    }
    //Getters
    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public boolean isBlackJack() {
        return isBlackJack;
    }

    /**
     * Método toString para imprimir por pantalla los valores pertenecientes a dicha clase.
     * @return Devuelve una String de los valores de los atributos de la clase  corrrespondiente.
     */
    @Override
    public String toString() {
        return "Mano{" +
                "cartas=" + cartas +
                ", puntuacion=" + puntuacion +
                ", isBlackJack=" + isBlackJack +
                '}';
    }
}
