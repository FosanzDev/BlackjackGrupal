package com.fosanzdev.BlackJack.UI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
    private String bigLog = "";
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

        //Paint the text
        paintText(g2d);
    }

    public void paintBackground(Graphics2D g2d){
        g2d.setColor(new java.awt.Color(0, 100, 0));
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
    }

    private void paintCards(Graphics2D g2d, Jugador jugador2, Jugador crupier2) {
        Mano manoCrupier;
        Mano manoJugador;
        if (jugador != null)
            manoJugador = jugador.getMano();
        else
            manoJugador = null;
        
        if (crupier != null)
            manoCrupier = isFinished ? crupier.getMano() : crupier.getMano().getUniqueCard();
        else 
            manoCrupier = null;

        for (int i = 1; i <= 2; i++) {
            if (i == 1){
                if (manoCrupier == null)
                    continue;
            } else if (i == 2){
                if (manoJugador == null)
                    continue;
            }
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

    public void paintText(Graphics2D g2d) {
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.BOLD, 20));
        //Calculate the width of the text
        int width = g2d.getFontMetrics().stringWidth(bigLog);
        //Draw the text in the center of the panel
        g2d.drawString(bigLog, (this.getWidth() - width) / 2, this.getHeight() / 2);
    }

    public void bigLog(String text){
        bigLog = text;
    }

    public void setGameMoment(GameMoment gameMoment){
        jugador = gameMoment.getJugador();
        crupier = gameMoment.getCrupier();
        isFinished = gameMoment.isFinished();
    }
    
}
