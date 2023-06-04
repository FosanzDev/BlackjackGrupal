package com.fosanzdev.BlackJack.Cartas;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Carta {
    //Atributos enumerados
    private Palos palo;
    private Valores valor;
    private ImageIcon image;


    //Constructor
    public Carta(Palos palo, Valores valor) {
        this.palo = palo;
        this.valor = valor;
        this.image = new ImageIcon(this.toPath());
    }

    //Getters
    public Valores getValor() {
        return valor;
    }
    public Palos getPalo() {
        return palo;
    }

    public Image getImage() {
        return image.getImage();
    }

    public ImageIcon getImageIcon() {
        return image;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "palo=" + palo +
                ", valor=" + valor +
                '}';
    }

    public String toPath(){
        StringBuilder sb = new StringBuilder();
        sb.append("src/main/java/com/nolete19/BlackJack/UI/Resources/PNGCards/");
        sb.append(this.getValor().toString());
        switch (this.getPalo()){
            case CORAZONES:
                sb.append("C");
                break;
            case DIAMANTES:
                sb.append("D");
                break;
            case PICAS:
                sb.append("P");
                break;
            case TREBOL:
                sb.append("T");
                break;
        }
        sb.append(".png");
        return sb.toString();
    }
}
