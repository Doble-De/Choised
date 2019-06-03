package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Ayuda2 extends AppCompatActivity {

    ImageView derecha, izquierda;
    Intent ayuda1, ayuda3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda2);

        derecha = findViewById(R.id.image4);
        izquierda = findViewById(R.id.image3);

        ayuda1 = new Intent(this, Ayuda.class);
        ayuda3 = new Intent(this, Ayuda3.class);

        derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ayuda3);
            }
        });

        izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ayuda1);
            }
        });

    }
}
