package com.fosanzdev.BlackJack.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.fosanzdev.BlackJack.Cartas.Baraja;
import com.fosanzdev.BlackJack.Jugadores.JugadorHumano;
import com.fosanzdev.BlackJack.Jugadores.JugadorIA;

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

        int xSize = this.getSize().width;
        int ySize = this.getSize().height;

        System.out.println("xSize: " + xSize + " ySize: " + ySize);
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


    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        JugadorHumano jugador = new JugadorHumano("Esteban", 2000);
        JugadorIA jugador2 = new JugadorIA("Jugador 2", 2000);
        JugadorIA crupier = new JugadorIA("Crupier", 2000);
        jugador.addCarta(baraja.sacarCartaPila());
        jugador.addCarta(baraja.sacarCartaPila());
        jugador.addCarta(baraja.sacarCartaPila());
        jugador2.addCarta(baraja.sacarCartaPila());
        jugador2.addCarta(baraja.sacarCartaPila());
        crupier.addCarta(baraja.sacarCartaPila());
        crupier.addCarta(baraja.sacarCartaPila());

        MainFrame mainFrame = new MainFrame();
        mainFrame.log("Main frame created");
        mainFrame.log("Jugador: " + jugador.toString());
        mainFrame.log("Jugador 2: " + jugador2.toString());
        mainFrame.log("Crupier: " + crupier.toString());

        
        GameMoment gameMoment = new GameMoment(jugador, crupier, false, new String[]{"Pedir", "Plantarse"});
        GameMoment gameMoment2 = new GameMoment(jugador2, crupier, false, new String[]{"Nada", "Plantarse"});

        mainFrame.setGameMoment(gameMoment);
        mainFrame.setVisible(true);

        mainFrame.setVisible(true);
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
        int i = 0;
        while(true){
            try {
                Thread.sleep(1000/60);
                log ("Frame: " + i++);
                i++;
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
