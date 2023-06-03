package com.nolete19.BlackJack;

<<<<<<< HEAD

import com.nolete19.BlackJack.Cartas.Carta;
import com.nolete19.BlackJack.Cartas.Valores;

=======
import com.nolete19.BlackJack.Cartas.*;
>>>>>>> 0fc151700ea3a8a22c53a406bad7b1bf76feb5ba
public class Output {

    static final String TOP_LEFT = "┌";
    static final String TOP_RIGHT = "┑";
    static final String BOTTOM_LEFT = "└";
    static final String BOTTOM_RIGHT = "┘";
    static final String VERTICAL = "│";
    static final String HORIZONTAL = "─";
    static final String BLANK = "\u0020";
    static final String SPADE = "♠";
    static final String HEART = "♥";
    static final String DIAMOND = "♦";
    static final String CLUB = "♣";


    public static String getMainMenu() {

        String[] mainMenuItems = {"Nueva partida", "Mostrar estadisticas", "Configuracion", "Salir"};
        return Menu.menu("Blackjack", mainMenuItems);

    }

    public static String getConfigMenu() {

        String[] configMenuItems = {"Cambiar numero de jugadores", "Cambiar la apuesta base", "Cambiar el saldo inicial de los jugadores"};
        return Menu.menu("Configuracion", configMenuItems);

    }

    public static String getCards(Carta[] cards) {
        StringBuilder sb = new StringBuilder();
        int cardAmount = cards.length;


        for (int i = 0; i < 6; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(topBorder());
                    }
                    sb.append("\n");
                    break;
                case 1:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(middleValue(cards[j], 1));
                    }
                    sb.append("\n");
                    break;
                case 2:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(middleSuit(cards[j], 1));
                    }
                    sb.append("\n");
                    break;
                case 3:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(middleSuit(cards[j], 2));
                    }
                    sb.append("\n");
                    break;
                case 4:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(middleValue(cards[j], 2));
                    }
                    sb.append("\n");
                    break;
                case 5:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(bottomBorder());
                    }
                    sb.append("\n");
                    break;
            }
        }







        return sb.toString();
    }

    private static String topBorder() {
        StringBuilder sb = new StringBuilder();
        sb.append(TOP_LEFT);
        for (int i = 0; i < 8; i++)
            sb.append(HORIZONTAL);
        sb.append(TOP_RIGHT);
        return sb.toString();
    }

    private static String bottomBorder() {
        StringBuilder sb = new StringBuilder();
        sb.append(BOTTOM_LEFT);
        for (int i = 0; i < 8; i++)
            sb.append(HORIZONTAL);
        sb.append(BOTTOM_RIGHT);
        return sb.toString();
    }

    private static String middleValue(Carta card, int position) {
        StringBuilder sb = new StringBuilder();

        String value = cardValueToString(card);
        String suit = cardSuitToString(card);

        if (position == 1) {
            sb.append(VERTICAL);
            if (card.getValor() == Valores.DIEZ) {
                sb.append(value);
            } else {
                sb.append(BLANK).append(value);
            }
            for (int i = 0; i < 6; i++) {
                sb.append(BLANK);
            }
            sb.append(VERTICAL);
            return sb.toString();
        } else {
            sb.append(VERTICAL);
            for (int i = 0; i < 6; i++) {
                sb.append(BLANK);
            }
            if (card.getValor() == Valores.DIEZ) {
                sb.append(value);
            } else {
                sb.append(value).append(BLANK);
            }
            sb.append(VERTICAL);
            return sb.toString();
        }
    }

    private static String middleSuit(Carta card, int position) {
        StringBuilder sb = new StringBuilder();

        if (position == 1) {
            sb.append(VERTICAL).append(BLANK).append(cardSuitToString(card));
            for (int i = 0; i < 6; i++)
                sb.append(BLANK);
            sb.append(VERTICAL);
        } else {
            sb.append(VERTICAL);
            for (int i = 0; i < 6; i++)
                sb.append(BLANK);
            sb.append(cardSuitToString(card)).append(BLANK).append(VERTICAL);
        }


        return sb.toString();
    }

    private static String cardValueToString(Carta card) {
        switch (card.getValor().getIntegerValue()) {
            case 1 :
                return "A";
            case 2, 3, 4, 5, 6, 7, 8, 9:
                return String.valueOf(card.getValor().getIntegerValue()) ;
            case 10:
                switch (card.getValor()) {
                    case DIEZ:
                        return "10";
                    case J:
                        return "J";
                    case Q:
                        return "Q";
                    case K:
                        return "K";
                    default:
                        return "XX";
                }
            default:
                return "XX";
        }
    }

    private static String cardSuitToString(Carta card) {
        switch (card.getPalo()) {
            case TREBOL:
                return SPADE;
            case CORAZONES:
                return HEART;
            case PICAS:
                return CLUB;
            case DIAMANTES:
                return DIAMOND;
        }
        return "X";
    }

}
