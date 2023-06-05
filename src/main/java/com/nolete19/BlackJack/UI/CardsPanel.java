package com.nolete19.BlackJack.UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.nolete19.BlackJack.Cartas.Carta;
import com.nolete19.BlackJack.Jugadores.Jugador;
import com.nolete19.BlackJack.Jugadores.Mano;

public class CardsPanel extends JPanel{

    private Jugador jugador = null;
    private Jugador crupier = null;
    private boolean isFinished = false;
    private Dimension offset;

    public CardsPanel(Dimension size, Dimension offset){
        super();
        this.setPreferredSize(size);
        this.offset = offset;
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        //Paint the background
        paintBackground(g2d);

        //Paint the cards
        paintCards(g2d, jugador, crupier);
    }

    public void setOffset(Dimension offset){
        this.offset = offset;
    }

    public void paintBackground(Graphics2D g2d){
        g2d.setColor(new java.awt.Color(0, 100, 0));
        g2d.fillRect((int)offset.getWidth(), (int)offset.getHeight(), this.getWidth(), this.getHeight());
    }

    private void paintCards(Graphics2D g2d, Jugador jugador2, Jugador crupier2) {
        if (jugador == null || crupier == null){
            return;
        }
        Mano manoCrupier = isFinished ? crupier.getMano() : crupier.getMano().getUniqueCard();
        Mano manoJugador = jugador.getMano();

        //Paint the cards of the crupier
        int xPos = getWidth();
        int maxY = getHeight()/2;
        int numCartas = manoCrupier.getCartas().size();
        ArrayList<Carta> cartas = manoCrupier.getCartas();

        for (int i=0; i<numCartas; i++){
            int imageWidth = cartas.get(i).getImage().getWidth(null);
            int imageHeight = cartas.get(i).getImage().getHeight(null);
            int imageX = xPos/numCartas + xPos/numCartas/2;
            int imageY = maxY/2 - imageHeight/2;
            cartas.get(i).getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);

            int x = xPos/numCartas + xPos/numCartas/2;
        }
    }
    
}
