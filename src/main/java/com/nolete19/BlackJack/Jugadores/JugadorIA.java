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

<<<<<<< HEAD
    public JugadorIA(String nombre, boolean isHouse) {
        super(nombre);
        this.strategy = new StrategyNeutral();
=======
    public JugadorIA(String nombre, int dinero, Mesa mesa, boolean isHouse) {
        super(nombre, dinero, mesa);
        if (isHouse) {
            this.strategy = new StrategyNeutral();
        } else {
            this.strategy = randStrategy();
        }

>>>>>>> 0fc151700ea3a8a22c53a406bad7b1bf76feb5ba
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
        apuesta = strategy.apuesta(saldo, mesa, this);
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
