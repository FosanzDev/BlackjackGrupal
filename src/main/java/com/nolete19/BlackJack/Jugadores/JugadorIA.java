package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Strategies.*;

import java.util.Random;

public class JugadorIA extends Jugador {

    //Atributos
    private Strategy strategy;
    //Constructors
    public JugadorIA(String nombre, int dinero) {
        super(nombre, dinero);
        this.strategy = randStrategy();
    }

    public JugadorIA(String nombre, boolean isHouse) {
        super(nombre);
        this.strategy = new StrategyNeutral();
    }
    //Getters
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

    /**
     * Este método se encarga de generar una estrategia aleatoria que sera utilizada
     * por el jugador controlado por la cpu.
     * @return Devuelve un tipo de estrategia que esta almacenado en una posicion concreta de un array.
     */
    private Strategy randStrategy() {
        Strategy[] strategies = {new StrategyNeutral(), new StrategyConservative(), new StrategyRisky(), new StrategyModerate(), new StrategyComplex()};
        final int MIN = 0;
        final int MAX = strategies.length - 1;
        Random rand = new Random();
        int randStratPos = rand.nextInt((MAX - MIN)+ 1) + MIN;
        return strategies[randStratPos];
    }

}
