package com.nolete19.BlackJack.Configuracion;

public class Configuracion {
    public int numeroJugadoresIA = 3;
    public int numeroJugadoresHumanos = 1;
    public int apuestaMinima = 10;
    public int apuestaMaxima = 100;
    public int saldoInicialJugadoresIA = 1000;
    public int saldoInicialJugadoresHumanos = 10;
    public int milisegundosEspera = 1000;
    public double multiplicadorBlackjack = 1.5;
    public double multiplicadorGanadorBasico = 1;

    public void setNumeroJugadoresIA(int numeroJugadoresIA) {
        this.numeroJugadoresIA = numeroJugadoresIA;
    }

    public void setNumeroJugadoresHumanos(int numeroJugadoresHumanos) {
        this.numeroJugadoresHumanos = numeroJugadoresHumanos;
    }

    public void setApuestaMinima(int apuestaMinima) {
        this.apuestaMinima = apuestaMinima;
    }

    public void setApuestaMaxima(int apuestaMaxima) {
        this.apuestaMaxima = apuestaMaxima;
    }

    public void setSaldoInicialJugadoresIA(int saldoInicialJugadoresIA) {
        this.saldoInicialJugadoresIA = saldoInicialJugadoresIA;
    }

    public void setSaldoInicialJugadoresHumanos(int saldoInicialJugadoresHumanos) {
        this.saldoInicialJugadoresHumanos = saldoInicialJugadoresHumanos;
    }

    public void setMilisegundosEspera(int milisegundosEspera) {
        this.milisegundosEspera = milisegundosEspera;
    }

    public void setMultiplicadorBlackjack(double multiplicadorBlackjack) {
        this.multiplicadorBlackjack = multiplicadorBlackjack;
    }

    public void setMultiplicadorGanadorBasico(double multiplicadorGanadorBasico) {
        this.multiplicadorGanadorBasico = multiplicadorGanadorBasico;
    }
}

