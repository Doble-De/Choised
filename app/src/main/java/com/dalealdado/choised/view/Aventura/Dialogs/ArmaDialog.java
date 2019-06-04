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

public class ArmaDialog {
    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont=0;
    String[] historia = {"Yo antes era un gran guerrero...","pero un día me dieron en la rodilla con una flecha.","Ehh...¿Qué?", "No sé, es una historia que me gusta contar.","Entra en la tienda si quieres comprar algo."};


    public ArmaDialog(final Context context){
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

        turnonpc();
        texto.setText(historia[0]);


        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == historia.length) {
                    dialog.dismiss();

                } else {
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
        npc.setImageResource(R.drawable.viejo_armeria);
        name.setText("Viejo Armero");

    }
}
