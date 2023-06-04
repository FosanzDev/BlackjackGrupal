package com.nolete19.BlackJack;

public class Juego implements Runnable {
    // Atributos
    private Mesa mesa;
    //Constructor
    public Juego(Mesa mesa) {
        this.mesa = mesa;
    }

    /**
     * Este método representa el flujo del juego, llamando a los métodos correspondientes
     * para que se cumpla con el orden indicado.
     */
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

        mesa.getIoInterface().print("El juego ha terminado. No hay mas jugadores humanos", true);
    }
}
