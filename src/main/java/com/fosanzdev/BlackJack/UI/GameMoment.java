package com.fosanzdev.BlackJack.UI;

import com.fosanzdev.BlackJack.Jugadores.Jugador;

public class GameMoment {
    private static final String[] MAIN_MENU_OPTIONS = {"Nueva partida", "Estadisticas", "Opciones", "Salir"};

    public static GameMoment INITIAL = new GameMoment(null, null, false, MAIN_MENU_OPTIONS);

    private Jugador jugador;
    private Jugador crupier;
    private boolean isFinished;
    private String[] options;

    public GameMoment(Jugador jugador, Jugador crupier, boolean isFinished, String... options){
        this.jugador = jugador;
        this.crupier = crupier;
        this.isFinished = isFinished;
        this.options = options;
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

    public String[] getOptions(){
        return options;
    }
}
