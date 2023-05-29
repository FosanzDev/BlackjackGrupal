package com.nolete19.BlackJack.Jugadores;

import java.util.Scanner;

import com.nolete19.BlackJack.IO;
import com.nolete19.BlackJack.Mesa;

public class JugadorHumano extends Jugador {

    private IO ioInterface;

    // Constructor
    public JugadorHumano(String nombre, int saldo, Mesa mesa) {
        super(nombre, saldo, mesa);
    }

    
    @Override
    public Opciones opcion() {
        ioInterface.print("-- Tu mano --", true);
        ioInterface.print(mano.toString(), true);
        String option = ioInterface.readString("Desea una nueva carta? (s/n)", true, 
            new String[] {"s", "n", "si", "no"});
        
        if (option.equals("s") || option.equalsIgnoreCase("si")) {
            return Opciones.PEDIR_CARTA;
        } else {
            return Opciones.PLANTARSE;
        }
    }

    @Override
    public int apuesta() {
        int max = mesa.getApuestaMaxima();
        int min = mesa.getApuestaMinima();

        ioInterface.print("Tu saldo: " + saldo + " // Apuesta mínima: " + min + " // Apuesta máxima: " + max, true);
        while (true){
            try{
                int apuesta = ioInterface.readLimitedInt("Introduce cantidad a apostar: ", min, max, false);
                return apuesta;
            } catch (Exception e){
                ioInterface.print("Saldo incorrecto", true);
            }
        }
    }

    public static void main(String[] args) {
        JugadorHumano jh = new JugadorHumano("Jugador", 100, new Mesa(10, 100));
        jh.ioInterface = new IO(new Scanner(System.in));
        System.out.println(jh.opcion());
        System.out.println(jh.apuesta());
    }
}