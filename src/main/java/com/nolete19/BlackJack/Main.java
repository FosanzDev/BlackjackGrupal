package com.nolete19.BlackJack;

public class Main {

    public static void main(String[] args) {
        Carta card1 = new Carta(Palos.DIAMANTES, Valores.CINCO);
        Carta card2 = new Carta(Palos.CORAZONES, Valores.DIEZ);
        Carta card3 = new Carta(Palos.PICAS, Valores.K);

        Carta[] cardArr = {card1, card2};
        System.out.println(Output.getCards(cardArr));


    }
}
