package com.dalealdado.choised.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.choised.DADViewModel;
import com.dalealdado.dalealdado.R;

public class EnemigosShowActivity extends AppCompatActivity {

    Button modif, borrar;
    String name = "", raza="", desc="", vida="", fuerza="", defensa="", evasion="", agilidad="", mana="", magia="", habi="", drops="";
    int id = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemigos_show);
        final DADViewModel DADViewModel = ViewModelProviders.of(this).get(DADViewModel.class);

        id = getIntent().getIntExtra("enemigoid",0);
        modif = findViewById(R.id.modificar);
        borrar = findViewById(R.id.eliminar);

        final TextView tveNombre = findViewById(R.id.etEnombre);
        final TextView tveRaza = findViewById(R.id.etEraza);
        final TextView tveDescripcion = findViewById(R.id.etEdesc);
        final TextView tveVida = findViewById(R.id.etEvida);
        final TextView tveFuerza = findViewById(R.id.etEfuerza);
        final TextView tveDefensa = findViewById(R.id.etEdefensa);
        final TextView tveEvasion = findViewById(R.id.etEevasion);
        final TextView tveAgilidad = findViewById(R.id.etEagilidad);
        final TextView tveMana = findViewById(R.id.etEmana);
        final TextView tveMagia = findViewById(R.id.etEmagia);
        final TextView tveDrop = findViewById(R.id.etdrop);
        final TextView tveHabilidades = findViewById(R.id.etEhabilidades);
        final DADViewModel enemigoViewModel = ViewModelProviders.of(this).get(DADViewModel.class);

        enemigoViewModel.getEnemigo(id).observe(this, new Observer<Enemigo>() {
            @Override
            public void onChanged(@Nullable Enemigo enemigo) {
                tveNombre.setText(enemigo.nombre);
                tveRaza.setText(enemigo.raza);
                tveDescripcion.setText(enemigo.descripcion);
                tveFuerza.setText(enemigo.fuerza);
                tveDefensa.setText(enemigo.defensa);
                tveVida.setText(enemigo.vida);
                tveEvasion.setText(enemigo.evasion);
                tveAgilidad.setText(enemigo.agilidad);
                tveMana.setText(enemigo.mana);
                tveMagia.setText(enemigo.magia);
                tveDrop.setText(enemigo.drop);
                tveHabilidades.setText(enemigo.habilidades);
                name = enemigo.nombre;
                raza = enemigo.raza;
                desc = enemigo.descripcion;
                fuerza = enemigo.fuerza;
                defensa = enemigo.defensa;
                vida = enemigo.vida;
                evasion = enemigo.evasion;
                agilidad = enemigo.agilidad;
                mana = enemigo.mana;
                magia = enemigo.magia;
                drops = enemigo.drop;
                habi = enemigo.habilidades;
                id = enemigo.id;
            }
        });

        modif.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(EnemigosShowActivity.this, EnemigosModifActivity.class);
                        intent.putExtra("id", String.valueOf(id));
                        intent.putExtra("nombre", name);
                        intent.putExtra("raza", raza);
                        intent.putExtra("descripcion", desc);
                        intent.putExtra("fuerza", fuerza);
                        intent.putExtra("defensa", defensa);
                        intent.putExtra("vida", vida);
                        intent.putExtra("evasion", evasion);
                        intent.putExtra("agilidad", agilidad);
                        intent.putExtra("mana", mana);
                        intent.putExtra("magia", magia);
                        intent.putExtra("drop", drops);
                        intent.putExtra("habi", habi);
                        startActivity(intent);

            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DADViewModel.deleteEnemigo(id);
                onDestroy();
            }
        });



    }
}
