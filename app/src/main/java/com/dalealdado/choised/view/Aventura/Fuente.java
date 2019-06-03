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
import com.dalealdado.choised.view.Aventura.Dialogs.FuenteDialog;
import com.dalealdado.dalealdado.R;

public class Fuente extends AppCompatActivity {

        Context context;
        ImageButton mArriba, mAbajo, mDerecha, mIzquierda;
        Intent magia, casa_semilla, castillo, bosque;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_fuente);


            mArriba = findViewById(R.id.arriba);
            mDerecha = findViewById(R.id.derecha20);
            mAbajo = findViewById(R.id.abajo);
            mIzquierda = findViewById(R.id.izquierda);
            context = this;

            magia = new Intent(Fuente.this, BarrioMagia.class);
            casa_semilla = new Intent(Fuente.this, CasaSenyorHuerto.class);
            castillo = new Intent(Fuente.this, Castillo.class);
            bosque = new Intent(Fuente.this, Bosque1.class);

            if (Protagonista.getInicio()){
                new FuenteDialog(context);
            }

            mArriba.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(magia);
                    mAbajo.setEnabled(false);
                    mIzquierda.setEnabled(false);
                    mDerecha.setEnabled(false);
                    mArriba.setEnabled(false);
                }
            });

            mDerecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Protagonista.getCarniceria()){
                        new FuenteDialog(context);
                    }else {
                        startActivity(bosque);
                        mAbajo.setEnabled(false);
                        mIzquierda.setEnabled(false);
                        mDerecha.setEnabled(false);
                        mArriba.setEnabled(false);
                    }
                }
            });

            mAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(casa_semilla);
                    mAbajo.setEnabled(false);
                    mIzquierda.setEnabled(false);
                    mDerecha.setEnabled(false);
                    mArriba.setEnabled(false);
                }
            });

            mIzquierda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(castillo);
                    mAbajo.setEnabled(false);
                    mIzquierda.setEnabled(false);
                    mDerecha.setEnabled(false);
                    mArriba.setEnabled(false);
                }
            });

            YoYo.with(Techniques.BounceInDown)
                    .duration(2000)
                    .playOn(mArriba);

            YoYo.with(Techniques.BounceInLeft)
                    .duration(2000)
                    .playOn(mIzquierda);

            YoYo.with(Techniques.BounceInRight)
                    .duration(2000)
                    .playOn(mDerecha);

            YoYo.with(Techniques.BounceInUp)
                    .duration(2000)
                    .playOn(mAbajo);
        }
}
