package com.fosanzdev.BlackJack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.fosanzdev.BlackJack.Cartas.Baraja;
import com.fosanzdev.BlackJack.Configuracion.Configuracion;
import com.fosanzdev.BlackJack.Estadisticas.Estadisticas;
import com.fosanzdev.BlackJack.Jugadores.Jugador;
import com.fosanzdev.BlackJack.Jugadores.JugadorHumano;
import com.fosanzdev.BlackJack.Jugadores.JugadorIA;
import com.fosanzdev.BlackJack.Jugadores.Mano;
import com.fosanzdev.BlackJack.UI.GameMoment;
import com.fosanzdev.BlackJack.UI.MainFrame;
import com.fosanzdev.BlackJack.Utils.UIIO;

public class Mesa {

    //Atributos
    private Baraja baraja;
    private final ArrayList<Jugador> jugadores;

    private JugadorIA crupier;
    private int apuestaMinima;
    private int apuestaMaxima;
    private UIIO ioInterface;
    private Configuracion configuracion;
    private Estadisticas estadisticas;
    private MainFrame mainFrame;

    //Constructor
    public Mesa(UIIO ioInterface, Configuracion configuracion, Estadisticas estadisticas, MainFrame mainFrame) {
        this.baraja = new Baraja();
        this.apuestaMinima = configuracion.apuestaMinima;
        this.apuestaMaxima = configuracion.apuestaMaxima;
        this.ioInterface = ioInterface;
        this.configuracion = configuracion;
        this.estadisticas = estadisticas;
        this.mainFrame = mainFrame;
        this.jugadores = new ArrayList<>();
        this.crupier = new JugadorIA("Crupier", true);
    }

    //Getters
    public int getApuestaMinima() {
        return apuestaMinima;
    }

    public int getApuestaMaxima() {
        return apuestaMaxima;
    }

    public Mano getManoCrupier() {
        return crupier.getVisibleHand();
    }

    /**
     * Este método se encarga de agregar un jugador a la mesa que posteriormente es
     * guardado en un array que representa todos los jugadores de la mesa.
     * @param jugador Recibe un parametro de tipo Jugador.
     */
    public void addJugador(Jugador jugador) {
        jugadores.add(jugador);
        jugador.setMesa(this);
    }

    /**
     * Este método se encarga de repartir las dos cartas necesarias que necesita cada
     * jugador para empezar la ronda.
     */
    public void repartirCartas() {
        for (int i = 0; i < 2; i++) {
            for (Jugador jugador : jugadores) {
                repartirCarta(jugador);
            }
            repartirCarta(crupier);
        }
    }

    /**
     * Este método se encarga de verificar si hay jugadores humanos en la partida
     * @return Devuelve un booleano representando si hay o no hay jugadores humanos.
     */
    public boolean areThereHumansLeft() {
        for (Jugador jugador : jugadores) {
            if (jugador instanceof JugadorHumano) {
                return true;
            }
        }
        return false;
    }

    /**
     * Este método se encarga de llamar a las apuestas que desee hacer cada jugador segun
     * convenga, ya sea jugador humano o controlado por la IA.
     */
    public void apuestas() {
        for (Jugador jugador : jugadores) {
            jugador.apuesta();
        }
    }

    public void jugarRonda() throws InterruptedException {
        for (Jugador jugador : jugadores) {
            // Obtenemos la mano del jugador
            Mano mano = jugador.getMano();
            boolean isIA = jugador instanceof JugadorIA;

            GameMoment gameMoment = new GameMoment(jugador, crupier, false, "Jugando");
            mainFrame.setGameMoment(gameMoment);

            mainFrame.bigLog("Turno de " + jugador.getNombre() + ": ");
            TimeUnit.SECONDS.sleep(3);
            mainFrame.bigLog("");

            if (isIA) {
                ioInterface.print("*Es una IA", true);
                mainFrame.bigLog("Es una IA");
                Thread.sleep(configuracion.milisegundosEspera);
            }

            boolean inBounds = true;

            // Si el jugador tiene blackjack, no puede pedir más cartas
            if (mano.getPuntuacion() == 21) {
                mainFrame.bigLog("BlackJack! de " + jugador.getNombre());
                TimeUnit.SECONDS.sleep(3);
                inBounds = false;
                mano.setBlackJack(true);
            }

            while (inBounds) {

                // Obtenemos la opción del jugador
                switch (jugador.opcion()) {

                    // Si el jugador pide carta, se la damos
                    case PEDIR_CARTA:
                        if (isIA) {
                            mainFrame.bigLog("La IA pide una carta");
                            TimeUnit.MILLISECONDS.sleep(configuracion.milisegundosEspera);
                        }
                        repartirCarta(jugador);

<<<<<<< HEAD:src/main/java/com/fosanzdev/BlackJack/Mesa.java
                        // Si el jugador tiene 21 puntos, no puede pedir más cartas
                        if (mano.getPuntuacion() == 21){
=======
                        // Si el jugador se pasa o tiene 21, no puede pedir más cartas
                        if (mano.getPuntuacion() >= 21) {
                            ioInterface.print("Te has pasado!", true);
>>>>>>> master:src/main/java/com/nolete19/BlackJack/Mesa.java
                            inBounds = false;
                            mainFrame.bigLog("El jugador ha alcanzado la puntuacion máxima!");
                            TimeUnit.SECONDS.sleep(3);
                        }
                        // Si el jugador se pasa de 21 puntos, no puede pedir más cartas
                        else if (mano.getPuntuacion() > 21){
                            inBounds = false;
                            mainFrame.bigLog("El jugador se ha pasado de 21 puntos!");
                            TimeUnit.SECONDS.sleep(3);
                        }
                        break;
                    case PLANTARSE:
                        if (isIA) {
                            mainFrame.bigLog("La IA se planta");
                            TimeUnit.MILLISECONDS.sleep(configuracion.milisegundosEspera);
                        }
                        mainFrame.bigLog("El jugador se ha plantado con " + mano.getPuntuacion() + " puntos");
                        TimeUnit.SECONDS.sleep(3);
                        inBounds = false;
                        break;
                }
            }
            mainFrame.bigLog("");
            mainFrame.setGameMoment(GameMoment.BETTING);
        }
    }

    public void resolucion() {
        int puntosCrupier = crupier.getMano().getPuntuacion();
        ioInterface.print("-------- RESOLUCIÓN: Crupier -----------", true);
        ioInterface.print("El crupier tiene " + puntosCrupier + " puntos", true);

        for (Jugador jugador : jugadores) {
            ioInterface.print("-------- RESOLUCIÓN: " + jugador.getNombre() + " -----------", true);
            int puntosJugador = jugador.getMano().getPuntuacion();
            // CASO 1: El jugador tiene blackjack
            if (jugador.getMano().isBlackJack()) {
                ioInterface.print("El jugador tenía blackjack!", false);

                // CASO 1.1: El crupier no tiene blackjack (Se le suma: apuesta * multiplicadorBlackjack)
                if (!crupier.getMano().isBlackJack()) {
                    ioInterface.print(", gana a lo grande!", true);
                    int dineroGanado = (int) (jugador.getApuesta() * configuracion.multiplicadorBlackjack);
                    ioInterface.print("Has ganado " + dineroGanado + "E", true);
                    jugador.addDinero(dineroGanado);
                    if (jugador instanceof JugadorHumano) {
                        estadisticas.incrementVictoriasJugador();
                    }
                }

                // CASO 1.2: El crupier tiene blackjack (No se le resta dinero al jugador)
                else {
                    ioInterface.print(", Pero el crupier también!", true);
                    ioInterface.print("No ganas ni pierdes dinero", true);
                }
            }

            // CASO 2: El jugador no tiene blackjack 
            else {

                // CASO 2.1: El jugador se ha pasado de 21 (Se le resta: apuesta)
                if (puntosJugador > 21) {
                    ioInterface.print("El jugador se ha pasado de 21!", true);
                    ioInterface.print("Has perdido " + jugador.getApuesta() + "E", true);
                    jugador.addDinero(-jugador.getApuesta());
                }

                // CASO 2.2 El crupier se ha pasado de 21 (Se le suma: apuesta * multiplicadorGanadorBasico)
                else if (puntosCrupier > 21) {
                    ioInterface.print("El crupier se ha pasado de 21!", true);
                    ioInterface.print("Has ganado " + jugador.getApuesta() * configuracion.multiplicadorGanadorBasico
                            + "E", true);
                    jugador.addDinero((int) (jugador.getApuesta() * configuracion.multiplicadorGanadorBasico));
                    if (jugador instanceof JugadorHumano) {
                        estadisticas.incrementVictoriasJugador();
                    }
                }

                // CASO 2.3: El crupier tiene menos puntos que el jugador (Se le suma: apuesta *
                // multiplicadorGanadorBasico)
                else if (puntosCrupier < puntosJugador) {
                    ioInterface.print("El jugador tenía más puntos que el crupier!", true);
                    int dineroGanado = (int) (jugador.getApuesta() * configuracion.multiplicadorGanadorBasico);
                    ioInterface.print("Has ganado " + dineroGanado + "E", true);
                    jugador.addDinero(dineroGanado);
                }

                // CASO 2.4: El crupier tiene más puntos o los mismos que el jugador (Se le
                // resta: apuesta)
                else if (puntosCrupier >= puntosJugador && puntosCrupier <= 21) {
                    ioInterface.print("El jugador tenía menos puntos que el crupier!", true);
                    ioInterface.print("Has perdido " + jugador.getApuesta() + "E", true);
                    jugador.addDinero(-jugador.getApuesta());
                }
            }
            // Se resetea la mano del jugador
            jugador.reset();
            crupier.reset();
            baraja = new Baraja();
        }

        //Para evitar el ConcurrentModificationException creamos una lista auxiliar
        // Comprobamos si algun jugador no cumple los requisitos para seguir jugando
        ArrayList<Jugador> jugadoresToRemove = new ArrayList<>();
        for (Jugador jugador : jugadores) {
            if (jugador.getSaldo() < configuracion.apuestaMinima) {
                ioInterface.print(
                        "El jugador " + jugador.getNombre() + " no tiene dinero suficiente para seguir jugando", true);
                jugadoresToRemove.add(jugador);
            }
        }
        jugadores.removeAll(jugadoresToRemove);
    }

    /**
     * Este método se encarga de repartir cartas al crupier en caso que la puntuacion
     * sea menor de 17.
     */
    public void jugarCrupier() throws InterruptedException{
        mainFrame.bigLog("El crupier tiene " + crupier.getMano().getPuntuacion() + " puntos");
        GameMoment gameMoment = new GameMoment(null, crupier, true, "Crupier");
        mainFrame.setGameMoment(gameMoment);
        boolean inBounds = true;
        while (inBounds) {
            mainFrame.bigLog("El crupier tiene " + crupier.getMano().getPuntuacion() + " puntos");
            if (crupier.getMano().getPuntuacion() < 17) {
                mainFrame.bigLog("El crupier pide carta");
                TimeUnit.MILLISECONDS.sleep(configuracion.milisegundosEspera);
                repartirCarta(crupier);
            } else {
                if (crupier.getMano().getPuntuacion() > 21) {
                    mainFrame.bigLog("El crupier se ha pasado de 21");
                } else {
                    mainFrame.bigLog("El crupier se planta");
                }
                TimeUnit.MILLISECONDS.sleep(configuracion.milisegundosEspera);
                mainFrame.bigLog("El crupier tiene " + crupier.getMano().getPuntuacion() + " puntos");
                TimeUnit.SECONDS.sleep(3);
                inBounds = false;
            }
        }
        mainFrame.bigLog("");
        mainFrame.setGameMoment(GameMoment.BETTING);
    }

    /**
     * Este método se encarga de repartir una carta al jugador que desee.
     * @param jugador Recibe como parametor un Jugador para asignar dicha carta a su mano.
     */
    public void repartirCarta(Jugador jugador) {
        jugador.addCarta(baraja.sacarCartaPila());
    }
    // Este método se utiliza para obtener la interfaz de entrada y salida
    public UIIO getIoInterface() {
        return ioInterface;
    }
    //Getters
    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
}
