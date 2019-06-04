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

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.Aventura.Dialogs.CastilloDialog;
import com.dalealdado.choised.view.Aventura.Dialogs.Cueva2Dialog;
import com.dalealdado.dalealdado.R;

public class Cueva2 extends AppCompatActivity implements Cueva2Dialog.fin {

    ImageButton bIzquierda;
    ImageView cuevaem;
    Intent cueva1;
    Button dios;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cueva2);
        context = this;

        bIzquierda = findViewById(R.id.izquierda6);
        cuevaem = findViewById(R.id.cuevaenb);
        dios = findViewById(R.id.dioos);
        dios.setEnabled(false);

        cueva1 = new Intent( this, Cueva1.class);

        bIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(cueva1);
                bIzquierda.setEnabled(false);
            }
        });

        if (!Protagonista.getEmblema()){
            dios.setEnabled(true);
            cuevaem.setVisibility(View.VISIBLE);
        }

        dios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Cueva2Dialog(context, Cueva2.this);
            }
        });

        YoYo.with(Techniques.BounceInLeft)
                .duration(2000)
                .playOn(bIzquierda);

    }

    @Override
    public void numerofin(int id) {
        if (id == 4){
            startActivity(new Intent(Cueva2.this, Fin4.class));
        }
    }


}
