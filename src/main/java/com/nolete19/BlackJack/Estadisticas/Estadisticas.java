package com.nolete19.BlackJack.Estadisticas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class Estadisticas {

    private static String DEFAULT_FILE_PATH = "estadisticas.json";

    //Definiciï¿½n de las variables
    private int victoriasCpu = 0;
    private int victoriasJugador = 0;
    private int blackjacksJugador = 0;
    private int partidasJugadas = 0;
    private transient String filePath = DEFAULT_FILE_PATH;

    /**
     * Este mï¿½todo se encarga de incrementar las victorias, es decir
     * las manos que ha ganado la cpu.
     */
    public void incrementarVictoriasCpu() {
        victoriasCpu++;
        guardarEstadisticas();
    }
    /**
     * Este mï¿½todo se encarga de incrementar las victorias, es decir
     * las manos que ha ganado el jugador.
     */
    public void incrementVictoriasJugador() {
        victoriasJugador++;
        guardarEstadisticas();
    }

    /**
     * Este mï¿½todo se encarga de incrementar las partidas que se han jugado.
     */
    public void incrementarPartidasJugadas() {
        partidasJugadas++;
        guardarEstadisticas();
    }

    /**
     * Este mï¿½todo se encarga de incrementar las manos que ha ganado el jugador con blackJack,
     * es decir con dos cartas obtener 21.
     */
    public void incrementarBlackjacksJugador() {
        blackjacksJugador++;
        guardarEstadisticas();
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

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    /**
     * Mï¿½todo que muestra todas las estadisticas de los dos
     * jugadores al completo, para poder visualizar la diferencia.
     */
    public String getStringEstadisticas() {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================\n");
        sb.append("                ESTADISTICAS                \n");
        sb.append("============================================\n");
        sb.append("Manos ganadas por la CPU: ").append(victoriasCpu).append("\n");
        sb.append("Manos ganadas por el Jugador: ").append(victoriasJugador).append("\n");
        sb.append("Blackjacks obtenidos por el Jugador: ").append(blackjacksJugador).append("\n");
        sb.append("Partidas jugadas: ").append(partidasJugadas).append("\n");
        sb.append("============================================\n");
        return sb.toString();
    }

    /**
     * constuctor
     */
    public Estadisticas(String archivoEstadisticas) {
        this.filePath = archivoEstadisticas;
        cargarEstadisticas();
    }

    /**Constructor preferido para las estadisticas
     * @param useDefault si es true se usan las estadisticas por defecto, si es false se cargan las estadisticas del archivo
     * 
     */
    public Estadisticas(boolean useDefault){
        if(!useDefault){
            cargarEstadisticas();
            guardarEstadisticas();
        } else {
            guardarEstadisticas();
        }
    }

    /**
     * mï¿½todo para leer el archivo de estadï¿½sticas y
     * asignar los valores correspondientes a las variables de la clase
     * @param archivoEstadisticas
     * @throws IOException
     */
    private void cargarEstadisticas(){
        // Read the serialized object from a file
        Gson gson = new Gson();
        Estadisticas estadisticas;
        try {
            estadisticas = gson.fromJson(new FileReader(filePath), Estadisticas.class);
        } catch (IOException e) {
            // Imposible cargar el archivo. Se crea uno nuevo con las estadÃ­sticas iniciales
            // guardarEstadisticas se encarga de crear el archivo
            guardarEstadisticas();
            return;
        }
        

        // Copy the values from the loaded object to this object
        this.victoriasCpu = estadisticas.victoriasCpu;
        this.victoriasJugador = estadisticas.victoriasJugador;
        this.blackjacksJugador = estadisticas.blackjacksJugador;
        this.partidasJugadas = estadisticas.partidasJugadas;
    }

    public void guardarEstadisticas() {
        // Serializar el objeto
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(this, writer);
        } catch (IOException e) {
            //No se ha podido guardar el archivo de estadÃ­sticas
            //Se crea un archivo nuevo con las estadÃ­sticas iniciales en el path por defecto
            filePath = DEFAULT_FILE_PATH;
            guardarEstadisticas();
            //Este return es para evitar recursividad infinita
            return;
        }
    }

    public void resetStats(){
        this.victoriasCpu = 0;
        this.victoriasJugador = 0;
        this.blackjacksJugador = 0;
        this.partidasJugadas = 0;
        guardarEstadisticas();
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

