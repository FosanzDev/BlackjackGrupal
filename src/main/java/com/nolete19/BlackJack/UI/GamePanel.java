package com.nolete19.BlackJack.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel{

    private Dimension statPanelSize;

    private JPanel statPanel;
    private JPanel mainGamePanel;
    private JPanel buttonPanel;

    public GamePanel(Dimension size){
        super();
        this.setPreferredSize(size);
        this.setLayout(new BorderLayout());

        //Stat panel
        this.statPanelSize = new Dimension((int) (size.getWidth() * 0.2), (int) size.getHeight());
        statPanel = new StatPanel(statPanelSize);
        this.add(statPanel, BorderLayout.WEST);
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
        statPanelSize = new Dimension((int) (this.getSize().getWidth() * 0.2), (int) this.getSize().getHeight());
        statPanel.setPreferredSize(statPanelSize);
    }

    public void paintAll(Graphics2D g2d){
        statPanel.paint(g2d);
    }

    public void paintBackground(Graphics2D g){
        g.setColor(new Color(0, 150, 100));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}