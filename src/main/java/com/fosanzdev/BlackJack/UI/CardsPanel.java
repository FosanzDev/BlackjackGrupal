package com.fosanzdev.BlackJack.UI;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.fosanzdev.BlackJack.Cartas.Carta;
import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.Mano;

public class CardsPanel extends JPanel{

    private Jugador jugador = null;
    private Jugador crupier = null;
    private boolean isFinished = false;
    public CardsPanel(Dimension size){
        super();
        this.setPreferredSize(size);
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

    public void paintBackground(Graphics2D g2d){
        g2d.setColor(new java.awt.Color(0, 100, 0));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void paintCards(Graphics2D g2d, Jugador jugador2, Jugador crupier2) {
        if (jugador == null || crupier == null)
            return;
        Mano manoCrupier = isFinished ? crupier.getMano() : crupier.getMano().getUniqueCard();
        Mano manoJugador = jugador.getMano();

        for (int i = 1; i <= 2; i++) {
            ArrayList<Carta> cartas;
            if (i == 1 && !isFinished)
                cartas = manoCrupier.getCartas();
            else if (i == 1 && isFinished)
                cartas = manoCrupier.getCartas();
            else
                cartas = manoJugador.getCartas();

            int numCartasJugador = cartas.size();
            int width = this.getWidth();
            int height = (this.getHeight()) / 2;

            for (int j = 0; j < numCartasJugador; j++) {
                // Get the image of the card
                Carta carta = cartas.get(j);
                Image img = carta.getImage();
                int imgWidth = img.getWidth(null);
                int imgHeight = img.getHeight(null);
                int newImgHeight = (int) (height * 0.8);
                int newImgWidth = (int) (imgWidth * ((double) newImgHeight / imgHeight));
                BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = resized.createGraphics();
                g.drawImage(img, 0, 0, newImgWidth, newImgHeight, null);

                int xPos = (j * (width / numCartasJugador)) + ((width / numCartasJugador) - newImgWidth) / 2;
                int yPos = 0 + height + ((0 - height) - newImgHeight) / 2;

                if (xPos < 0)
                    xPos = 0;

                if (yPos < 0)
                    yPos = 0;

                // Draw the image
                g2d.drawImage(resized, xPos, yPos + ((i-1) * (height - 0)), null);
            }
        }
        
    }

    public void setGameMoment(GameMoment gameMoment){
        jugador = gameMoment.getJugador();
        crupier = gameMoment.getCrupier();
        isFinished = gameMoment.isFinished();
    }
    
}
