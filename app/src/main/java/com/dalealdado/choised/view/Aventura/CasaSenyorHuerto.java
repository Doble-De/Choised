package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.view.Aventura.Dialogs.CasaHuerto;
import com.dalealdado.dalealdado.R;

public class CasaSenyorHuerto extends AppCompatActivity {

    ImageButton mArriba, mDerecha;
    Button anciano;
    Intent intent1, intent2;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casa_senyor_huerto);

        mArriba = findViewById(R.id.arriba6);
        mDerecha = findViewById(R.id.derecha6);
        anciano = findViewById(R.id.viejo);
        context = this;

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
        anciano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CasaHuerto(context);
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
