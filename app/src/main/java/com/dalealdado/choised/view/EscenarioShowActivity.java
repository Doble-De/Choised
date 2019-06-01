package com.dalealdado.choised.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dalealdado.choised.model.Escenario;
import com.dalealdado.dalealdado.R;

public class EscenarioShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escenario_show);
        int id = getIntent().getIntExtra("Pokid",0);

        final TextView tvNombre = findViewById(R.id.tvnombre);
        final TextView tvGeneracion = findViewById(R.id.tvgen);
        final TextView tvDescripcion = findViewById(R.id.tvdesc);
        final EscenarioViewModel escenaroViewModel = ViewModelProviders.of(this).get(EscenarioViewModel.class);
        escenaroViewModel.getEscenario(id).observe(this, new Observer<Escenario>() {
            @Override
            public void onChanged(@Nullable Escenario escenario) {
                tvNombre.setText(escenario.nombre);
                tvGeneracion.setText(escenario.gen);
                tvDescripcion.setText(escenario.desc);
            }
        });

    }


}
