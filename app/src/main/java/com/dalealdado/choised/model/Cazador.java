package com.dalealdado.choised.model;

public class Cazador {

    int vida = 160;
    int fuerza = 18;
    int agilidad= 90;
    int dinero=20;

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

    String nombre="Cazador";
}
