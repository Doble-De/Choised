package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class Bosque3Dialog {
    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont = 1, cont2 = 0, cont3=0;
    boolean irse = false, pelear= false;
    String[] historia = {"Voy a investigar un poco...", "*se encuentra al hombre en su cara*", "¡AHHHHHHH!","Que tenemos aquí, ¿fisgoneando no?"};
    String[] huir = {"No no, perdón, ¿a la ciudad no se va por aquí?","...","...","...","Ehh... ¿Hola?","¡FUERA DE MI VISTA!", "¡Si señor, adiós!"};
    String[] pelea = {"No voy a permitir que matéis al rey", "Así que lo has oído...", "pues no te voy a poder dejar con vida."};
    String[] ayuda = {"Alto ahí", "¿Otra molestia?", "Este es mi bosque","y no voy a permitir que amenaces a mi invitado","JAJAJAJAJAJA", "¿Y qué vas a hacer?", "Ahora lo veras...", "*el cazador y el bandido se alejarían peleándose*","...", "Es mi oportunidad de entrar en la cueva"};


    public interface pelea{
        void lucha(int id);
    }
    private Bosque3Dialog.pelea interfaz;

    public Bosque3Dialog(final Context context, pelea actividad) {

        interfaz=actividad;
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_fuente_dialog);

        name = dialog.findViewById(R.id.name);
        texto = dialog.findViewById(R.id.texto);
        next = dialog.findViewById(R.id.next);
        pj = dialog.findViewById(R.id.personaje);
        npc = dialog.findViewById(R.id.npc);
        opcion1 = dialog.findViewById(R.id.opcion1);
        opcion2 = dialog.findViewById(R.id.opcion2);
        Protagonista.setBandido(true);

        turnoprota();
        texto.setText(historia[0]);


        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);


        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomOut)
                        .duration(500)
                        .playOn(opcion1);
                YoYo.with(Techniques.ZoomOut)
                        .duration(1000)
                        .playOn(opcion1);
                opcion1.setVisibility(View.INVISIBLE);
                opcion2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

                turnoprota();
                pelear = true;
                cont = 0;
                texto.setText(pelea[cont2]);
                Protagonista.setBandidoout(true);
            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomOut)
                        .duration(1000)
                        .playOn(opcion1);
                YoYo.with(Techniques.ZoomOut)
                        .duration(500)
                        .playOn(opcion1);
                opcion1.setVisibility(View.INVISIBLE);
                opcion2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

                irse = true;
                cont = 0;
                texto.setText(huir[cont2]);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (cont == historia.length) {
                    turnoprota();
                    texto.setText("");
                    opcion1.setText("¡Plantarle Cara!");
                    opcion2.setText("Disculpe las molestias");
                    opcion1.setVisibility(View.VISIBLE);
                    opcion2.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1200)
                            .playOn(opcion2);
                } else if (irse) {
                    cont2++;
                    if (cont2 == huir.length) {
                        dialog.dismiss();
                    } else {
                        rutaHuida();
                    }
                } else if (pelear) {
                    cont2++;
                    if (cont2 >= pelea.length) {
                        if (Protagonista.getPagado()){
                            if (cont3 == ayuda.length){
                                dialog.dismiss();
                            }else {
                                rutaCazador();
                                cont3++;
                            }

                        }else {
                            interfaz.lucha(0);
                            dialog.dismiss();
                        }

                    } else {
                        rutaPelea();
                    }
                } else {
                    ponerTexto();
                    cont++;
                }


            }
        });

        dialog.show();
    }

    public void ponerTexto() {

        switch (cont) {
            case 1:
                texto.setText(historia[cont]);
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                name.setText("");
                break;
            case 2:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 3:
                texto.setText(historia[cont]);
                turnonpc();
                break;
        }
    }

    public void rutaPelea() {

        switch (cont2) {
            case 1:
                texto.setText(pelea[cont2]);
                turnonpc();
                break;
            case 2:
                texto.setText(pelea[cont2]);
                break;

        }

    }

    public void rutaHuida() {
        switch (cont2) {
            case 1:
                texto.setText(huir[cont2]);
                turnonpc();
                break;
            case 2:
                texto.setText(huir[cont2]);
                turnoprota();
                break;
            case 3:
                texto.setText(huir[cont2]);
                turnonpc();
                break;
            case 4:
                texto.setText(huir[cont2]);
                turnoprota();
                break;
            case 5:
                texto.setText(huir[cont2]);
                turnonpc();
                break;
            case 6:
                texto.setText(huir[cont2]);
                turnoprota();
                break;

        }
    }

    public void rutaCazador(){
        switch (cont3) {
            case 0:
                texto.setText(ayuda[cont3]);
                turnonpc2();
                break;
            case 1:
                texto.setText(ayuda[cont3]);
                turnonpc();
                break;
            case 2:
                texto.setText(ayuda[cont3]);
                turnonpc2();
                break;
            case 3:
                texto.setText(ayuda[cont3]);
                break;
            case 4:
                texto.setText(ayuda[cont3]);
                turnonpc();
                break;
            case 5:
                texto.setText(ayuda[cont3]);
                break;
            case 6:
                texto.setText(ayuda[cont3]);
                turnonpc2();
                break;
            case 7:
                texto.setText(ayuda[cont3]);
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                name.setText("");
                break;
            case 8:
                texto.setText(ayuda[cont3]);
                turnoprota();
                break;
            case 9:
                texto.setText(ayuda[cont3]);
                break;


        }
    }

    void imagenProta() {
        switch (Protagonista.getImagen()) {
            case 1:
                pj.setImageResource(R.drawable.pm1);
                break;
            case 2:
                pj.setImageResource(R.drawable.pm2);
                break;
            case 3:
                pj.setImageResource(R.drawable.pm3);
                break;
            case 4:
                pj.setImageResource(R.drawable.pm4);
                break;
            case 5:
                pj.setImageResource(R.drawable.pf1);
                break;
            case 6:
                pj.setImageResource(R.drawable.pf2);
                break;
            case 7:
                pj.setImageResource(R.drawable.pf3);
                break;
            case 8:
                pj.setImageResource(R.drawable.pf4);
                break;
        }
    }

    void turnoprota() {
        npc.setImageResource(R.color.transparente);
        name.setText(Protagonista.getNombre());
        imagenProta();
    }

    void turnonpc() {
        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.drawable.bandido);
        name.setText("Bandido");
    }

    void turnonpc2() {
        pj.setImageResource(R.drawable.cazador2);
        npc.setImageResource(R.color.transparente);
        name.setText("Cazador");
    }
}
