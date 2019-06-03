package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.dalealdado.dalealdado.R;

public class MisionActivity extends AppCompatActivity {

    Button volver, aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mision);

        volver = findViewById(R.id.volver);
        aceptar =  findViewById(R.id.aceptar);

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MisionActivity.this, TablonActivity.class));
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MisionActivity.this, ProtagonistaActivity.class));
            }
        });

    }
}
