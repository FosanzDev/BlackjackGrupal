package com.fosanzdev.BlackJack.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.JugadorHumano;

public class StatPanel extends JPanel{
    
    private Jugador jugador = new JugadorHumano("Jugador", 1000);

    public StatPanel(Dimension size){
        super();
        this.setPreferredSize(size);
    }

    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Paint the background
        paintBackground(g2d);

        //Paint the stats
        paintStats(g2d, jugador);
    }

    public void paintBackground(Graphics2D g2d){
        g2d.setColor(new Color(0, 0, 100));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    public void paintStats(Graphics2D g2d, Jugador jugador){
        Dimension size = this.getSize();
        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        //Paint the lines
        for (int i=1; i<4; i++){
            g2d.setColor(Color.WHITE);
            g2d.drawLine(0, (i * height / 4), width-width/2, (i * height / 4) );
        }

        //Paint the labels
        g2d.setColor(Color.WHITE);
        int xPos = width/6;
        int yPos = height / 4;
        g2d.drawString("Nombre: ", xPos, yPos/2);
        g2d.drawString("Dinero: ", xPos, yPos * 2 - yPos/2);
        g2d.drawString("Apuesta: ", xPos, yPos * 3 - yPos/2);
        g2d.drawString("Puntuacion: ", xPos, yPos * 4 - yPos/2);

        //Paint the values
        if (jugador != null){
            g2d.drawString(jugador.getNombre(), xPos, yPos/2 + 20);
            g2d.drawString(Integer.toString(jugador.getSaldo()), xPos, yPos * 2 - yPos/2 + 20);
            g2d.drawString(Integer.toString(jugador.getApuesta()), xPos, yPos * 3 - yPos/2 + 20);
            g2d.drawString(Integer.toString(jugador.getMano().getPuntuacion()), xPos, yPos * 4 - yPos/2 + 20);
        }
    }

    public void setPlayer(Jugador jugador){
        this.jugador = jugador;
    }
}
