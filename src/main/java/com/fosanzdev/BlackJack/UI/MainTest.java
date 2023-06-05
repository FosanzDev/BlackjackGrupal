package com.fosanzdev.BlackJack.UI;

import javax.swing.JLabel;

import com.fosanzdev.BlackJack.Cartas.Baraja;
public class MainTest {
    public static void main(String[] args) {
        int fps = 1;
        int frameTime = 1000/fps;

        MainFrame mainFrame = new MainFrame();
        
        Baraja baraja = new Baraja();

        JLabel label = new JLabel();
        label.setText("Some text");

        

    
        mainFrame.setVisible(true);

        long lastMilliSeconds = System.currentTimeMillis();
        boolean running = true;
        while(running){
            if (lastMilliSeconds + frameTime > System.currentTimeMillis()){
                update(mainFrame, baraja);
                mainFrame.repaint();
                lastMilliSeconds = System.currentTimeMillis();
            }
        }
    }

    public static void update(MainFrame mainFrame, Baraja baraja){
            for (int i=0; i<20; i++) {
            // 500 * 726 is the size of the image
            // We will resize the image to 1/3 of the original size
            int width = 500/5;
            int height = 726 / 5;
    }
}
}
