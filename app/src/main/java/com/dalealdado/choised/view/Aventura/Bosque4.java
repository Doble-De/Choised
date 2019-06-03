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

public class Bosque4 extends AppCompatActivity {

    ImageButton bArriba,bDerecha;
    Intent bosque1,bosque5,batallas;
    int jabali;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosque4);

        bArriba = findViewById(R.id.arriba);
        bDerecha = findViewById(R.id.derecha1);
        ImageView huellas= findViewById(R.id.huellas);

        bosque1 = new Intent( this, Bosque1.class);
        bosque5 = new Intent( this, Bosque5.class);
        batallas = new Intent(Bosque4.this, BatallasActivity.class);

        bArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque1);
                bArriba.setEnabled(false);
                bDerecha.setEnabled(false);
            }
        });

        bDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque5);
                bArriba.setEnabled(false);
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
                    batallas.putExtra("activity", "Bosque4");
                    startActivity(batallas);
                }
            });
        }

        YoYo.with(Techniques.BounceInDown)
                .duration(2000)
                .playOn(bArriba);

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(bDerecha);
    }
}
