package com.nolete19.BlackJack.UI;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Logger extends JPanel{
    String text = "";

    public Logger(Dimension size){
        super();
        this.setPreferredSize(size);
    }

    public void updateSize(){
        this.setSize(getPreferredSize()); //Set size of panel
        repaint();
    }

    public void log(String message){
        String preText = text;
        text = "";
        text += (message + "\n" + preText);
        if (text.length() > 300){
            text = text.substring(0, 300);
        }
        repaint();
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics g2d = (Graphics) g;

        //Paint the textArea
        paintTextArea(g2d);
        updateSize();
    }

    private void paintTextArea(Graphics g){
        JTextArea textArea = new JTextArea();
        textArea.setText(text);
        textArea.setEditable(false);
        textArea.setSize(getPreferredSize());
        textArea.paint(g);
    }
}
