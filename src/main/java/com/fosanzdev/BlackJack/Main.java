package com.fosanzdev.BlackJack;

import java.util.Scanner;

import com.fosanzdev.BlackJack.Configuracion.Configuracion;
import com.fosanzdev.BlackJack.Estadisticas.Estadisticas;
import com.fosanzdev.BlackJack.Jugadores.JugadorHumano;
import com.fosanzdev.BlackJack.Jugadores.JugadorIA;
import com.fosanzdev.BlackJack.Utils.IO;

public class Main {

    public static void main(String[] args) {
        Configuracion config = new Configuracion("config.json");
        Estadisticas stats = new Estadisticas("estadisticas.json");
        IO ioInterface = new IO(new Scanner(System.in));

        boolean continues = true;

        while (continues) {
            ioInterface.print(Output.getMainMenu(), true);
            int option = 0;
            option = ioInterface.readLimitedInt("Opcion: ", 1, 4, false);
            switch (option) {
                case 1:
                    // Empezar partida
                    // Creacion de la mesa
                    Mesa mesa = new Mesa(ioInterface, config, stats);

                    // Creacion de los jugadores IA
                    for (int i = 0; i < config.numeroJugadoresIA; i++) {
                        mesa.addJugador(new JugadorIA("Jug. IA " + i, config.saldoInicialJugadoresIA));
                    }

                    // Creacion de los jugadores humanos
                    for (int i = 0; i < config.numeroJugadoresHumanos; i++) {
                        String nombre = ioInterface.readString("Nombre del jugador " + i + ": ", false);
                        mesa.addJugador(new JugadorHumano(nombre, config.saldoInicialJugadoresHumanos));
                    }

                    // Creacion del juego
                    stats.incrementarPartidasJugadas();
                    Juego juego = new Juego(mesa);
                    juego.run();
                    break;

                case 2:
                    ioInterface.print(stats.getStringEstadisticas(), true);
                    ioInterface.waitEnter();
                    break;

                case 3:
                    enterConfigSubmenu(config.settingsAvailable(), ioInterface, config, stats);
                    break;

                case 4:
                    ioInterface.print("¡Hasta luego!", true);
                    continues = false;
                    break;
            }

        }
    }

    private static void enterConfigSubmenu(String[] menu, IO ioInterface, Configuracion config, Estadisticas stats) {
        String fullMenu = Menu.menu("CONFIGURACION", menu);
        int option = 0;
        boolean continues = true;

        while (continues) {
            ioInterface.print(fullMenu, true);
            option = ioInterface.readLimitedInt("Opcion: ", 1, menu.length, false);

            switch (option) {
                case 1: // Cambiar numero de jugadores IA
                    int newNumber = ioInterface.readLimitedInt("Nuevo numero de jugadores IA (max. 10): ", 0, 10, false);
                    config.setNumeroJugadoresIA(newNumber);
                    break;

                case 2: // Cambiar numero de jugadores humanos
                    newNumber = ioInterface.readLimitedInt("Nuevo numero de jugadores humanos (max. 10): ", 1, 10, false);
                    config.setNumeroJugadoresHumanos(newNumber);
                    break;

                case 3: // Cambiar la apuesta minima
                    newNumber = ioInterface.readLimitedInt("Nueva apuesta minima (0 - " + config.apuestaMaxima + "): ", 0, config.apuestaMaxima, false);
                    config.setApuestaMinima(newNumber);
                    break;

                case 4: // Cambiar la apuesta maxima
                    newNumber = ioInterface.readLimitedInt("Nueva apuesta máxima (" + config.apuestaMinima + " o superior): ", config.apuestaMinima, Integer.MAX_VALUE, false);
                    config.setApuestaMaxima(newNumber);
                    break;

                case 5: // Cambiar el saldo inicial de los jugadores IA
                    newNumber = ioInterface.readLimitedInt("Saldo inicial de las IAs: ", 0, Integer.MAX_VALUE, false);
                    config.setSaldoInicialJugadoresIA(newNumber);
                    break;

                case 6: // Cambiar saldo inicial de los jugadores humanos
                    newNumber = ioInterface.readLimitedInt("Saldo inicial de los jugadores humanos: ", 0, Integer.MAX_VALUE, false);
                    config.setSaldoInicialJugadoresHumanos(newNumber);
                    break;

                case 7: // Cambiar los milisegundos de espera para la IA
                    newNumber = ioInterface.readLimitedInt("Milisegundos de espera para la IA (max. 10segs): ", 0, 10000, false);
                    config.setMilisegundosEspera(newNumber);
                    break;

                case 8: // Cambiar el multiplicador de un blackjack
                    double dNewNumber = ioInterface.readLimitedDouble("Multiplicador de un blackjack (0 - 10): ", 0, 10, false);
                    config.setMultiplicadorBlackjack(dNewNumber);
                    break;

                case 9: // Cambiar el multiplicador de una jugada normal
                    dNewNumber = ioInterface.readLimitedDouble("Multiplicador de una jugada normal (0 - 10): ", 0, 10, false);
                    config.setMultiplicadorGanadorBasico(dNewNumber);
                    break;

                case 10: // Importa una nueva configuracion
                    String path = ioInterface.readString("Introduce la ruta del archivo de configuracion: ", false);
                    if (config.changeConfig(path)) {
                        ioInterface.print("Configuracion importada correctamente", true);
                    } else {
                        ioInterface.print("Error al importar la configuracion", true);
                    }
                    break;

                case 11: // Resetea la confiuracion por defecto
                    config.resetConfig();
                    ioInterface.print("Configuracion por defecto cargada", true);
                    break;

                case 12: // Resetea las estadisticas
                    stats.resetStats();
                    ioInterface.print("Estadisticas reseteadas", true);
                    break;

                case 13: // Volver al menu principal
                    ioInterface.print("Volviendo al menu principal...", true);
                    continues = false;
                    break;
            }
        }
    }
}
