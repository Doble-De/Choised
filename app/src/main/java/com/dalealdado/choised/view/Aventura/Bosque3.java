package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.Aventura.Dialogs.Bosque3Dialog;
import com.dalealdado.choised.view.Aventura.Dialogs.Bosque3Proibido;
import com.dalealdado.choised.view.Aventura.Dialogs.PreCuevaDialog;
import com.dalealdado.dalealdado.R;

public class Bosque3 extends AppCompatActivity implements Bosque3Dialog.pelea {

    Context context;
    ImageButton bAbajo,bIzquierda,bDerecha;
    Intent bosque2,cueva1,bosque6, batallas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosque3);

        bAbajo = findViewById(R.id.abajoFuente);
        bIzquierda = findViewById(R.id.izquierda1);
        bDerecha = findViewById(R.id.derecha1);

        bosque2 = new Intent( this, Bosque2.class);
        bosque6 = new Intent( this, Bosque6.class);
        cueva1 = new Intent(this, Cueva1.class);
        batallas = new Intent(Bosque3.this, BatallasActivity.class);
        context = this;

        bAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque6);
                bAbajo.setEnabled(false);
                bIzquierda.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque2);
                bAbajo.setEnabled(false);
                bIzquierda.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });

        bDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Protagonista.getBandido() && !Protagonista.getBandidoout()){
                    new Bosque3Dialog(context,Bosque3.this);
                }else if (!Protagonista.getBandido() && !Protagonista.getBandidoout()){
                    new Bosque3Proibido(context);
                } else {
                    startActivity(cueva1);
                    bAbajo.setEnabled(false);
                    bIzquierda.setEnabled(false);
                    bDerecha.setEnabled(false);
                }
            }
        });


        if (!Protagonista.getAviso()){
            new PreCuevaDialog(context);
        }
        Protagonista.setAviso(true);

        YoYo.with(Techniques.BounceInUp)
                .duration(2000)
                .playOn(bAbajo);

        YoYo.with(Techniques.BounceInLeft)
                .duration(2000)
                .playOn(bIzquierda);

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(bDerecha);
    }

    @Override
    public void lucha(int id) {
        if (id == 0){
            batallas.putExtra("tipo", "Bandido");
            batallas.putExtra("activity", "Bosque3");
            startActivity(batallas);
        }
    }
}
