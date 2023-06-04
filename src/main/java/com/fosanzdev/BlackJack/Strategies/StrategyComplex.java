package com.fosanzdev.BlackJack.Strategies;

import com.fosanzdev.BlackJack.Mesa;
import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.Mano;
import com.fosanzdev.BlackJack.Jugadores.Opciones;

public class StrategyComplex implements Strategy {

    /**
     * M�todo que determina la opci�n de juego para el jugador en funci�n de su mano y la mano de la casa.
     * @param player La mano del jugador.
     * @param house La mano de la casa (crupier).
     * @return La opci�n de juego del jugador.
     */
    public Opciones opcion(Mano player, Mano house) {
        if (player.getPuntuacion() < 12) {
            return Opciones.PEDIR_CARTA;
        }

        if (player.getPuntuacion() == 18 && house.getUniqueCard().getPuntuacion() <= 9) {
            return Opciones.PLANTARSE;
        }

        if ((house.getPuntuacion() == 7 || house.getPuntuacion() == 8) && player.getPuntuacion() >= 12 && player.getPuntuacion() <= 16) {
            return Opciones.PLANTARSE;
        }

        if (player.getPuntuacion() >= 19) {
            return Opciones.PLANTARSE;
        }

        if (player.getPuntuacion() >= 17 && house.getUniqueCard().getPuntuacion() >= 7) {
            return Opciones.PLANTARSE;
        }

        return Opciones.PEDIR_CARTA;
    }

    @Override
    public Opciones opcionPlayer(Mano player) {
        // Utiliza el m�todo 'opcion' con la mano del jugador y 'null' para la mano de la casa
        return opcion(player, null);
    }

    @Override
    public Opciones opcionHouse(Mano house) {
        // Determina la opci�n de juego para la casa (crupier) bas�ndose en su mano
        if (house.getPuntuacion() < 17) {
            return Opciones.PEDIR_CARTA;
        } else {
            return Opciones.PLANTARSE;
        }
    }

    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        // Calcula la apuesta del jugador en funci�n de su saldo y la puntuaci�n de su mano
        int apuestaPequeno = (int) (saldo * 0.10);
        int apuestaMedio = (int) (saldo * 0.15);
        int apuestaGrande = (int) (saldo * 0.20);

        int puntuacion = jugador.getMano().getPuntuacion();

        if (puntuacion < 15) {
            return apuestaPequeno;
        } else if (puntuacion >= 15 && puntuacion <= 20) {
            return apuestaMedio;
        } else {
            return apuestaGrande;
        }
    }
}

