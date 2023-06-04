package com.fosanzdev.BlackJack;


import com.fosanzdev.BlackJack.Cartas.Carta;
import com.fosanzdev.BlackJack.Cartas.Valores;

public class Output {

    //Atributos
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

    /**
     * Este método se encarga de mostrar en menu principal del programa,
     * con varias opciones segun la tarea que queramos realizar
     * @return Devuelve un método que se encarga de devolver un String
     */
    public static String getMainMenu() {

        String[] mainMenuItems = {"Nueva partida", "Mostrar estadisticas", "Configuracion", "Salir"};
        return Menu.menu("Blackjack", mainMenuItems);

    }
    /**
     * Este método se encarga de mostrar en menu de configuracion del programa,
     * con varias opciones segun los parametros que deseamos actualizar
     * @return Devuelve un método que se encarga de devolver un String
     */
    public static String getConfigMenu() {

        String[] configMenuItems = {"Cambiar numero de jugadores", "Cambiar la apuesta base", "Cambiar el saldo inicial de los jugadores"};
        return Menu.menu("Configuracion", configMenuItems);

    }

    /**
     * Este método es utilizado para mostrar las cartas por consola
     * incluyendo el numero y los palos que deseemos.
     * @param cards Recibe como parametro una variable de tipo Carta
     * @return Devuelve un string mostrando la carta previamente representada
     */
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

    /**
     * Este método se encarga de generar los bordes superiores necesarios para representar la información
     * con un diseño mas atractivo.
     * @return Devuelve un string con el borde superior montado.
     */
    private static String topBorder() {
        StringBuilder sb = new StringBuilder();
        sb.append(TOP_LEFT);
        for (int i = 0; i < 8; i++)
            sb.append(HORIZONTAL);
        sb.append(TOP_RIGHT);
        return sb.toString();
    }
    /**
     * Este método se encarga de generar los bordes inferiores necesarios para representar la información
     * con un diseño mas atractivo.
     * @return Devuelve un string con el borde inferior montado.
     */
    private static String bottomBorder() {
        StringBuilder sb = new StringBuilder();
        sb.append(BOTTOM_LEFT);
        for (int i = 0; i < 8; i++)
            sb.append(HORIZONTAL);
        sb.append(BOTTOM_RIGHT);
        return sb.toString();
    }

    /**
     * Este método se encarga de recibir una carta y una posicion para establecer donde
     * debe ser pintado el valor medio de la carta.
     * @param card Recibe un parametro de tipo de dato Carta.
     * @param position Recibe un numero entero que representa la posicion para ser pintado.
     * @return Devuelve un String con el valor medio de la carta.
     */
    private static String middleValue(Carta card, int position) {
        StringBuilder sb = new StringBuilder();

        String value = cardValueToString(card);

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

    /**
     * Este método se encarga de recibir una carta y una posicion para establecer donde
     * debe ser pintado el icono/dibujo de la carta.
     * @param card Recibe un parametro de tipo de dato Carta.
     * @param position Recibe un numero entero que representa la posicion para ser pintado.
     * @return Devuelve un String con el icono medio de la carta.
     */
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

    /**
     * Este método se encarga de convertir  el valor de una carta en un String
     * para que sea representado por consola.
     * @param card Recibe como parametro un objeto de tipo Carta.
     * @return En caso de fallo devuelve dos X.
     */
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

    /**
     * Este método se encarga de obtener el palo de la carta y asignarle un simbolo según
     * el tipo al que corresponda.
     * @param card Recibe como parametro una variable de tipo Carta.
     * @return En caso de no encontrar coincidencias devuelve un String en forma de x.
     */
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
