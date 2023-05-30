package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Mano;
import com.nolete19.BlackJack.Mesa;
import com.nolete19.BlackJack.Strategies.Strategy;
import com.nolete19.BlackJack.Strategies.StrategyConservative;
import com.nolete19.BlackJack.Strategies.StrategyNeutral;
import com.nolete19.BlackJack.Strategies.StrategyRisky;

import java.util.Random;

public class JugadorIA extends Jugador {
    
    private Strategy strategy;

    public JugadorIA(String nombre, int dinero, Mesa mesa, Strategy strategy) {
        super(nombre, dinero, mesa);
        this.strategy = strategy;
    }

    public JugadorIA(String nombre, int dinero, Mesa mesa, boolean isHouse) {
        super(nombre, dinero, mesa);
        if (isHouse) {
            this.strategy = new StrategyNeutral(saldo);
        } else {
            this.strategy = randStrategy();
        }

    }

    public Mano getVisibleHand() {
        return mano.getUniqueCard();
    }

    public Mano getMano() {
        return mano;
    }

    @Override
    public Opciones opcion() {
        return strategy.opcion(mano, mesa.getManoCrupier());
    }

    @Override
    public int apuesta() {
        return strategy.apuesta(saldo);
    }

    private Strategy randStrategy() {
        Strategy[] strategies = {new StrategyNeutral(saldo), new StrategyConservative(saldo), new StrategyRisky(saldo)};
        final int MIN = 0;
        final int MAX = strategies.length - 1;
        Random rand = new Random();
        int randStratPos = rand.nextInt((MAX - MIN)+ 1) + MIN;
        return strategies[randStratPos];
    }




}
