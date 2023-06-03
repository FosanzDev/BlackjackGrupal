package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mesa;
import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.Mano;

public class StrategyRisky implements Strategy {

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
            if (player.getPuntuacion() < 19) {
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
            if (house.getPuntuacion() < 19) {
                return Opciones.PEDIR_CARTA;

            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    /**
     * Plans a risky bet based on the player's balance
     * It bets 30% of the balance if the score is more than 17
     * If the score is less than 15, it bets 10% of the balance
     * @param saldo
     * @param mesa
     * @param jugador
     * @return
     */
    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        int minBet = mesa.getApuestaMinima();
        int maxBet = mesa.getApuestaMaxima();
        int score = jugador.calcularPuntuacion();
        int bet = 0;

        if (score > 17) {
            bet = (int) (saldo * 0.3);
        } else if (score < 15) {
            bet = (int) (saldo * 0.1);
        } else {
            bet = (int) (saldo * 0.2);
        }

        bet = Math.min(bet, maxBet);
        bet = Math.max(bet, minBet);

        return bet;
    }

}
