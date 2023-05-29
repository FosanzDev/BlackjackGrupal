package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mano;

public abstract class Strategy {

    /**
     * Gets the hand that the player has and the house has and chooses what to do.
     * Obtiene el mano del jugador y el mano del crupier y decide lo que tiene que hacer.
     *
     * @param house Hand that the player has. Mano que tiene el jugador.
     * @param house Hand that the house has. Mano que tiene el crupier.
     * @return Returns an Opcion enum. Devuelve un Opcion enum.
     */
    public Opciones opcion(Mano player, Mano house) {
        return null;
    }

    /**
     * Gets the hand of the player and decides what to do. Coge la mano del jugador y decide que hacer.
     *
     * @param player Players hands. Mano del jugador.
     * @return Pedir carta o plantarse
     */
    public Opciones opcionPlayer(Mano player) {
        return null;
    }

    /**
     * Gets the hand of the house and decides what to do. Coge la mano del crupier y decide que hacer.
     *
     * @param house Players hands. Mano del jugador.
     * @return Pedir carta o plantarse
     */
    public Opciones opcionHouse(Mano house) {
        return null;
    }

    public int apuesta(int saldo) {

        return 0;
    }
}
