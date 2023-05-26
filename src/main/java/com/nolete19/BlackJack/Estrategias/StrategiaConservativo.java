package com.nolete19.BlackJack.Estrategias;

import com.nolete19.BlackJack.Jugadores.Opcion;
import com.nolete19.BlackJack.Mano;

public class StrategiaConservativo implements Strategia {
    @Override
    public Opcion takeTurn(Mano hand) {
        if (hand.calcularPuntuacion() < 14) {
            return Opcion.PEDIR;
        } else if (hand.calcularPuntuacion() > 13) {
            return Opcion.PLANTAR;
        } else {
            return Opcion.PLANTAR;
        }
    }

    @Override
    public Opcion takeTurn(Mano hand, Mano house) {

        if (house.calcularPuntuacion() > 19 && hand.calcularPuntuacion() > 19) {
            return Opcion.PLANTAR;
        } else if (house.calcularPuntuacion() > 19 && hand.calcularPuntuacion() < 20 ) {

        }



        if (hand.calcularPuntuacion() < 20) {
            return Opcion.PEDIR;
        } else if (hand.calcularPuntuacion() > 19) {
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
