package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.view.Aventura.Dialogs.ArmeriaDialog;
import com.dalealdado.dalealdado.R;

public class BarrioArma extends AppCompatActivity {

    ImageButton bderecha;
    Intent magia;
    Button comprar;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barrio_arma);

        comprar = findViewById(R.id.comprar);
        context = this;

        YoYo.with(Techniques.Flash)
                .duration(6000)
                .repeat(100)
                .playOn(comprar);

        bderecha = findViewById(R.id.derecha5);

        final Toast toast = new Toast(context);

        magia = new Intent( this, BarrioMagia.class);

        bderecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(magia);
                bderecha.setEnabled(false);
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ArmeriaDialog(context, toast);
            }
        });

        YoYo.with(Techniques.BounceInRight)
                .duration(2000)
                .playOn(bderecha);


    }
}
