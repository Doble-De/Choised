package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.dalealdado.R;

public class CasaSenyorHuerto extends AppCompatActivity {

    ImageButton mArriba, mDerecha;
    Intent intent1, intent2, intent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_senyor_huerto);

        mArriba = findViewById(R.id.arriba6);
        mDerecha = findViewById(R.id.derecha6);

        intent1 = new Intent(this, Fuente.class);
        intent2 = new Intent(this, Huerto.class);

        mArriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
                mDerecha.setEnabled(false);
                mArriba.setEnabled(false);
            }
        });

        mDerecha.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                startActivity(intent2);
               mDerecha.setEnabled(false);
               mArriba.setEnabled(false);
            }
        });

        YoYo.with(Techniques.BounceInDown)
                .duration(2000)
                .playOn(mArriba);

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(mDerecha);


    }
}
