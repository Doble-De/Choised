package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.dalealdado.R;

import java.util.Random;

public class Bosque6 extends AppCompatActivity {

    ImageButton bArriba,bIzquierda;
    Intent bosque3,bosque5, batallas;
    int jabali;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bosque6);

        bArriba = findViewById(R.id.arriba6);
        bIzquierda = findViewById(R.id.izquierda6);
        ImageView huellas= findViewById(R.id.huellas);

        bosque3 = new Intent( this, Bosque3.class);
        bosque5 = new Intent( this, Bosque5.class);
        batallas = new Intent(Bosque6.this, BatallasActivity.class);

        bArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque3);
                bArriba.setEnabled(false);
                bIzquierda.setEnabled(false);
            }
        });

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(bosque5);
                bArriba.setEnabled(false);
                bIzquierda.setEnabled(false);
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
                    batallas.putExtra("activity", "Bosque6");
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

    }
}
