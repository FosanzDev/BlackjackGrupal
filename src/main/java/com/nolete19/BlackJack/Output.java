package com.nolete19.BlackJack;


public class Output {

    static final String TOP_LEFT = "┌";
    static final String TOP_RIGHT = "┑";
    static final String BOTTOM_LEFT = "└";
    static final String BOTTOM_RIGHT = "┘";
    static final String VERTICAL = "│";
    static final String HORIZONTAL = "─";
    static final String BLANK = " ";
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

    public static String getCards(Carta card) {



        return "";
    }

    public static String getBlankCard(int cardAmount) {
        StringBuilder sb = new StringBuilder();
        String TOP_LEFT = "┌";
        String TOP_RIGHT = "┑";
        String BOTTOM_LEFT = "└";
        String BOTTOM_RIGHT = "┘";
        String VERTICAL = "│";
        String HORIZONTAL = "─";
        String BLANK = " ";







        sb.append(TOP_LEFT).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(TOP_RIGHT).append("\n");
        sb.append(VERTICAL).append("XX").append(BLANK).append(BLANK).append(BLANK).append(BLANK).append(VERTICAL).append("\n");
        sb.append(VERTICAL).append(BLANK).append(BLANK).append(BLANK).append(BLANK).append(BLANK).append(BLANK).append(VERTICAL).append("\n");
        sb.append(VERTICAL).append(BLANK).append(BLANK).append(BLANK).append(BLANK).append("XX").append(VERTICAL).append("\n");
        sb.append(BOTTOM_LEFT).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(BOTTOM_RIGHT);

        for (int i = 0; i < 5; i++) {
            switch (i) {
                case 0:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(topBorder());
                    }
                    sb.append("\n");
                    break;
                case 1:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(topBorder());
                    }
                    break;
                case 2:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(topBorder());
                    }
                    break;
                case 3:
                    for (int j = 0; j < cardAmount; j++) {
                        sb.append(topBorder());
                    }
                    break;

            }
        }







        return sb.toString();
    }

    private static String topBorder() {
        StringBuilder sb = new StringBuilder();
        sb.append(TOP_LEFT).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(HORIZONTAL).append(TOP_RIGHT);
        return sb.toString();
    }

    private static String topMiddle(Carta card) {
        StringBuilder sb = new StringBuilder();







        sb.append(VERTICAL).append("").append(BLANK).append(BLANK).append(BLANK).append(BLANK).append(VERTICAL);
        return sb.toString();
    }

}
