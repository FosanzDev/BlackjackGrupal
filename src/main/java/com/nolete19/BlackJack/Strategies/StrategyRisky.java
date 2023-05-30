package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mano;

public class StrategyRisky implements Strategy {

    private int saldoIncial;

    public StrategyRisky(int saldoIncial) {
        this.saldoIncial = saldoIncial;
    }
    @Override
    public Opciones opcion(Mano player, Mano house) {

        if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PEDIR_CARTA;
        } else if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PEDIR_CARTA;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PEDIR_CARTA;
        }

        return null;
    }

    @Override
    public Opciones opcionPlayer(Mano player) {

        if (!player.isBlackJack()) {
            if (player.calcularPuntuacion() < 19) {
                return Opciones.PEDIR_CARTA;
            } else {
                return Opciones.PLANTARSE;
            }
        } else {
            return Opciones.PLANTARSE;
        }
    }


    @Override
    public Opciones opcionHouse(Mano house) {

        if (!house.isBlackJack()) {
            if (house.calcularPuntuacion() < 19) {
                return Opciones.PEDIR_CARTA;

            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    @Override
    public int apuesta(int saldo) {
        return 0;
    }

}
