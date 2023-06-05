package com.nolete19.BlackJack.Cartas;
import java.util.Random;
import java.util.Stack;

public class Baraja {
    //Atributo
    private Stack<Carta> cartas;

    //Contructor
    public Baraja() {
        cartas = new Stack<>();
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

        for (Palos palo : palos) {
            for (Valores valor : valores) {
                Carta carta = new Carta(palo,valor);
                cartas.push(carta);
            }
        }
    }

    /**
     * Este método se encarga de mezclar el array de las cartas que tenemos ordenadas, para tener un orden
     * aleatorio con el que poder jugar la partida.
     */
    private void barajar(){
        Random random = new Random();
        Stack<Carta> barajadas = new Stack<>();
        for (int i = 0; i < cartas.size(); i++) {
            int posicionRandom = random.nextInt(cartas.size());
            barajadas.push(cartas.get(posicionRandom));
            cartas.remove(posicionRandom);
        }
        cartas = barajadas;
    }

    /**
     * Este método se encarga de sacar la carta que siempre esta mas arriba de la baraja mezclada, para poder asignarla
     * a los jugadores que la deseen.
     * @return Retorna un objeto carta con el que poder jugar.
     */
    public Carta sacarCartaPila() {
        return cartas.pop();
    }



    //Getters
    public Carta[] getCartas() {
        return cartas.toArray(new Carta[0]);
    }
}
