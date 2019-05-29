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

public class Cueva1Dialog {

    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont = 0, cont2 = 0;
    boolean money=false, listo = false;
    String [] historia= {"Hola, ¿es usted el carnicero?", "Hola muchacho, lo siento, pero no tengo genero.", "Si.. A eso venia, acepto la misión de la carne.","Fantastico, pues rapidito que tengo prisa","susurra: Que borde..."};
    String [] dinero={"Pues, tendre que pedirle que me de un adelanto","¿¡COOOOOMOOOOOOO!?", "Pero si no has hecho nada todabia, como te voy a adelanar nada", "Asi es como trabajo, si no quiere me voy a otro lado","...", "Que remedio", "RECIBES 10 DE ORO", "Muy bien, me pongo en marcha"};
    String [] ready ={"¿Has dicho algo?", "No no", "Bueno, voy a por la carne", "Por fin...", "¬︹¬"};

    public Cueva1Dialog(final Context context){
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

                money = true;
                cont = 0;
                texto.setText(dinero[cont2]);
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

                turnonpc();
                listo = true;
                cont = 0;
                texto.setText(ready[cont2]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (cont == 4){
                    texto.setText("");
                    opcion1.setText("Pedirle dinero por adelantado");
                    opcion2.setText("Ir a la mision");
                    opcion1.setVisibility(View.VISIBLE);
                    opcion2.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1200)
                            .playOn(opcion2);
                }
                else if (money){
                    cont2++;
                    if ( cont2 == dinero.length ){
                        dialog.dismiss();
                        Protagonista.setCarniceria(false);
                    } else{
                        rutaDinero();
                    }
                }
                else if (listo){
                    cont2++;
                    if ( cont2 == ready.length ){
                        dialog.dismiss();
                        Protagonista.setCarniceria(false);
                    } else{
                        rutaGo();
                    }
                }
                else {
                    cont++;
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
                turnoprota();
                break;
            case 3:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 4:
                texto.setText(historia[cont]);
                turnoprota();
                break;
        }
    }

    public void rutaDinero(){

        switch (cont2){
            case 1:
                texto.setText(dinero[cont2]);
                turnonpc();
                break;
            case 2:
                texto.setText(dinero[cont2]);
                break;
            case 3:
                texto.setText(dinero[cont2]);
                turnoprota();
                break;
            case 4:
                texto.setText(dinero[cont2]);
                turnonpc();
                break;
            case 5:
                texto.setText(dinero[cont2]);
                break;
            case 6:
                texto.setText(dinero[cont2]);
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                name.setText("");
                break;
            case 7:
                texto.setText(dinero[cont2]);
                turnoprota();
                break;

        }

    }

    public void rutaGo(){
        switch (cont2){
            case 1:
                texto.setText(ready[cont2]);
                turnoprota();
                break;
            case 2:
                texto.setText(ready[cont2]);
                break;
            case 3:
                texto.setText(ready[cont2]);
                turnonpc();
                break;
            case 4:
                texto.setText(ready[cont2]);
                turnoprota();
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
