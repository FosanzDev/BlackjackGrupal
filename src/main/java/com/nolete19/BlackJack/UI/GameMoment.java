package com.nolete19.BlackJack.UI;

import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Cartas.Baraja;

public class GameMoment {

    public static GameMoment INITIAL = new GameMoment(null, null, false);

    private Jugador jugador;
    private Jugador crupier;
    private boolean isFinished;

    public GameMoment(Jugador jugador, Jugador crupier, boolean isFinished){
        this.jugador = jugador;
        this.crupier = crupier;
        this.isFinished = isFinished;
    }

    public Jugador getJugador(){
        return jugador;
    }
}
