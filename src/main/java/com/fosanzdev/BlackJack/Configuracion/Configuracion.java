package com.fosanzdev.BlackJack.Configuracion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;


public class Configuracion {

    public static int DEFAULT_MAX_IA_PLAYERS = 3;
    public static int DEFAULT_MAX_HUMAN_PLAYERS = 1;
    public static int DEFAULT_MIN_BET = 10;
    public static int DEFAULT_MAX_BET = 100;
    public static int DEFAULT_IA_INITIAL_BALANCE = 1000;
    public static int DEFAULT_HUMAN_INITIAL_BALANCE = 1000;
    public static int DEFAULT_WAIT_TIME = 1000;
    public static double DEFAULT_BLACKJACK_MULTIPLIER = 1.5;
    public static double DEFAULT_WINNER_MULTIPLIER = 1;
    public static String DEFAULT_FILE_PATH = "configuracion.json";

    //Atributos
    public int numeroJugadoresIA = DEFAULT_MAX_IA_PLAYERS;
    public int numeroJugadoresHumanos = DEFAULT_MAX_HUMAN_PLAYERS;
    public int apuestaMinima = DEFAULT_MIN_BET;
    public int apuestaMaxima = DEFAULT_MAX_BET;
    public int saldoInicialJugadoresIA = DEFAULT_IA_INITIAL_BALANCE;
    public int saldoInicialJugadoresHumanos = DEFAULT_HUMAN_INITIAL_BALANCE;
    public int milisegundosEspera = DEFAULT_WAIT_TIME;
    public double multiplicadorBlackjack = DEFAULT_BLACKJACK_MULTIPLIER;
    public double multiplicadorGanadorBasico = DEFAULT_WINNER_MULTIPLIER;
    private transient String filePath = DEFAULT_FILE_PATH;

    /**
     * constuctor
     */
    public Configuracion(String archivoConfiguracion) {
        this.filePath = archivoConfiguracion;
        cargarConfiguracion();
    }

    /**Constructor preferido para las configuraciones
     * @param useDefault si es true se usan las configuraciones por defecto, 
     * si es false se cargan las configuraciones del archivo
     * 
     */
    public Configuracion(boolean useDefault){
        if(!useDefault){
            cargarConfiguracion();
            guardarConfiguracion();
        } else {
            guardarConfiguracion();
        }
    }

    /**
     * m�todo  para leer el archivo de configuraci�n y
     * asignar los valores correspondientes a las variables de la clase.
     * @param archivoConfiguracion
     * @throws IOException
     */
    private void cargarConfiguracion(){
        // Read the serialized object from a file
        Gson gson = new Gson();
        Configuracion configuracion;
        try {
            configuracion = gson.fromJson(new FileReader(filePath), Configuracion.class);
        } catch (IOException e) {
            // Imposible cargar el archivo. Se crea uno nuevo con la configuracion incial
            // guardarConfiguracion se encarga de crear el archivo
            guardarConfiguracion();
            return;
        }

        this.numeroJugadoresIA = configuracion.numeroJugadoresIA;
        this.numeroJugadoresHumanos = configuracion.numeroJugadoresHumanos;
        this.apuestaMinima = configuracion.apuestaMinima;
        this.apuestaMaxima = configuracion.apuestaMaxima;
        this.saldoInicialJugadoresIA = configuracion.saldoInicialJugadoresIA;
        this.saldoInicialJugadoresHumanos = configuracion.saldoInicialJugadoresHumanos;
        this.milisegundosEspera = configuracion.milisegundosEspera;
        this.multiplicadorBlackjack = configuracion.multiplicadorBlackjack;
        this.multiplicadorGanadorBasico = configuracion.multiplicadorGanadorBasico;

        guardarConfiguracion();
    }

    public void guardarConfiguracion() {
        // Serializar el objeto
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filePath)){
            gson.toJson(this, writer);
        } catch (IOException e) {
            //No se ha podido guardar el archivo de configuración
            //Se crea un archivo nuevo con las configuraciones iniciales en el path por defecto
            filePath = DEFAULT_FILE_PATH;
            guardarConfiguracion();
            //Este return es para evitar recursividad infinita
            return;
        }
    }



    //Setters
    public void setNumeroJugadoresIA(int numeroJugadoresIA) {
        this.numeroJugadoresIA = numeroJugadoresIA;
        guardarConfiguracion();
    }

    public void setNumeroJugadoresHumanos(int numeroJugadoresHumanos) {
        this.numeroJugadoresHumanos = numeroJugadoresHumanos;
        guardarConfiguracion();
    }

    public void setApuestaMinima(int apuestaMinima) {
        this.apuestaMinima = apuestaMinima;
        guardarConfiguracion();
    }

    public void setApuestaMaxima(int apuestaMaxima) {
        this.apuestaMaxima = apuestaMaxima;
        guardarConfiguracion();
    }

    public void setSaldoInicialJugadoresIA(int saldoInicialJugadoresIA) {
        this.saldoInicialJugadoresIA = saldoInicialJugadoresIA;
        guardarConfiguracion();
    }

    public void setSaldoInicialJugadoresHumanos(int saldoInicialJugadoresHumanos) {
        this.saldoInicialJugadoresHumanos = saldoInicialJugadoresHumanos;
        guardarConfiguracion();
    }

    public void setMilisegundosEspera(int milisegundosEspera) {
        this.milisegundosEspera = milisegundosEspera;
        guardarConfiguracion();
    }

    public void setMultiplicadorBlackjack(double multiplicadorBlackjack) {
        this.multiplicadorBlackjack = multiplicadorBlackjack;
        guardarConfiguracion();
    }

    public void setMultiplicadorGanadorBasico(double multiplicadorGanadorBasico) {
        this.multiplicadorGanadorBasico = multiplicadorGanadorBasico;
        guardarConfiguracion();
    }

    public boolean changeConfig(String path){
        File file = new File(path);
        if(file.exists()){
            this.filePath = path;
            cargarConfiguracion();
            return true;
        } else {
            return false;
        }
    }

    public void resetConfig(){
        numeroJugadoresIA = DEFAULT_MAX_IA_PLAYERS;
        numeroJugadoresHumanos = DEFAULT_MAX_HUMAN_PLAYERS;
        apuestaMinima = DEFAULT_MIN_BET;
        apuestaMaxima = DEFAULT_MAX_BET;
        saldoInicialJugadoresIA = DEFAULT_IA_INITIAL_BALANCE;
        saldoInicialJugadoresHumanos = DEFAULT_HUMAN_INITIAL_BALANCE;
        milisegundosEspera = DEFAULT_WAIT_TIME;
        multiplicadorBlackjack = DEFAULT_BLACKJACK_MULTIPLIER;
        multiplicadorGanadorBasico = DEFAULT_WINNER_MULTIPLIER;
        guardarConfiguracion();
    }

    public String[] settingsAvailable(){
        String[] settings = new String[13];
        settings[0] = "Numero de jugadores IA";
        settings[1] = "Numero de jugadores humanos";
        settings[2] = "Apuesta mínima";
        settings[3] = "Apuesta máxima";
        settings[4] = "Saldo inicial jugadores IA";
        settings[5] = "Saldo inicial jugadores humanos";
        settings[6] = "Milisegundos espera (IA)";
        settings[7] = "Multiplicador blackjack";
        settings[8] = "Multiplicador ganador básico";
        settings[9] = "Importar configuración";
        settings[10] = "Resetear configuración";
        settings[11] = "Resetear estadísticas";
        settings[12] = "Salir";
        return settings;
    }
    /**
     * M�todo para guardar la configuraci�n en un archivo.
     *
     * @param archivoConfiguracion El nombre del archivo de configuraci�n.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void guardarConfiguracion(String archivoConfiguracion) throws IOException {
        StringBuilder contenido = new StringBuilder();

        contenido.append("numeroJugadoresIA=").append(numeroJugadoresIA).append("\n");
        contenido.append("numeroJugadoresHumanos=").append(numeroJugadoresHumanos).append("\n");
        contenido.append("apuestaMinima=").append(apuestaMinima).append("\n");
        contenido.append("apuestaMaxima=").append(apuestaMaxima).append("\n");
        contenido.append("saldoInicialJugadoresIA=").append(saldoInicialJugadoresIA).append("\n");
        contenido.append("saldoInicialJugadoresHumanos=").append(saldoInicialJugadoresHumanos).append("\n");
        contenido.append("milisegundosEspera=").append(milisegundosEspera).append("\n");
        contenido.append("multiplicadorBlackjack=").append(multiplicadorBlackjack).append("\n");
        contenido.append("multiplicadorGanadorBasico=").append(multiplicadorGanadorBasico).append("\n");

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(archivoConfiguracion));
            writer.write(contenido.toString());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}

