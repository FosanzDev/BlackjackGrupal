package com.nolete19.BlackJack.Configuracion;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;


public class Configuracion {

    public static String DEFAULT_FILE_PATH = "configuracion.json";

    //Atributos
    public int numeroJugadoresIA = 3;
    public int numeroJugadoresHumanos = 1;
    public int apuestaMinima = 10;
    public int apuestaMaxima = 100;
    public int saldoInicialJugadoresIA = 1000;
    public int saldoInicialJugadoresHumanos = 10;
    public int milisegundosEspera = 1000;
    public double multiplicadorBlackjack = 1.5;
    public double multiplicadorGanadorBasico = 1;
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
}

