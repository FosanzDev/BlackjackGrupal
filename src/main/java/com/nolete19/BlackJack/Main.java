package com.nolete19.BlackJack;

import java.util.Scanner;

import com.nolete19.BlackJack.Configuracion.Configuracion;
import com.nolete19.BlackJack.Estadisticas.Estadisticas;
import com.nolete19.BlackJack.Exceptions.NotANumber;
import com.nolete19.BlackJack.Exceptions.NotInRange;
import com.nolete19.BlackJack.Jugadores.JugadorHumano;
import com.nolete19.BlackJack.Jugadores.JugadorIA;
import com.nolete19.BlackJack.Utils.IO;

public class Main {

    public static void main(String[] args) {
        /*String archivoConfiguracion = "configuracion.txt";
        String archivoEstadisticas = "estadisticas.txt";*/
        Configuracion config = new Configuracion();
        Estadisticas estadisticas = new Estadisticas();
        IO ioInterface = new IO(new Scanner(System.in));

        boolean continues = true;

        while (continues){
            ioInterface.print(Output.getMainMenu(), true);
            int option = 0;
            try {
                option = ioInterface.readLimitedInt("Opcion: ", 1, 4, false);
            } catch (NotANumber nan){
                ioInterface.print("No has introducido un numero", true);
            } catch (NotInRange nir){
                ioInterface.print("No has introducido un numero en el rango", true);
            }

            switch (option){
                case 1:
                    // Empezar partida
                    // Creacion de la mesa
                    Mesa mesa = new Mesa(ioInterface, config, estadisticas);

                    //Creacion de los jugadores IA
                    for (int i = 0; i < config.numeroJugadoresIA; i++){
                        mesa.addJugador(new JugadorIA("Jug. IA " + i, config.saldoInicialJugadoresIA));
                    }

                    //Creacion de los jugadores humanos
                    for (int i = 0; i < config.numeroJugadoresHumanos; i++){
                        String nombre = ioInterface.readString("Nombre del jugador " + i + ": ", false);
                        mesa.addJugador(new JugadorHumano(nombre, config.saldoInicialJugadoresHumanos));
                    }

                    // Creacion del juego
                    Juego juego = new Juego(mesa);
                    juego.run();
                    break;

                case 2:
                    estadisticas.mostrarEstadisticas();
                    break;

                case 3:
                    //config.enterConfigMenu(ioInterface);
                    break;

                case 4:
                    continues = false;
                    break;
            }

            
        }
    }
}
