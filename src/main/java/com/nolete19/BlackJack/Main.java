package com.nolete19.BlackJack;

import java.util.Scanner;

import com.nolete19.BlackJack.Configuracion.Configuracion;
import com.nolete19.BlackJack.Estadisticas.Estadisticas;
import com.nolete19.BlackJack.Jugadores.JugadorHumano;
import com.nolete19.BlackJack.Jugadores.JugadorIA;
import com.nolete19.BlackJack.Utils.IO;

public class Main {

    public static void main(String[] args) {
        Configuracion configuracion = new Configuracion();
        Estadisticas estadisticas = new Estadisticas();
        IO ioInterface = new IO(new Scanner(System.in));
        Mesa mesa = new Mesa(10, 100, ioInterface, configuracion, estadisticas);
        Juego juego = new Juego(mesa);
        JugadorHumano jugador = new JugadorHumano("Jugador", 1000);
        JugadorIA crupier = new JugadorIA("JugadorIA", 2000);
        mesa.addJugador(jugador);
        mesa.addJugador(crupier);

        juego.run();
    }
}
