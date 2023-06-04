package com.nolete19.BlackJack.Strategies;

import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.Mano;
import com.nolete19.BlackJack.Jugadores.Opciones;
import com.nolete19.BlackJack.Mesa;

public class StrategyComplex implements Strategy {
    public Opciones opcion(Mano player, Mano house) {
        // Si el jugador tiene menos de 12 puntos, siempre pedir carta
        if (player.getPuntuacion() < 12) {
            return Opciones.PEDIR_CARTA;
        }

        // Si el jugador tiene 18 puntos y la casa tiene 9 o menos, plantarse
        if (player.getPuntuacion() == 18 && house.getPrimeraCarta().getValor().getIntegerValue() <= 9) {
            return Opciones.PLANTARSE;
        }

        // Si la casa tiene 7 u 8 puntos, y el jugador tiene entre 12 y 16 puntos, plantarse
        if ((house.getPuntuacion() == 7 || house.getPuntuacion() == 8) && player.getPuntuacion() >= 12 && player.getPuntuacion() <= 16) {
            return Opciones.PLANTARSE;
        }

        // En cualquier otro caso, pedir carta
        return Opciones.PEDIR_CARTA;
    }


    @Override
    public Opciones opcionPlayer(Mano player) {
        // Utilizar la misma lógica que el método "opcion()"
        return opcion(player, null);
    }

    @Override
    public Opciones opcionHouse(Mano house) {
        // Si la casa tiene menos de 17 puntos, pedir carta. De lo contrario, plantarse.
        if (house.getPuntuacion() < 17) {
            return Opciones.PEDIR_CARTA;
        } else {
            return Opciones.PLANTARSE;
        }
    }

    @Override
    public int apuesta(int saldo, Mesa mesa, Jugador jugador) {
        // Apuesta un 10% del saldo si tiene menos de 15 puntos, un 15% si tiene entre 15 y 20 puntos, y un 20% si tiene más de 20 puntos.
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
