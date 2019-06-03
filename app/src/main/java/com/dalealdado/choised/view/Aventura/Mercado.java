package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.Aventura.Dialogs.CarniceriaCompleted;
import com.dalealdado.choised.view.Aventura.Dialogs.CarniceriaDialog;
import com.dalealdado.choised.view.Aventura.Dialogs.CarniceriaNormal;
import com.dalealdado.choised.view.Aventura.Dialogs.FuenteDialog;
import com.dalealdado.dalealdado.R;

public class Mercado extends AppCompatActivity implements CarniceriaCompleted.fin{

    ImageButton mIzquierda, mAbajo;
    Intent barrioMagia, entradaBosque;
    Button hablar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mercado);

        mIzquierda = findViewById(R.id.izquierda9);
        hablar = findViewById(R.id.hablar);
        context = this;


        barrioMagia = new Intent(this, BarrioMagia.class);

        hablar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Protagonista.getCarniceria()){
                    new CarniceriaDialog(context);
                } else if (Protagonista.getCarne() >= 6){
                    new CarniceriaCompleted(context, Mercado.this);
                } else {
                    new CarniceriaNormal(context);
                }
            }
        });




        mIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(barrioMagia);
            }
        });
    }

    @Override
    public void numerofin(int id) {
        if (id == 1){
            startActivity(new Intent(Mercado.this, Fin1.class));
        }
    }
}
