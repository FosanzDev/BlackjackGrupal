package com.nolete19.BlackJack;

public class Menu {

    public static String menu(String header, String[] optionTitles) {
        StringBuilder sb = new StringBuilder();
        final String BORDER_HORIZONTAL = "=";
        final String BORDER_VERTICAL = "|";
        int optionAmount = optionTitles.length;
        for (int i = 0; i < 2; i++) {
            if (i == 1) {
            sb.append(header.toUpperCase());
            }
            for (int j = 0; j < 10; j++) {
                sb.append(BORDER_HORIZONTAL);
            }

        }
        sb.append("\n");
        for (int i = 0; i < optionAmount; i++) {
            sb.append(BORDER_VERTICAL).append(" ").append(i + 1).append(". -").append(optionTitles[i]).append("\n");
        }
        for (int i = 0; i < 20 + header.length(); i++) {
            sb.append(BORDER_HORIZONTAL);
        }

        return sb.toString();
    }
}
