package com.dalealdado.choised;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dalealdado.choised.model.Escenario;
import com.dalealdado.choised.view.EscenarioNewActivity;
import com.dalealdado.choised.view.EscenarioViewModel;
import com.dalealdado.dalealdado.R;

import java.util.List;

public class EscenariosActivity extends AppCompatActivity {

    AdaptadorEscenario adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escenarios);

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EscenariosActivity.this, EscenarioNewActivity.class));
            }
        });

        final EscenarioViewModel escenaroViewModel = ViewModelProviders.of(this).get(EscenarioViewModel.class);

        escenaroViewModel.getEscenarios();


        RecyclerView recyclerView = findViewById(R.id.list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adaptador = new AdaptadorEscenario(EscenariosActivity.this);
        recyclerView.setAdapter(adaptador);


        escenaroViewModel.getEscenarios().observe(this, new Observer<List<Escenario>>() {
            @Override
            public void onChanged(@Nullable List<Escenario> pokemones) {
                adaptador.setList(pokemones);
                adaptador.notifyDataSetChanged();
            }
        });



    }
}
