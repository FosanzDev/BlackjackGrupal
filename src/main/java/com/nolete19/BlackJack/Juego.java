package com.nolete19.BlackJack;

public class Juego implements Runnable {

    private Mesa mesa;

    public Juego(Mesa mesa) {
        this.mesa = mesa;
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
