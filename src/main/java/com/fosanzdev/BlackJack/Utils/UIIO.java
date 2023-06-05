package com.fosanzdev.BlackJack.Utils;

import com.fosanzdev.BlackJack.UI.GameMoment;
import com.fosanzdev.BlackJack.UI.MainFrame;

public class UIIO {

    public static final String[] MAIN_MENU_OPTIONS = {"Nueva partida", "Estadisticas", "Opciones", "Salir"};
    public static final String[] INGAME_OPTIONS = {"Pedir carta", "Plantarse"};

    private MainFrame mainFrame;

    public UIIO(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public int readOption(GameMoment gameMoment) {
        if (gameMoment == null) {
            mainFrame.setGameMoment(GameMoment.INITIAL);
            gameMoment = GameMoment.INITIAL;
        }
        return mainFrame.waitForButton(gameMoment);
    }

    public int readOption(String... options){
        GameMoment gm = new GameMoment(null, null, false, options);
        return readOption(gm);
    }

    public int readLimitedInt(String text, int min, int max) {
        int option = -1;
        boolean valid = false;
        while (!valid) {
            try {
                String input = readString(text);
                input = input.replaceAll("\\s+", "");
                option = Integer.parseInt(input);
                if (option >= min && option <= max) {
                    valid = true;
                } else {
                    print("Opcion no valida", true);
                }
            } catch (NumberFormatException e) {
                print("Bad format", true);
            }
        }
        return option;
    }

    public void print(String text, boolean n) {
        mainFrame.log(text);
    }

    public String readString(String text){
        return mainFrame.waitForString(text);
    }

    public void waitEnter() {
        readOption();
    }
}
