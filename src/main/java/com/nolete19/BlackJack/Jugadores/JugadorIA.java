package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Mesa;
import com.nolete19.BlackJack.Strategy;

public class JugadorIA extends Jugador {
    
    private Strategy strategy;

    public JugadorIA(String nombre, int dinero, Mesa mesa, Strategy strategy) {
        super(nombre, dinero, mesa);
        this.strategy = strategy;
    }

    public Mano getVisibleHand() {
        return mano.getUniqueCard();
    }

    @Override
    public Opciones opcion() {
        return strategy.opcion(mano, mesa.getManoCrupier());
    } 

    @Override
    public int apuesta() {
        return strategy.apuesta(saldo);
    }


}
