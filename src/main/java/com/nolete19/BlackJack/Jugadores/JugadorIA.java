package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Strategies.Strategy;
import com.nolete19.BlackJack.Strategies.StrategyConservative;
import com.nolete19.BlackJack.Strategies.StrategyNeutral;
import com.nolete19.BlackJack.Strategies.StrategyRisky;

import java.util.Random;

public class JugadorIA extends Jugador {
    
    private Strategy strategy;

    public JugadorIA(String nombre, int dinero) {
        super(nombre, dinero);
        this.strategy = randStrategy();
    }

    public JugadorIA(String nombre, boolean isHouse) {
        super(nombre);
        this.strategy = new StrategyNeutral();
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
        apuesta = strategy.apuesta(saldo);
        return apuesta;
    }

    private Strategy randStrategy() {
        Strategy[] strategies = {new StrategyNeutral(), new StrategyConservative(), new StrategyRisky()};
        final int MIN = 0;
        final int MAX = strategies.length - 1;
        Random rand = new Random();
        int randStratPos = rand.nextInt((MAX - MIN)+ 1) + MIN;
        return strategies[randStratPos];
    }

}
