package com.dalealdado.choised.model;

public class Bandido {

    int vida = 220;
    int fuerza = 25;
    int agilidad= 30;
    int dinero=30;
    String nombre="Bandido";

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getAgilidad() {
        return agilidad;
    }

    public int getDinero() {
        return dinero;
    }

    public String getNombre() {
        return nombre;
    }
}
