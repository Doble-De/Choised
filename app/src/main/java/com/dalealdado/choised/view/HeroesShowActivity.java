package com.dalealdado.choised.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dalealdado.choised.model.Heroe;
import com.dalealdado.choised.DADViewModel;
import com.dalealdado.dalealdado.R;

public class HeroesShowActivity extends AppCompatActivity {

    Button modif, borrar;
    int id = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_show);
        modif = findViewById(R.id.modificar);
        borrar = findViewById(R.id.eliminar);

        final TextView tvhNombre = findViewById(R.id.etnombre);
        final TextView tvhRaza = findViewById(R.id.etraza);
        final TextView tvhDescripcion = findViewById(R.id.etdesc);
        final TextView tvhVida = findViewById(R.id.etvida);
        final TextView tvhFuerza = findViewById(R.id.etfuerza);
        final TextView tvhDefensa = findViewById(R.id.etdefensa);
        final TextView tvhEvasion = findViewById(R.id.etevasion);
        final TextView tvhAgilidad = findViewById(R.id.etagilidad);
        final TextView tvhMana = findViewById(R.id.etmana);
        final TextView tvhMagia = findViewById(R.id.etmagia);
        final TextView tvhinventario = findViewById(R.id.etinventario);
        final TextView tvhHabilidades = findViewById(R.id.ethabilidades);
        final DADViewModel heroeViewModel = ViewModelProviders.of(this).get(DADViewModel.class);
        heroeViewModel.getHeroe(id).observe(this, new Observer<Heroe>() {
            @Override
            public void onChanged(@Nullable Heroe heroe) {
                tvhNombre.setText(heroe.nombre);
                tvhRaza.setText(heroe.raza);
                tvhDescripcion.setText(heroe.descripcion);
                tvhFuerza.setText(heroe.fuerza);
                tvhDefensa.setText(heroe.defensa);
                tvhVida.setText(heroe.vida);
                tvhEvasion.setText(heroe.evasion);
                tvhAgilidad.setText(heroe.agilidad);
                tvhMana.setText(heroe.mana);
                tvhMagia.setText(heroe.magia);
                tvhinventario.setText(heroe.inventario);
                tvhHabilidades.setText(heroe.habilidades);
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                heroeViewModel.deleteHeroe(id);
                onDestroy();
            }
        });
    }


}
