package com.nolete19.BlackJack.UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
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

        // System.out.println("Players are not nul");
        // Mano manoCrupier = isFinished ? crupier.getMano() : crupier.getMano().getUniqueCard();
        Mano manoJugador = jugador.getMano();

        ArrayList<Carta> cartasJugador = manoJugador.getCartas();
        int numCartasJugador = cartasJugador.size();
        int offsetX = (int) offset.getWidth();
        int offsetY = (int) offset.getHeight();
        int width = this.getWidth() - offsetX; 
        int height = (this.getHeight()-offsetY) / 2;

        for (int i=0; i<numCartasJugador; i++){
            Carta carta = cartasJugador.get(i);
            Image img = carta.getImage();
            int imgWidth = img.getWidth(null);
            int imgHeight = img.getHeight(null);

            int newImgHeight = height;
            int newImgWidth = (int) (imgWidth * ((double) newImgHeight / imgHeight));

            BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = resized.createGraphics();
            g.drawImage(img, 0, 0, newImgWidth, newImgHeight, null);

            int xPos = offsetX + (width / 2) - (width / 4) + (i * width / 2) - (i * width / numCartasJugador);
            int yPos = offsetY + (height / 2) - (height / 2);
            g2d.drawImage(resized, xPos, yPos, null);
        }
    }

    public void setGameMoment(GameMoment gameMoment){
        jugador = gameMoment.getJugador();
    }
    
}
