package com.fosanzdev.BlackJack.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame implements Runnable{

    private static Dimension startSize = new Dimension(800, 600);
    private Dimension loggerDimension = new Dimension(startSize.width, startSize.height/4);
    private Dimension gamePanelDimension = new Dimension(startSize.width, startSize.height - loggerDimension.height);

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
        ImageIcon image = new ImageIcon("src/main/java/com/fosanzdev/BlackJack/UI/Resources/logo.jpg");
        this.setIconImage(image.getImage());

        this.setBackground(new Color(0,0,0));


        logger = new Logger(loggerDimension);
        this.add(logger, BorderLayout.SOUTH);

        gamePanel = new GamePanel(gamePanelDimension);
        this.add(gamePanel, BorderLayout.CENTER);

        Thread mainFrameThread = new Thread(this);
        mainFrameThread.start();
    }

    public void log(String message){
        logger.log(message);
    }

    public void bigLog(String message){
        gamePanel.bigLog(message);
    }

    public int waitForButton(GameMoment gameMoment){
        return gamePanel.waitForButton(gameMoment);
    }

    public String waitForString(String text, String comment) {
        //Crea un JFrame con un JTextArea y un JButton
        JFrame stringReader = new JFrame();
        stringReader.setSize(200, 100);
        stringReader.setLocationRelativeTo(null);
        stringReader.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel(text);
        labelPanel.add(label, BorderLayout.NORTH);

        JLabel label2 = new JLabel(comment);
        labelPanel.add(label2, BorderLayout.SOUTH);

        panel.add(labelPanel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    stringReader.dispose();
                }
            }
        });
        panel.add(textArea, BorderLayout.CENTER);

        JButton button = new JButton("Enviar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(textArea.getText());
                stringReader.dispose();
            }
        });
        panel.add(button, BorderLayout.SOUTH);

        stringReader.add(panel);

        stringReader.pack();

        textArea.requestFocus();

        while (stringReader.isVisible()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return textArea.getText();
    }

    public void resizeAll(){
        loggerDimension = new Dimension(getSize().width, getSize().height/4);
        logger.setPreferredSize(loggerDimension);

        gamePanelDimension = new Dimension(getSize().width, getSize().height - loggerDimension.height);
        gamePanel.setPreferredSize(gamePanelDimension);
    }

    public void setGameMoment(GameMoment gameMoment){
        gamePanel.setGameMoment(gameMoment);
    }

    public void repaint(){
        super.repaint();
        resizeAll();
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000/60);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
