package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.Mano;
import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mesa;

public class StrategyModerate implements Strategy {
    @Override
    public Opciones opcion(Mano player, Mano house) {
        if (opcionPlayer(player) == Opciones.PLANTARSE && opcionHouse(house) == Opciones.PLANTARSE) {
            return Opciones.PLANTARSE;
        } else {
            return Opciones.PEDIR_CARTA;
        }
    }

    @Override
    public Opciones opcionPlayer(Mano player) {
        if (!player.isBlackJack()) {
            if (player.getPuntuacion() < 16) {
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
            if (house.getPuntuacion() < 16) {
                return Opciones.PEDIR_CARTA;
            }
        } else {
            return Opciones.PLANTARSE;
        }
        return Opciones.PLANTARSE;
    }

    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        // Apuesta un 10% del saldo si tiene entre 15 y 20 puntos, y un 5% si tiene menos de 15 puntos
        int apuestaGrande = (int) (saldo * 0.20);
        int apuestaMedio = (int) (saldo * 0.10);

        if (jugador.getMano().getPuntuacion() >= 15 && jugador.getMano().getPuntuacion() <= 20) {
            return apuestaGrande;
        } else {
            return apuestaMedio;
        }
    }
}
