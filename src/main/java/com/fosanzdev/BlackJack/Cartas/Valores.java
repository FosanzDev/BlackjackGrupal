package com.fosanzdev.BlackJack.Cartas;

public enum Valores {
    //Valores posibles de las cartas
    AS(1),DOS(2),TRES(3),CUATRO(4),CINCO(5),SEIS(6),SIETE(7),OCHO(8),NUEVE(9),DIEZ(10),J(10),Q(10),K(10);

    //Atributos
    private int valor;
    //Contructor
    Valores(int valor){
        this.valor = valor;
    }

    //Getters
    public int getIntegerValue() {
        return valor;
    }
}
