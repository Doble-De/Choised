package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.view.Aventura.Dialogs.ArmeriaDialog;
import com.dalealdado.choised.view.Aventura.Dialogs.MagiaDialog;
import com.dalealdado.choised.view.Aventura.Dialogs.MagiaDialogo;
import com.dalealdado.dalealdado.R;

public class BarrioMagia extends AppCompatActivity {

    ImageButton bAbajo,bIzquierda,bDerecha;
    ImageView viejo;
    Intent arma,fuente,mercado;
    Button comprar;
    Context context;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_barrio_magia);

            comprar = findViewById(R.id.comprar);
            viejo = findViewById(R.id.viejo);
            context = this;

            YoYo.with(Techniques.Flash)
                    .duration(6000)
                    .repeat(100)
                    .playOn(comprar);

            bAbajo = findViewById(R.id.abajoFuente);
            bIzquierda = findViewById(R.id.izquierda1);
            bDerecha = findViewById(R.id.derecha1);


            fuente = new Intent( this, Fuente.class);
            arma = new Intent( this, BarrioArma.class);
            mercado = new Intent(this, Mercado.class);

            final Toast toast =  new Toast(context);

            viejo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new MagiaDialogo(context);
                }
            });

            bAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(fuente);
                    bAbajo.setEnabled(false);
                    bIzquierda.setEnabled(false);
                    bDerecha.setEnabled(false);
                }
            });

            bIzquierda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(arma);
                    bAbajo.setEnabled(false);
                    bIzquierda.setEnabled(false);
                    bDerecha.setEnabled(false);
                }
            });

            bDerecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(mercado);
                    bAbajo.setEnabled(false);
                    bIzquierda.setEnabled(false);
                    bDerecha.setEnabled(false);
                }
            });

            comprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new MagiaDialog(context, toast);
                }
            });

            YoYo.with(Techniques.BounceInLeft)
                    .duration(2000)
                    .playOn(bIzquierda);

            YoYo.with(Techniques.BounceInRight)
                    .duration(2000)
                    .playOn(bDerecha);

            YoYo.with(Techniques.BounceInUp)
                    .duration(2000)
                    .playOn(bAbajo);

        }

}
