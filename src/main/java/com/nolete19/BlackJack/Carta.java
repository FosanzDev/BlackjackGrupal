package com.nolete19.BlackJack;

public class Carta {
    //Atributos enumerados
    private Palos palo;
    private Valores valor;


    //Constructor
    public Carta(Palos palo, Valores valor) {
        this.palo = palo;
        this.valor = valor;
    }

    //Getters
    public Valores getValor() {
        return valor;
    }
    public Palos getPalo() {
        return palo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "palo=" + palo +
                ", valor=" + valor +
                '}';
    }
}
