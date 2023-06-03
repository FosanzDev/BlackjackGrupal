package com.nolete19.BlackJack.Estadisticas;

public class Estadisticas {

    //Definición de las variables
    private int victoriasCpu;
    private int victoriasJugador;

    /**
     * Este método se encarga de incrementar las victorias, es decir
     * las manos que ha ganado la cpu.
     */
    public void incrementarVictoriasCpu() {
        victoriasCpu++;
    }
    /**
     * Este método se encarga de incrementar las victorias, es decir
     * las manos que ha ganado el jugador.
     */
    public void incrementVictoriasJugador() {
        victoriasJugador++;
    }

    //Getters
    public int getVictoriasCpu() {
        return victoriasCpu;
    }

    public int getVictoriasJugador() {
        return victoriasJugador;
    }

    /**
     * Método que muestra todas las estadisticas de los dos
     * jugadores al completo, para poder visualizar la diferencia.
     */

    public void mostrarEstadisticas() {
        System.out.println("????????????????????????????????????????????");
        System.out.println("?               ESTADÍSTICAS               ?");
        System.out.println("????????????????????????????????????????????");
        System.out.println("Manos ganadas por la CPU: " + victoriasCpu);
        System.out.println("Manos ganadas por el Jugador: " + victoriasJugador);
        System.out.println("????????????????????????????????????????????");
    }

}

