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

    private StatPanel statPanel;
    private CardsPanel cardsPanel;
    private JPanel buttonPanel;

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
        cardsPanel = new CardsPanel(cardsPanelSize, new Dimension(statPanelSize.width, 0));
        this.add(cardsPanel, BorderLayout.CENTER);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Paint the background
        paintBackground(g2d);
        resizeAll();
        paintAll(g2d);
    }

    public void resizeAll(){
        statPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.1), (int) this.getSize().getHeight());
        statPanel.setPreferredSize(statPanelSize);

        cardsPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.8), (int) this.getSize().getHeight());
        cardsPanel.setOffset(new Dimension(statPanelSize.width, 0));
        cardsPanel.setPreferredSize(cardsPanelSize);
    }

    public void paintAll(Graphics2D g2d){
        cardsPanel.paint(g2d);
        statPanel.paint(g2d);
    }

    public void paintBackground(Graphics2D g){
        g.setColor(new Color(0, 150, 100));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void setGameMoment(GameMoment gameMoment){
        statPanel.setPlayer(gameMoment.getJugador());
        cardsPanel.setGameMoment(gameMoment);
    }
}