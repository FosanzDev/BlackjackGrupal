package com.nolete19.BlackJack.Jugadores;

import java.util.Scanner;

public class JugadorHumano extends Jugador {
    // Constructor
    public JugadorHumano() {
        super();
    }

    // Implementación específica para tomar la decisión opcional del jugador humano
    @Override
    public String tomarDecisionOpcional() {
        // Aquí puedes implementar la lógica para tomar una decisión opcional para el jugador humano
        // Por ejemplo, mostrar opciones en pantalla y esperar su entrada del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese 's' para seguir jugando, o 'p' para plantarse");
        String decision = scanner.nextLine();
        scanner.close();
        return decision;
    }
}