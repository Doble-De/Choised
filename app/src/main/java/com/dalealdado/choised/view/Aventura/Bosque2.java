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

public class Bosque2 extends AppCompatActivity {

    ImageButton bAbajo,bIzquierda,bDerecha;
    Intent bosque1,bosque3,bosque5,batallas;
    int jabali;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosque2);

        bAbajo = findViewById(R.id.abajoFuente19);
        bIzquierda = findViewById(R.id.izquierda19);
        bDerecha = findViewById(R.id.derecha19);
        ImageView huellas= findViewById(R.id.huellas);

        bosque1 = new Intent( this, Bosque1.class);
        bosque3 = new Intent( this, Bosque3.class);
        bosque5 = new Intent(this, Bosque5.class);
        batallas = new Intent(Bosque2.this, BatallasActivity.class);


        bAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque5);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque1);
            }
        });

        bDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque3);
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
                    batallas.putExtra("activity", "Bosque2");
                    startActivity(batallas);
                }
            });
        }

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
