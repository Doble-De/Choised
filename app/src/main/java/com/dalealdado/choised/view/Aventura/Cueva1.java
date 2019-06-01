package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.Aventura.Dialogs.Cueva1Dialog;
import com.dalealdado.dalealdado.R;

public class Cueva1 extends AppCompatActivity {

    ImageButton bAbajo,bIzquierda;
    Intent bosque3,cueva2;
    ImageView destello;
    Button carta;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cueva1);

        context = this;
        bAbajo = findViewById(R.id.izquierda6);
        bIzquierda = findViewById(R.id.derecha6);
        destello = findViewById(R.id.destello);
        carta = findViewById(R.id.carta);

        bosque3 = new Intent( this, Bosque3.class);
        cueva2 = new Intent( this, Cueva2.class);

        bAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque3);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cueva2);
            }
        });

        carta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Cueva1Dialog(context);
            }
        });

        if (!Protagonista.getCarta()){
            carta.setEnabled(true);
            YoYo.with(Techniques.Flash)
                    .duration(500)
                    .playOn(destello);
            YoYo.with(Techniques.FadeOut)
                    .duration(500)
                    .delay(500)
                    .playOn(destello);
        }else {
            destello.setImageResource(R.color.transparente);
            carta.setEnabled(false);
        }

    }
}
