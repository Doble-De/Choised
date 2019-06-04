package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class Cueva2Dialog  {

    TextView name, texto;
    ImageView pj, npc, next;
    int cont = 0;
    String [] historia= {"*el amuleto empieza a brillar", "Parece que el amuleto está reaccionando ante algo aquí...", "¿Que es esa marca de la pared?"};

    public interface fin{
        void numerofin(int id);
    }
    private fin interfaz;

    public Cueva2Dialog(final Context context, fin actividad){

        interfaz = actividad;
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

        npc.setImageResource(R.color.transparente);
        pj.setImageResource(R.color.transparente);
        name.setText("");
        texto.setText(historia[cont]);

        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == historia.length) {
                    interfaz.numerofin(4);
                    dialog.dismiss();
                }else {
                    imagenProta();
                    texto.setText(historia[cont]);
                }
            }
        });

        dialog.show();
    }

    void imagenProta(){
        name.setText(Protagonista.getNombre());
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
