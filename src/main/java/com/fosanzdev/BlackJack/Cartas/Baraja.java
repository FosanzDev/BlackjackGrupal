package com.fosanzdev.BlackJack.Cartas;
import java.util.Random;

public class Baraja {
    //Atributo
    private static final int CANT_CARTAS = 52;
    private Carta[] cartas;

    //Contructor
    public Baraja() {
        cartas = new Carta[CANT_CARTAS];
        rellenarBaraja();
        barajar();
    }

    /**
     * Este método se encarga de generar la baraja y rellenarla con los valores asociados
     * a las clases de tipo enumerado llamadas Palos y Valores
     */
    private void rellenarBaraja(){
        Palos[] palos = Palos.values();
        Valores[] valores = Valores.values();

        int cont = 0;
        for (Palos palo : palos) {
            for (Valores valor : valores) {
                Carta carta = new Carta(palo,valor);
                cartas[cont] = carta;
                cont++;
            }
        }
    }

    /**
     * Este método se encarga de mezclar el array de las cartas que tenemos ordenadas, para tener un orden
     * aleatorio con el que poder jugar la partida.
     */
    private void barajar(){
        Random random = new Random();
        for (int i = 0; i < CANT_CARTAS; i++) {
            int posicionRandom = random.nextInt(CANT_CARTAS);
            Carta cartaTemp = cartas[i];
            cartas[i] = cartas[posicionRandom];
            cartas[posicionRandom] = cartaTemp;
        }

    }

    /**
     * Este método se encarga de sacar la carta que siempre esta mas arriba de la baraja mezclada, para poder asignarla
     * a los jugadores que la deseen.
     * @return Retorna un objeto carta con el que poder jugar.
     */
    public Carta sacarCartaPila() {
        Carta cartaSeleccionada;
        for(int i = 0; i < cartas.length;i++){
            if(cartas[i] != null){
                cartaSeleccionada = cartas[i];
                cartas[i] = null;
                return cartaSeleccionada;
            }
        }
        return null;
    }



    //Getters
    public Carta[] getCartas() {
        return cartas;
    }
}
