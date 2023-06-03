package com.nolete19.BlackJack;

import com.nolete19.BlackJack.Utils.IO;

public class Juego implements Runnable {

    private Mesa mesa;
    private IO ioInterface;

    public Juego(Mesa mesa) {
        this.mesa = mesa;
        this.ioInterface = mesa.getIoInterface();
    }

    @Override
    public void run() {
        try {
            while (mesa.areThereHumansLeft()) {
                // Fase de reparto
                mesa.repartirCartas();

                // Fase de apuestas
                mesa.apuestas();

                // Fase de juego
                mesa.jugarRonda();

                ioInterface.print("Fin de la ronda\n", true);

                // Fase de crupier
                mesa.jugarCrupier();

                // Fase de resolución
                mesa.resolucion();
            }
        } catch (InterruptedException e) {
            System.out.println("Ha ocurrido un error inesperado.");
        }
    }
}
