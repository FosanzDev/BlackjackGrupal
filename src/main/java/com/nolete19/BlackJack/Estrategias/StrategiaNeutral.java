package com.nolete19.BlackJack.Estrategias;

import com.nolete19.BlackJack.Jugadores.Opcion;
import com.nolete19.BlackJack.Mano;

public class StrategiaNeutral implements Strategia {
    @Override
    public Opcion takeTurn(Mano hand) {

        if (hand.calcularPuntuacion() < 17) {
            return Opcion.PEDIR;
        } else if (hand.calcularPuntuacion() > 16) {
            return Opcion.PLANTAR;
        } else {
            return Opcion.PLANTAR;
        }
    }

    @Override
    public Opcion takeTurn(Mano hand, Mano house) {

        if (hand.calcularPuntuacion() < 17) {
            return Opcion.PEDIR;
        } else if (hand.calcularPuntuacion() > 16) {
            return Opcion.PLANTAR;
        } else {
            return Opcion.PLANTAR;
        }
    }

    @Override
    public Opcion takeTurn(Mano hand, Mano house, Mano[] otherPlayerHands) {
        return null;
    }

}
