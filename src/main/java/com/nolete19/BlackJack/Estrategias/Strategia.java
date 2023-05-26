package com.nolete19.BlackJack.Estrategias;

import com.nolete19.BlackJack.Jugadores.Opcion;
import com.nolete19.BlackJack.Mano;

public interface Strategia {

    public Opcion takeTurn(Mano hand);

    public Opcion takeTurn(Mano hand, Mano house);

    /**
     * Gets the hand that the player has and the house has and chooses what to do.
     * Obtiene el mano del jugador y el mano del crupier y decide lo que tiene que hacer.
     * @param hand Hand that the player has. Mano que tiene el jugador.
     * @param house Hand that the house has. Mano que tiene el crupier.
     * @param otherPlayerHands Hands of the other players, used for counting cards. Manos de otros jugadores, usado para contar cartas.
     * @return Returns an Opcion enum. Devuelve un Opcion enum.
     */
    public Opcion takeTurn(Mano hand, Mano house, Mano[] otherPlayerHands);


}
