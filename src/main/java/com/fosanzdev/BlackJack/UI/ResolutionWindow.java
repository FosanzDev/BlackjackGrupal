package com.fosanzdev.BlackJack.UI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.JugadorIA;

public class ResolutionWindow extends JFrame{

    private static final long serialVersionUID = 1L;

    public ResolutionWindow(HashMap<Jugador, Integer> players, JugadorIA crupier) throws InterruptedException{
        super("Resolucion de la ronda");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(0, 1));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.add(panel);

        JTextArea fullResult = new JTextArea();
        fullResult.setEditable(false);
        fullResult.setLineWrap(false);
        fullResult.setFont(new Font("Arial", Font.PLAIN, 16));
        fullResult.setOpaque(false);

        panel.add(fullResult);

        StringBuilder sb = new StringBuilder();
        sb.append("------- RESOLUCION DE LA RONDA -------\n");
        sb.append(">> El crupier tiene " + crupier.getMano().getPuntuacion() + " puntos\n\n");

        for (Jugador jugador : players.keySet()) {
            sb.append(jugador.getNombre() + " tiene " + jugador.getMano().getPuntuacion() + " puntos\n");
            sb.append("Apostó " + jugador.getApuesta() + " Euros\n");
            if (players.get(jugador) == 0) // El jugador pierde
                sb.append("Ha perdido " + jugador.getApuesta() + " Euros!");
            
            if (players.get(jugador) == 1) // El jugador gana
                sb.append("Ha ganado " + jugador.getApuesta() + " Euros!");

            if (players.get(jugador) == 2) // El jugador gana por blackjack
                sb.append("Ha ganado " + jugador.getApuesta() * 1.5 + " Euros!");

            if (players.get(jugador) == 3) // El jugador empata
                sb.append("Ha empatado. No gana ni pierde dinero!");

            sb.append("\n\n");
            fullResult.setText(sb.toString());
            this.pack();
            this.setVisible(true);
        }
        
        TimeUnit.SECONDS.sleep(players.size() * 3);
    }
}
