package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.dalealdado.choised.view.Aventura.Dialogs.CastilloDialog;
import com.dalealdado.dalealdado.R;

public class Castillo extends AppCompatActivity implements CastilloDialog.fin{

    Context context;
    ImageButton mDerecha;
    Intent fuente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castillo);

        mDerecha = findViewById(R.id.derecha4);
        fuente = new Intent(this, Fuente.class);
        context = this;


        new CastilloDialog(context, Castillo.this);

        mDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(fuente);
            }
        });

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
