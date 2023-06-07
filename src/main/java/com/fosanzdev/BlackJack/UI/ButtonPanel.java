package com.fosanzdev.BlackJack.UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.CountDownLatch;

import javax.swing.JPanel;

public class ButtonPanel extends JPanel implements MouseListener{

    private String[] options = new String[] {""};
    private int buttonClicked;
    private CountDownLatch latch;

    public ButtonPanel(Dimension size){
        super();
        this.setPreferredSize(size);
        this.addMouseListener(this);
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Paint the background
        paintBackground(g2d);

        //Paint the buttons
        paintButtons(g2d);
    }

    private void paintBackground(Graphics2D g2d){
        g2d.setColor(new java.awt.Color(100, 100, 200));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void paintButtons(Graphics2D g2d){
        int options = this.options.length;
        int width = this.getWidth();
        int height = this.getHeight();

        int buttonHeight = height / options;

        //Draw the separator lines
        g2d.setColor(new java.awt.Color(0, 0, 0));
        for (int i=1; i<options; i++){
            g2d.drawLine(0, i * buttonHeight, width, i * buttonHeight);
        }

        //Draw the button labels
        g2d.setColor(new java.awt.Color(255, 255, 255));
        for (int i=0; i<options; i++){
            g2d.drawString(this.options[i], 10, (i+1) * buttonHeight - buttonHeight/2);
        }
    }

    private int getButtonByPosition(int x, int y){
        int options = this.options.length;
        int height = this.getHeight();

        int buttonHeight = height / options;

        int button = y / buttonHeight;

        return button;
    }

    public int waitForButton(String... options) {
        this.options = options;
        this.latch = new CountDownLatch(1);
        try {
            this.latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        int button = this.buttonClicked;
        this.buttonClicked = -1;
        return button;
    }
    
    public void setGameMoment(GameMoment gameMoment){
        setOptions(gameMoment.getOptions());
    }

    public void setOptions(String[] options){
        this.options = options;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //Get the mouse position
        int x = e.getX();
        int y = e.getY();

        //Get the button by the mouse position
        int button = getButtonByPosition(x, y);
        buttonClicked = button;
        latch.countDown();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}