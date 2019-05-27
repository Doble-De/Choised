package com.dalealdado.choised.model;

public class Protagonista {

    static int imagen, vida, fuerza, agilidad, defensa, magia, dinero;
    static String nombre;
    int[] inventario = new int[6];
    int[] cantidad = new int[6];

    public static int getImagen() {
        return imagen;
    }

    public static int getVida() {
        return vida;
    }

    public static int getFuerza() {
        return fuerza;
    }

    public static int getAgilidad() {
        return agilidad;
    }

    public static int getDefensa() {
        return defensa;
    }

    public static int getMagia() {
        return magia;
    }

    public static int getDinero() {
        return dinero;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setImagen(int imagen) {
        Protagonista.imagen = imagen;
    }

    public static void setVida(int vida) {
        Protagonista.vida = vida;
    }

    public static void setFuerza(int fuerza) {
        Protagonista.fuerza = fuerza;
    }

    public static void setAgilidad(int agilidad) {
        Protagonista.agilidad = agilidad;
    }

    public static void setDefensa(int defensa) {
        Protagonista.defensa = defensa;
    }

    public static void setMagia(int magia) {
        Protagonista.magia = magia;
    }

    public static void setNombre(String nombre) {
        Protagonista.nombre = nombre;
    }

    public void añadirInventario(int id){
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == 0){
                inventario[i] = id;
                cantidad[i] ++;
                break;
            }
            else if (inventario[i] == id){
                cantidad[i]++;
                break;
            }
        }

    }

    public void eliminarInventario(int id){
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == id){
                cantidad[i] --;
                if (cantidad[i] == 0){
                    inventario[i] = 0;
                }
                break;
            }
        }
        acualizarInventario();
    }

    void acualizarInventario(){
        for (int i = 0; i < inventario.length; i++) {
            if (inventario[i] == 0 && inventario[i+1] != 0){
                inventario[i] = inventario[i+1];
            }
        }
    }

}
