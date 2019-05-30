package com.dalealdado.choised.model;

public class Protagonista {

    static int imagen, vida=0, fuerza, agilidad, defensa, magia, dinero, carne=0, vidaMaxima;
    static String nombre;
    static Boolean inicio = true, carniceria = true, jabali= false, aviso=false, carta=false, bandido=true, pagado=false;
    static int[] inventario = new int[9];
    static int[] cantidad = new int[9];

    public static int getVidaMaxima() {
        return vidaMaxima;
    }

    public static Boolean getInicio() {
        return inicio;
    }

    public static void setInicio(Boolean inicio) {
        Protagonista.inicio = inicio;
    }

    public static Boolean getCarniceria() {
        return carniceria;
    }

    public static void setCarniceria(Boolean carniceria) {
        Protagonista.carniceria = carniceria;
    }

    public static Boolean getJabali() {
        return jabali;
    }

    public static void setJabali(Boolean jabali) {
        Protagonista.jabali = jabali;
    }

    public static Boolean getAviso() {
        return aviso;
    }

    public static void setAviso(Boolean aviso) {
        Protagonista.aviso = aviso;
    }

    public static Boolean getCarta() {
        return carta;
    }

    public static int[] getInventario() {
        return inventario;
    }

    public static void setCarta(Boolean carta) {
        Protagonista.carta = carta;
    }

    public static Boolean getBandido() {
        return bandido;
    }

    public static void setBandido(Boolean bandido) {
        Protagonista.bandido = bandido;
    }

    public static Boolean getPagado() {
        return pagado;
    }

    public static void setPagado(Boolean pagado) {
        Protagonista.pagado = pagado;
    }

    public static int getCarne() {
        return carne;
    }

    public static void setCarne(int carne) {
        Protagonista.carne = carne;
    }

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

    public static void setVidaMaxima(int vidaMaxima) {
        Protagonista.vidaMaxima = vidaMaxima;
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

    public static void setDinero(int dinero) {
        Protagonista.dinero = dinero;
    }

    public static void añadirInventario(int id){
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

    public static void eliminarInventario(int id){
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

    public static void acualizarInventario(){
        for (int i = 0; i < inventario.length; i++) {
            if ( i+1 != inventario.length){
                if (inventario[i] == 0 && inventario[i+1] != 0){
                    inventario[i] = inventario[i+1];
                }
            }

        }
    }

}
