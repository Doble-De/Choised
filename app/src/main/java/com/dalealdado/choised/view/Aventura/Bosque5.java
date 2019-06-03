package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.dalealdado.R;

import java.util.Random;

public class Bosque5 extends AppCompatActivity {

    ImageButton bArriba,bIzquierda,bDerecha;
    Intent bosque4,bosque6, bosque2,batallas;
    int jabali;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosque5);

        bArriba = findViewById(R.id.arriba6);
        bIzquierda = findViewById(R.id.izquierda6);
        bDerecha = findViewById(R.id.derecha6);

        ImageView huellas= findViewById(R.id.huellas);

        bosque2 = new Intent( this, Bosque2.class);
        bosque6 = new Intent( this, Bosque6.class);
        bosque4 = new Intent( this, Bosque4.class);
        batallas = new Intent(Bosque5.this, BatallasActivity.class);

        bArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque2);
                bArriba.setEnabled(false);
                bIzquierda.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });

        bDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque6);
                bArriba.setEnabled(false);
                bIzquierda.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque4);
                bArriba.setEnabled(false);
                bIzquierda.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });


        jabali = random.nextInt(4);
        System.out.println(jabali);

        if (jabali != 3) {
            huellas.setImageResource(R.drawable.transparente);
        } else {
            huellas.setImageResource(R.drawable.pisadasjabali);
            huellas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    batallas.putExtra("tipo", "Jabali");
                    batallas.putExtra("activity", "Bosque5");
                    startActivity(batallas);
                }
            });
        }

        YoYo.with(Techniques.BounceInDown)
                .duration(2000)
                .playOn(bArriba);

        YoYo.with(Techniques.BounceInLeft)
                .duration(2000)
                .playOn(bIzquierda);

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(bDerecha);
    }
}
