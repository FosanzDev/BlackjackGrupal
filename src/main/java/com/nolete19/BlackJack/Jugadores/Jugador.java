package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Jugador {
    private List<Carta> mano;
    private int puntaje;

    //Constructor
    public Jugador() {
        this.mano = new ArrayList<>();
        this.puntaje = 0;
    }

    // para calcular el puntaje total de las cartas en la mano del jugador
    public void tomarCarta(Carta carta) {
        mano.add(carta);
    }

    //Método para calcular el puntaje total de las cartas en la mano del jugador
    public int calcularPuntaje() {
        puntaje = 0;
        for (Carta carta : mano) {
            puntaje += carta.getValor().getValor();
            // Se suman los valores de las cartas
            // de la mano del jugador y se guardan en la variable puntaje
        }
        return puntaje;
        // Se devuelve el puntaje total de las cartas de la mano del jugador
    }

    //Método para mostrar las cartas en la mano del jugador
    public void mostrarMano() {
        System.out.println("La mano del jugador es:");
        for (Carta carta : mano) {
            System.out.println(carta);
            //Se muestra cada una de las cartas de la mano del jugador
        }
    }

    //Método para tomar una decisión opcional
    public String tomarDecisionOpcional() {
        //aquí podrías implementar la lógica para tomar una decisión opcional
        //En este ejemplo, no hay una implementación específica, solo se devuelve una cadena
        return "Decisión tomada";
    }
}



