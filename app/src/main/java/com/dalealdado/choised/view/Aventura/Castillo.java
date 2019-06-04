package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.Aventura.Dialogs.CastilloDialog;
import com.dalealdado.dalealdado.R;

public class Castillo extends AppCompatActivity implements CastilloDialog.fin{

    Context context;
    ImageButton mDerecha;
    ImageView anciano;
    Intent fuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castillo);

        mDerecha = findViewById(R.id.derecha4);
        fuente = new Intent(this, Fuente.class);
        anciano = findViewById(R.id.anciano);
        context = this;


        if (!Protagonista.getAviso()){
            new CastilloDialog(context, Castillo.this);
        }

        anciano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new CastilloDialog(context, Castillo.this);
            }
        });

        mDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fuente);
                mDerecha.setEnabled(false);

            }
        });

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(mDerecha);

    }

    @Override
    public void numerofin(int id) {
        if (id == 2){
            startActivity(new Intent(Castillo.this, Fin2.class));
        } else if (id == 3){
            startActivity(new Intent(Castillo.this, Fin3.class));
        }
    }
}
