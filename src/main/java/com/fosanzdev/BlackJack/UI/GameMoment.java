package com.fosanzdev.BlackJack.UI;

import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Cartas.Baraja;

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

    public Jugador getCrupier(){
        return crupier;
    }

    public boolean isFinished(){
        return isFinished;
    }
}
