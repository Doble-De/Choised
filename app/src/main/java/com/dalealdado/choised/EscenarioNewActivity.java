package com.dalealdado.choised;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dalealdado.choised.model.Escenario;
import com.dalealdado.dalealdado.R;

public class EscenarioNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escenario_new);

        final EscenarioViewModel escenaroViewModel = ViewModelProviders.of(this).get(EscenarioViewModel.class);
        findViewById(R.id.guardar).setOnClickListener(new View.OnClickListener() {

            EditText nombrePokemon = findViewById(R.id.etnombre);
            EditText genPokemon = findViewById(R.id.etgen);
            EditText descPokemon = findViewById(R.id.etdesc);

            @Override
            public void onClick(View view) {

                Escenario escenario = new Escenario();

                escenario.nombre = nombrePokemon.getText().toString();
                escenario.gen = genPokemon.getText().toString();
                escenario.desc = descPokemon.getText().toString();

                escenaroViewModel.insertEscenario(escenario);
                finish();
            }
        });
    }
}

