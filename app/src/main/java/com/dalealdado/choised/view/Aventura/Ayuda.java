package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Ayuda extends AppCompatActivity {

    ImageView derecha;
    Intent ayuda2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayuda);

        derecha = findViewById(R.id.image3);
        ayuda2 = new Intent(this, Ayuda2.class);

        derecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ayuda2);
            }
        });


    }
}
