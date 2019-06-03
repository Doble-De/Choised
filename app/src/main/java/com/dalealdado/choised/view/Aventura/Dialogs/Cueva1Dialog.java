package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class Cueva1Dialog {

    TextView name, texto;
    ImageView pj, npc, next;
    String [] historia= {"¿Que es esto que hay en el suelo?", "*en el suelo habria una carta que "+Protagonista.getNombre()+" cojeria y la leeria*","¡Es una carta con el plan para matar al Rey!","Iré al castillo para enseñarselo a la guardia real"};
    int cont = 0;
    public Cueva1Dialog(final Context context){
        final Dialog dialog = new Dialog(context);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.BOTTOM);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_fuente_dialog);

        name = dialog.findViewById(R.id.name);
        texto = dialog.findViewById(R.id.texto);
        next = dialog.findViewById(R.id.next);
        pj = dialog.findViewById(R.id.personaje);
        npc = dialog.findViewById(R.id.npc);

        npc.setImageResource(R.color.transparente);

        imagenProta();
        name.setText(Protagonista.getNombre());

        texto.setText(historia[cont]);

        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == historia.length){
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
                name.setText("");
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                Protagonista.setDinero(Protagonista.getDinero()+20);
                Protagonista.setCarta(true);
                break;
            case 2:
                texto.setText(historia[cont]);
                imagenProta();
                name.setText(Protagonista.getNombre());
                break;
            case 3:
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
}
