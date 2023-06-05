package com.fosanzdev.BlackJack.Jugadores;
import java.util.ArrayList;
import java.util.Iterator;

import com.fosanzdev.BlackJack.Cartas.Carta;
import com.fosanzdev.BlackJack.Cartas.Valores;

public class Mano implements Iterable<Carta>{
    //Atributos
    private ArrayList<Carta> cartas;
    private int puntuacion = 0;
    private boolean isBlackJack;

    // Constructor con el arrayList inicializado
    public Mano() {
        cartas = new ArrayList<>();
    }

    /**
     * Este método se encarga de obtener solo una carta, para representar
     * mejor el punto de vista del jugador que solo ve una carta del crupier
     * @return Devuelve la mano con una unica carta.
     */
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
    private void calcularPuntuacion(){
        System.out.println("Calculando puntuacion");
        if (cartas.size() == 0 || cartas == null){
            puntuacion = 0;
            System.out.println("No hay cartas en la mano");
            return;
        }
        
        boolean as = false;
        boolean diez = false;
        puntuacion = 0;

        System.out.println("Recorriendo cartas");
        for (Carta carta : cartas){
            System.out.println("Carta: " + carta.toString());
            if (carta == null){
                System.out.println("Carta nula");
                puntuacion = 0;
            }
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
        calcularPuntuacion();
        return puntuacion;
    }

    public boolean isBlackJack() {
        return isBlackJack;
    }

    public void setBlackJack(boolean blackJack) {
        isBlackJack = blackJack;
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
