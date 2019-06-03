package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dalealdado.dalealdado.R;

public class Ayuda3 extends AppCompatActivity {

    ImageView izquierda;
    Intent ayuda2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda3);

        izquierda = findViewById(R.id.image4);
        ayuda2 = new Intent(this, Ayuda2.class);

        izquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ayuda2);
            }
        });

    }
}
