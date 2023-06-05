package com.fosanzdev.BlackJack.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

    private Dimension statPanelSize;
    private Dimension cardsPanelSize;
    private Dimension buttonPanelSize;

    private StatPanel statPanel;
    private CardsPanel cardsPanel;
    private ButtonPanel buttonPanel;

    public GamePanel(Dimension size){
        super();
        this.setPreferredSize(size);
        this.setLayout(new BorderLayout());

        //Stat panel
        this.statPanelSize = new Dimension((int) (size.getWidth() * 0.1), (int) size.getHeight());
        statPanel = new StatPanel(statPanelSize);
        this.add(statPanel, BorderLayout.WEST);

        //Main game panel
        this.cardsPanelSize = new Dimension((int) (size.getWidth() * 0.8), (int) size.getHeight());
        cardsPanel = new CardsPanel(cardsPanelSize);
        this.add(cardsPanel, BorderLayout.CENTER);

        //Button panel
        this.buttonPanelSize = new Dimension((int) (size.getWidth() * 0.1), (int) size.getHeight());
        buttonPanel = new ButtonPanel(buttonPanelSize);
        this.add(buttonPanel, BorderLayout.EAST);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        resizeAll();
    }

    public void resizeAll(){
        statPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.1), (int) this.getSize().getHeight());
        statPanel.setPreferredSize(statPanelSize);

        cardsPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.8), (int) this.getSize().getHeight());
        cardsPanel.setPreferredSize(cardsPanelSize);

        buttonPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.1), (int) this.getSize().getHeight());
        buttonPanel.setPreferredSize(buttonPanelSize);
    }

    public void setGameMoment(GameMoment gameMoment){
        statPanel.setPlayer(gameMoment.getJugador());
        cardsPanel.setGameMoment(gameMoment);
        buttonPanel.setGameMoment(gameMoment);
    }
}