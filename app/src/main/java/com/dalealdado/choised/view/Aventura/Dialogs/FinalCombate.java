package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class FinalCombate extends AppCompatActivity {

   TextView titulo, subtitulo, oro, carne, continuar;
   int winjabali = 0;
   int win = 1;
   int derrota = 2;

   public interface Volver{
       void continuarAventura(String valor);
    }

    private Volver interfaz;

    public FinalCombate(final Context context, final int tipo, final int dinero, Volver volver) {
        interfaz = volver;
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_final_combate);

        titulo = dialog.findViewById(R.id.titulo);
        subtitulo = dialog.findViewById(R.id.subtitulo);
        oro = dialog.findViewById(R.id.oro);
        carne = dialog.findViewById(R.id.carne);
        continuar = dialog.findViewById(R.id.continuar);

        if (tipo == winjabali){
            titulo.setText("¡HAS GANADO!");
            subtitulo.setText("Botin obtenido:");
            oro.setText("Oro: "+dinero);
            carne.setVisibility(View.VISIBLE);
            continuar.setText("PULSA PARA CONTINUAR LA AVENTURA");
        }else if (tipo == win){
            titulo.setText("¡HAS GANADO!");
            subtitulo.setText("Botin obtenido:");
            oro.setText("Oro: "+dinero);
            carne.setVisibility(View.INVISIBLE);
            continuar.setText("PULSA PARA CONTINUAR LA AVENTURA");
        }else if (tipo == derrota){
            titulo.setText("¡HAS PERDIDO!");
            subtitulo.setText("");
            oro.setText("");
            carne.setVisibility(View.INVISIBLE);
            continuar.setText("PULSA PARA VOLVER AL INICIO");
        }

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tipo == winjabali){
                    interfaz.continuarAventura("win");
                }else if (tipo == win){
                    interfaz.continuarAventura("win");
                }else if (tipo == derrota){
                    interfaz.continuarAventura("derrota");
                }
            }
        });
    }
}

