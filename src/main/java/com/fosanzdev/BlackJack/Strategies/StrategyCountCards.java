package com.fosanzdev.BlackJack.Strategies;

import com.fosanzdev.BlackJack.Mesa;
import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.Mano;
import com.fosanzdev.BlackJack.Jugadores.Opciones;

public class StrategyCountCards implements Strategy {

    @Override
    public Opciones opcion(Mano player, Mano house) {

        if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else if (opcionPlayer(player) == Opciones.PEDIR_CARTA && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PEDIR_CARTA;
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
            if (player.getPuntuacion() < 17) {
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
            if (house.getPuntuacion() < 17) {
                return Opciones.PEDIR_CARTA;

            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    //We apply the Kelly Criterion to calculate the bet
    //https://en.wikipedia.org/wiki/Kelly_criterion
    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        int minBet = mesa.getApuestaMinima();
        int maxBet = mesa.getApuestaMaxima();
        Mano manoJugador = jugador.getMano();
        double probability = calculateWinProbability(manoJugador, mesa);
        double payout = jugador.getMano().isBlackJack() ? 1.5 : 1;
        double kellyBet = kellyCriterion(probability, payout);
        int bet = (int) Math.floor(saldo * kellyBet);
        bet = Math.max(bet, minBet);
        bet = Math.min(bet, maxBet);
        return bet;
    }

    /**
     * Calculate the win probability based on the player's mano and the Crupier's visible card
     * This strategy is based on the following article:
     * https://wizardofodds.com/games/blackjack/strategy/calculator/
     * 1 deck, dealer stands on 17.
     * 
     * 
     * @param manoJugador
     * @param mesa
     * @return
     */
    private double calculateWinProbability(Mano manoJugador, Mesa mesa) {
        int manoValue = manoJugador.getPuntuacion();
        int crupierValue = mesa.getManoCrupier().getPuntuacion();
        if (manoValue <= 8) {
            return 0.2;
        } else if (manoValue == 9) {
            if (crupierValue >= 3 && crupierValue <= 6) {
                return 0.54;
            } else {
                return 0.46;
            }
        } else if (manoValue == 10) {
            if (crupierValue >= 2 && crupierValue <= 9) {
                return 0.56;
            } else {
                return 0.44;
            }
        } else if (manoValue == 11) {
            if (crupierValue >= 2 && crupierValue <= 10) {
                return 0.58;
            } else {
                return 0.42;
            }
        } else if (manoValue == 12) {
            if (crupierValue >= 4 && crupierValue <= 6) {
                return 0.36;
            } else {
                return 0.64;
            }
        } else if (manoValue >= 13 && manoValue <= 16) {
            if (crupierValue >= 2 && crupierValue <= 6) {
                return 0.39;
            } else {
                return 0.61;
            }
        } else { // manoValue >= 17
            return 0.74;
        }
    }

    /**
     * Calculate the bet based on the Kelly Criterion
     * @param probability 
     * @param payout
     * @return
     */
    private double kellyCriterion(double probability, double payout) {
        return (probability * (payout + 1) - 1) / payout;
    }

}
