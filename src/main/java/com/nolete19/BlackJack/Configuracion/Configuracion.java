package com.nolete19.BlackJack.Configuracion;

import java.util.Scanner;

public class Configuracion {
    public int numeroJugadores;
    public double apuestaBase;
    public double apuestaMaxima;
    public double saldoInicialJugadores;
    public double saldoInicialBanca;
    public int milisegundosEspera;
    public int multiplicadorBlackjack;
    public int multiplicadorGanadorBasico;
    public static Scanner scanner = new Scanner(System.in);

    //Configuraci�n default de la mesa de los jugadores
    public Configuracion() {
        //Numero de jugadores por defecto incluyendo usuario
        numeroJugadores = 5 ;
        //Apuesta base
        apuestaBase = 10.0;
        //Apuesta m�xima
        apuestaMaxima = 10.0;
        //Saldo inicial
        saldoInicialJugadores = 100.0;
        saldoInicialBanca = 200.0;

        //Tiempo de espera entre turnos
        milisegundosEspera = 1000;

        //Multiplicador de blackjack
        multiplicadorBlackjack = 2;
        multiplicadorGanadorBasico = 1;
    }
    public void cambiarNumeroJugadores() {
        System.out.println("Introduce el numero de jugadores:");
        numeroJugadores = scanner.nextInt();
        scanner.nextLine();
    }

    public void cambiarApuestaBase() {
        System.out.println("Introduce el valor de la apuesta base:");
        apuestaBase = scanner.nextInt();
        scanner.nextLine();
    }

    public void cambiarApuestaMaxima() {
        System.out.println("Introduce el valor de la apuesta m�xima:");
        apuestaMaxima = scanner.nextInt();
        scanner.nextLine();
    }

    public void cambiarSaldoInicialJugadores() {
        System.out.println("Introduce el saldo inicial de los jugadores:");
        saldoInicialJugadores = scanner.nextInt();
        scanner.nextLine();
    }

    public void cambiarSaldoInicialBanca() {
        System.out.println("Introduce el saldo inicial de la banca:");
        saldoInicialBanca= scanner.nextInt();
        scanner.nextLine();
    }

    // Getters y setters
    public int getNumeroJugadores() {
        return numeroJugadores;
    }
    public double getApuestaBase() {
        return apuestaBase;
    }

    public double getApuestaMaxima() {
        return apuestaMaxima;
    }

    public double getSaldoInicialJugadores() {
        return saldoInicialJugadores;
    }

    public double getSaldoInicialBanca() {
        return saldoInicialBanca;
    }
}
