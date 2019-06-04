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

public class PreCuevaDialog {

    TextView name, texto;
    ImageView pj, npc, next;
    String [] historia= {"*se verían dos hombres hablando a lo lejos* ", "Bueno, ¿ya lo tienes todo listo?", "Si, pero no creo que sea tan fácil como lo pintas...", "pero tu pagas tu mandas.",
    "Sii, confía en mi", "ese viejales pluriempleado no va a ser un problema","JAJAJAJAJAJA","Mantente escondido en la cueva, esta noche empezara todo", "Por fin seré el Rey", "No sé si esto saldrá bien...","*uno de los hombres se perderdería en el bosque, el otro se metería en la cueva*","*"+Protagonista.getNombre()+" se quedaría sorprendido*", "Parece que quieren matar al Rey...", "!Debería que hacer algo!"};
    int cont = 1;

    public PreCuevaDialog(final Context context){
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

        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.color.transparente);

        name.setText("");
        texto.setText(historia[0]);


        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cont == historia.length) {
                    dialog.dismiss();
                } else {
                    ponerTexto();
                }
                cont++;
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
                turnonpc2();
                break;
            case 3:
                texto.setText(historia[cont]);
                break;
            case 4:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 5:
                texto.setText(historia[cont]);
                break;
            case 6:
                texto.setText(historia[cont]);
                break;
            case 7:
                texto.setText(historia[cont]);
                break;
            case 8:
                texto.setText(historia[cont]);
                break;
            case 9:
                texto.setText(historia[cont]);
                turnonpc2();
                break;
            case 10:
                texto.setText(historia[cont]);
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                name.setText(" ");
                break;
            case 11:
                texto.setText(historia[cont]);
                break;
            case 12:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 13:
                texto.setText(historia[cont]);
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
        pj.setImageResource(R.drawable.ministro);
        npc.setImageResource(R.color.transparente);
        name.setText("Ministro");
    }

    void turnonpc2(){
        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.drawable.bandido);
        name.setText("Bandido");
    }
}
