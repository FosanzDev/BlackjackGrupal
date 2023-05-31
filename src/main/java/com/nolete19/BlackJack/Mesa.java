package com.nolete19.BlackJack;

import com.nolete19.BlackJack.Cartas.Baraja;
import com.nolete19.BlackJack.Exceptions.UnexistentPlayer;
import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.JugadorIA;
import com.nolete19.BlackJack.Jugadores.Mano;

import java.util.ArrayList;

public class Mesa {

    private final Baraja baraja;
    private final ArrayList<Jugador> jugadores;
    
    private JugadorIA crupier;
    private int apuestaMinima;
    private int apuestaMaxima;

    public Mesa(int apuestaMinima, int apuestaMaxima) {
        this.baraja = new Baraja();
        this.apuestaMinima = apuestaMinima;
        this.apuestaMaxima = apuestaMaxima;
        this.jugadores = new ArrayList<>();
    }

    public int getApuestaMinima() {
        return apuestaMinima;
    }

    public int getApuestaMaxima() {
        return apuestaMaxima;
    }

    public Mano getManoCrupier() {
        return crupier.getVisibleHand();
    }




    public void repartirCartas(Jugador[] jugadores) throws UnexistentPlayer {
        for (int i = 0; i < 2; i++) {
            for (Jugador jugador : jugadores) {
                repartirCarta(jugador);
            }
        }
    }




    
    public void repartirCarta(Jugador jugador) throws UnexistentPlayer {
        jugador.addCarta(baraja.sacarCarta());
    }


    public void retirarJugador(Jugador jugador) throws UnexistentPlayer {
        for (Jugador j : jugadores) {
            if (j.equals(jugador)) {
                jugadores.remove(j);
                return;
            }
        }
    }


    public ArrayList<Jugador> getJugadores(){
        return jugadores;
    }
}
