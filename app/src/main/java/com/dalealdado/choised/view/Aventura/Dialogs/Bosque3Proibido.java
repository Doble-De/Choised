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

public class Bosque3Proibido {
    TextView name, texto;
    ImageView pj, npc, next;
    String [] historia= {"Parece que se trama algo dento...", "antes de investigar completare la misión."};
    int cont = 0;
    public Bosque3Proibido(final Context context){
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

        name.setText(Protagonista.getNombre());

        texto.setText(historia[cont]);

        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);


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

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                    if (cont == historia.length){
                        dialog.dismiss();
                    } else {

                        texto.setText(historia[cont]);
                    }


            }
        });

        dialog.show();
    }
}
