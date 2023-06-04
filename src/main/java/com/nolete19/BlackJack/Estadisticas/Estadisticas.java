package com.nolete19.BlackJack.Estadisticas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Estadisticas {

    //Definición de las variables
    private int victoriasCpu;
    private int victoriasJugador;
    private int blackjacksJugador;

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

    /**
     * Este método se encarga de incrementar las manos que ha ganado el jugador con blackJack,
     * es decir con dos cartas obtener 21.
     */
    public void incrementarBlackjacksJugador() {
        blackjacksJugador++;
    }
    //Getters
    public int getVictoriasCpu() {
        return victoriasCpu;
    }

    public int getVictoriasJugador() {
        return victoriasJugador;
    }

    public int getBlackjacksJugador() {
        return blackjacksJugador;
    }
    /**
     * Método que muestra todas las estadisticas de los dos
     * jugadores al completo, para poder visualizar la diferencia.
     */

    public void mostrarEstadisticas() {
        System.out.println("============================================");
        System.out.println("                ESTADISTICAS                ");
        System.out.println("============================================");
        System.out.println("Manos ganadas por la CPU: " + victoriasCpu);
        System.out.println("Manos ganadas por el Jugador: " + victoriasJugador);
        System.out.println("Blackjacks obtenidos por el Jugador: " + blackjacksJugador);
        System.out.println("Partidas jugadas: " + (victoriasCpu + victoriasJugador));
        System.out.println("============================================");
    }

    /**
     * constuctor
     */
    public Estadisticas(String archivoEstadisticas) throws IOException {
        cargarEstadisticas(archivoEstadisticas);
    }

    /**
     * método para leer el archivo de estadísticas y
     * asignar los valores correspondientes a las variables de la clase
     * @param archivoEstadisticas
     * @throws IOException
     */
    private void cargarEstadisticas(String archivoEstadisticas) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(archivoEstadisticas));
        String contenido = new String(bytes);
        String[] lineas = contenido.split("\n");

        for (String linea : lineas) {
            String[] partes = linea.split("=");
            String nombre = partes[0].trim();
            String valor = partes[1].trim();

            switch (nombre) {
                case "victoriasCpu":
                    victoriasCpu = Integer.parseInt(valor);
                    break;
                case "victoriasJugador":
                    victoriasJugador = Integer.parseInt(valor);
                    break;
                default:
                    // Opcional: Manejar casos de estadísticas no reconocidas
                    break;
            }
        }
    }
    /**
     * Método para guardar las estadísticas en un archivo.
     *
     * @param archivoEstadisticas El nombre del archivo de estadísticas.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarEstadisticas(String archivoEstadisticas) throws IOException {
        StringBuilder contenido = new StringBuilder();

        contenido.append("victoriasCpu=").append(victoriasCpu).append("\n");
        contenido.append("victoriasJugador=").append(victoriasJugador).append("\n");
        contenido.append("blackjacksJugador=").append(blackjacksJugador).append("\n");

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(archivoEstadisticas));
            writer.write(contenido.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}

