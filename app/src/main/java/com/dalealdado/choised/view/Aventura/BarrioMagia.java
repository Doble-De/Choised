package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.view.Aventura.Dialogs.ArmeriaDialog;
import com.dalealdado.choised.view.Aventura.Dialogs.MagiaDialog;
import com.dalealdado.dalealdado.R;

public class BarrioMagia extends AppCompatActivity {

    ImageButton bAbajo,bIzquierda,bDerecha;
    Intent arma,fuente,mercado;
    Button comprar;
    Context context;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_barrio_magia);

            comprar = findViewById(R.id.comprar);
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

            bAbajo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(fuente);
                }
            });

            bIzquierda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(arma);
                }
            });

            bDerecha.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(mercado);
                }
            });

            comprar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new MagiaDialog(context);
                }
            });

        }

}
