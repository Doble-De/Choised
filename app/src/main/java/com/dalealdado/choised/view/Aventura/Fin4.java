package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.view.MainActivity;
import com.dalealdado.dalealdado.R;

public class Fin4 extends AppCompatActivity {

    ImageView pj, barrotes;
    TextView titulo, texto1, texto2, texto3, fin, volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin4);

        titulo = findViewById(R.id.titulo);
        texto1 = findViewById(R.id.texto1);
        texto2 = findViewById(R.id.texto2);
        texto3 = findViewById(R.id.texto3);
        fin = findViewById(R.id.fin);
        volver = findViewById(R.id.volver);
        pj = findViewById(R.id.personaje);
        barrotes = findViewById(R.id.oro6);

        imagenProta();
        barrotes.setImageResource(R.drawable.barrotes);


        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Fin4.this, MainActivity.class));
            }
        });
    }

    void imagenProta() {
        switch (Protagonista.getImagen()) {
            case 1:
                pj.setImageResource(R.drawable.pm1);
                break;
            case 2:
                pj.setImageResource(R.drawable.pm2);
                break;
            case 3:
                pj.setImageResource(R.drawable.pm3);
                break;
            case 4:
                pj.setImageResource(R.drawable.pm4);
                break;
            case 5:
                pj.setImageResource(R.drawable.pf1);
                break;
            case 6:
                pj.setImageResource(R.drawable.pf2);
                break;
            case 7:
                pj.setImageResource(R.drawable.pf3);
                break;
            case 8:
                pj.setImageResource(R.drawable.pf4);
                break;
        }
    }
}
