package com.fosanzdev.BlackJack.Jugadores;

public class JugadorHumano extends Jugador {
    // Constructor
    public JugadorHumano(String nombre, int saldo) {
        super(nombre, saldo);
    }

    
    @Override
    public Opciones opcion() {
        ioInterface.print("-- Tu mano --", true);
        ioInterface.print(mano.toString(), true);
        ioInterface.print("Puntuación: " + mano.getPuntuacion(), true);
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
                if (apuesta > saldo){
                    ioInterface.print("No tienes suficiente saldo", true);
                } else {
                    this.apuesta = apuesta;
                    return apuesta;
                }
            } catch (Exception e){
                ioInterface.print("Saldo incorrecto", true);
            }
        }
    }
}