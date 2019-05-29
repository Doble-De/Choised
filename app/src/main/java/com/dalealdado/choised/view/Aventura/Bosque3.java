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
import com.dalealdado.choised.view.Aventura.Dialogs.PreCuevaDialog;
import com.dalealdado.dalealdado.R;

public class Bosque3 extends AppCompatActivity {

    Context context;
    ImageButton bAbajo,bIzquierda,bDerecha;
    Intent bosque2,cueva1,bosque6;

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
        context = this;

        bAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque6);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque2);
            }
        });

        bDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cueva1);
            }
        });


        if (!Protagonista.getAviso()){
            new PreCuevaDialog(context);
        }
        Protagonista.setAviso(true);

        YoYo.with(Techniques.BounceInUp)
                .duration(5000)
                .playOn(bAbajo);

        YoYo.with(Techniques.BounceInLeft)
                .duration(5000)
                .playOn(bIzquierda);

        YoYo.with(Techniques.BounceInRight)
                .duration(5000)
                .playOn(bDerecha);
    }
}
