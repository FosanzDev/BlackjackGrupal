package com.nolete19.BlackJack.Jugadores;
import java.util.ArrayList;
import java.util.Iterator;

import com.nolete19.BlackJack.Cartas.Carta;
import com.nolete19.BlackJack.Cartas.Valores;

public class Mano implements Iterable<Carta>{
    private ArrayList<Carta> cartas;
    private int puntuacion = 0;
    private boolean isBlackJack;

    // Constructor con el arrayList inicializado
    public Mano() {
        cartas = new ArrayList<>();
    }

    public Mano getUniqueCard(){
        Mano mano = new Mano();
        try{
            mano.addCarta(cartas.get(0));
        } catch (IndexOutOfBoundsException e){
            //Do nothing
        }

        return mano;
    }

    /**
     * Este método se encarga de comprobar la puntuacion de las cartas que tiene el jugador en la mano
     * además de si tiene 2 cartas en la mano verificiar si son blackJack o no.
     * @return Devuelve la puntuacion calculada.
     */
    public int calcularPuntuacion(){
        boolean as = false;
        boolean diez = false;

        for (Carta carta : cartas){
            puntuacion = puntuacion + carta.getValor().getIntegerValue();
            if (cartas.size() == 2){
                if (carta.getValor() == Valores.AS){
                    as = true;
                }else if (carta.getValor().getIntegerValue() == 10){
                    diez = true;
                }
            }
            if(as && diez){
                isBlackJack = true;
            }
        }

        return puntuacion;
    }

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
        isBlackJack = false;
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
        StringBuilder sb = new StringBuilder();
        for (Carta carta : cartas){
            sb.append(carta.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<Carta> iterator() {
        return cartas.iterator();
    }
}
