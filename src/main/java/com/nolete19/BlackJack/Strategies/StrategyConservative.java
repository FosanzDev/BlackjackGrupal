package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mesa;
import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.Mano;

public class StrategyConservative implements Strategy {

    @Override
    public Opciones opcion(Mano player, Mano house) {

        if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PEDIR_CARTA) {
            return Opciones.PEDIR_CARTA;
        }

        return null;
    }

    @Override
    public Opciones opcionPlayer(Mano player) {

        if (!player.isBlackJack()) {
            if (player.getPuntuacion() < 15) {
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
            if (house.getPuntuacion() < 15) {
                return Opciones.PEDIR_CARTA;

            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    /**
     * Apuesta un 10% del saldo si tiene entre 15 y 20 puntos, y un 5% si tiene menos de 15 puntos
     * @param saldo Saldo del jugador
     * @param minBet Apuesta minima
     * @param maxBet Apuesta maxima
     * @return Apuesta
     */
    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        int minBet = mesa.getApuestaMinima();
        int maxBet = mesa.getApuestaMaxima();
        int bet = 0;

        if (jugador.getMano().getPuntuacion() >= 15 && jugador.getMano().getPuntuacion() <= 20) {
            bet = (int) (saldo * 0.1);
        } else if (jugador.getMano().getPuntuacion() < 15) {
            bet = (int) (saldo * 0.05);
        }

        bet = Math.min(bet, maxBet);
        bet = Math.max(bet, minBet);

        return bet;
    }
}
