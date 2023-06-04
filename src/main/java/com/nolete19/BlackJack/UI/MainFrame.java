package com.nolete19.BlackJack.UI;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MainFrame extends JFrame{

    private static Logger logger;
    private static GamePanel gamePanel;

    public MainFrame(){
        super("BlackJack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Default close operation
         this.setSize(800, 600); //Set size of window
        this.setLocationRelativeTo(null); //Center window 
        this.setVisible(true); //Make window visible
        this.setLayout(new BorderLayout());
        // this.setResizable(false);
        ImageIcon image = new ImageIcon("src/main/java/com/nolete19/BlackJack/UI/Resources/logo.jpg");
        this.setIconImage(image.getImage());


        logger = new Logger();
        this.add(logger, BorderLayout.SOUTH);
        logger.setSize(getPreferredSize());

        // gamePanel = new GamePanel();
        // this.add(gamePanel, BorderLayout.CENTER);
        // gamePanel.setSize(getPreferredSize()); //Set size of panel

        

        log("Main frame created");
        log("Main frame created");
        log("Main frame created");
        log("Main frame created");
    }

    public void log(String message){
        logger.log(message);
    }
}
