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

public class CarniceriaCompleted {

    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont = 0, cont2 = 0;
    boolean salir=false, nosalir = false;
    String [] historia= {"Bueno, ya tengo su carne", "¡Fantastico!", "Pues toma por la rapdez de doy algo más","HAS GANADO 20 de ORO", "¡Gracias! Me viene estupendo","Venga, si consigues 6 más no dudes en pasarte", "¡Vale Gracias!"};
    String [] fin={"En realidad ya he cumplido la misión","si, supongo que me ire ya.","¡Toca descansar un poco!"};
    String [] continuar={"Si, me quedare por aqui un rato más","creo que hay cosas interesantes que hacer."};
    public CarniceriaCompleted(final Context context){
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_fuente_dialog);

        name = dialog.findViewById(R.id.name);
        texto = dialog.findViewById(R.id.texto);
        next = dialog.findViewById(R.id.next);
        pj = dialog.findViewById(R.id.pj);
        npc = dialog.findViewById(R.id.npc);
        opcion1 = dialog.findViewById(R.id.opcion1);
        opcion2 = dialog.findViewById(R.id.opcion2);

        turnoprota();
        texto.setText(historia[0]);

        opcion1.setOnClickListener(new View.OnClickListener() {
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
                Protagonista.setDinero(Protagonista.getDinero()+10);

                salir = true;
                cont = 0;
                texto.setText(fin[cont2]);
            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
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

                nosalir = true;
                cont = 0;
                texto.setText(continuar[cont2]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;

                if (cont == historia.length){
                    Protagonista.setCarne(Protagonista.getCarne()-6);
                    turnoprota();
                    texto.setText("");
                    opcion1.setText("Ya he completado la Mision");
                    opcion2.setText("Aún puedo hacer cosas por aqui");
                    opcion1.setVisibility(View.VISIBLE);
                    opcion2.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1200)
                            .playOn(opcion2);
                }else if (salir) {
                    cont2++;
                    if (cont2 == fin.length) {
                        dialog.dismiss();
                        Protagonista.setCarniceria(false);
                    } else {
                        rutaFin();
                    }
                }else if (nosalir){
                    cont2++;
                    if ( cont2 == continuar.length ){
                        dialog.dismiss();
                        Protagonista.setCarniceria(false);
                    } else{
                        rutaNoFin();
                    }
                }else {
                    ponerTexto();
                }


            }
        });

        dialog.show();
    }

    public void ponerTexto(){
        switch (cont){
            case 1:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 2:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 3:
                texto.setText(historia[cont]);
                name.setText("");
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                Protagonista.setDinero(Protagonista.getDinero()+20);
                break;
            case 4:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 5:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 6:
                texto.setText(historia[cont]);
                turnoprota();
                break;
        }
    }

    void rutaFin() {
        switch (cont2){
            case 1:
                texto.setText(fin[cont]);
                break;

            case 2:
                texto.setText(fin[cont]);
                break;
        }
    }

    void rutaNoFin() {
        switch (cont2){
            case 1:
                texto.setText(continuar[cont]);
                break;
        }
    }


    void imagenProta(){
        switch (Protagonista.getImagen()){
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

    void turnoprota(){
        npc.setImageResource(R.color.transparente);
        name.setText(Protagonista.getNombre());
        imagenProta();
    }

    void turnonpc(){
        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.drawable.viejo_carnicero);
        name.setText("Anciano Carnicero");
    }
}

