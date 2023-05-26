package com.nolete19.BlackJack.Jugadores;

import com.nolete19.BlackJack.Carta;

import java.util.List;

public class Opciones {
    private Jugador jugador;

    public Opciones(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean debeDoblar() {
        List<Carta> mano = jugador.getMano();
        if (mano.size() == 2) {
            int puntaje = jugador.calcularPuntaje();

            // La lógica para decidir si doblar depende de las reglas del juego y la estrategia de la IA
            // Aquí se muestra un ejemplo básico: doblar si el puntaje está en un rango específico
            return puntaje >= 9 && puntaje <= 11;
        }

        return false;
    }

    public boolean debePlantarse() {
        int puntaje = jugador.calcularPuntaje();

        // La lógica para decidir si plantarse depende de las reglas del juego y la estrategia de la IA
        // Aquí se muestra un ejemplo básico: plantarse si el puntaje es igual o mayor a 17
        return puntaje >= 17;
    }

    public boolean debeDividir() {
        List<Carta> mano = jugador.getMano();
        if (mano.size() == 2) {
            Carta carta1 = mano.get(0);
            Carta carta2 = mano.get(1);

            // La lógica para decidir si dividir depende de las reglas del juego y la estrategia de la IA
            // Aquí se muestra un ejemplo básico: dividir si las dos cartas tienen el mismo valor
            return carta1.getValor().equals(carta2.getValor());
        }

        return false;
    }
}

