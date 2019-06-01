package com.dalealdado.choised.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dalealdado.choised.DADViewModel;
import com.dalealdado.choised.model.Heroe;
import com.dalealdado.dalealdado.R;

public class HeroesNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_new);

        final DADViewModel heroeViewModel = ViewModelProviders.of(this).get(DADViewModel.class);
        findViewById(R.id.guardar).setOnClickListener(new View.OnClickListener() {

            EditText Hnombre = findViewById(R.id.etnombre);
            EditText Hraza = findViewById(R.id.etraza);
            EditText Hdesc = findViewById(R.id.etdesc);
            EditText Hvida = findViewById(R.id.etvida);
            EditText Hfuerza = findViewById(R.id.etfuerza);
            EditText Hdefensa = findViewById(R.id.etdefensa);
            EditText Hevasion = findViewById(R.id.etevasion);
            EditText Hagilidad = findViewById(R.id.etagilidad);
            EditText Hmana = findViewById(R.id.etmana);
            EditText Hmagia = findViewById(R.id.etmagia);
            EditText Hhabilidades = findViewById(R.id.ethabilidades);
            EditText Hinventario = findViewById(R.id.etinventario);

            @Override
            public void onClick(View v) {

                Heroe heroe = new Heroe();

                heroe.nombre = Hnombre.getText().toString();
                heroe.raza = Hraza.getText().toString();
                heroe.descripcion = Hdesc.getText().toString();
                heroe.vida = Hvida.getText().toString();
                heroe.fuerza = Hfuerza.getText().toString();
                heroe.defensa = Hdefensa.getText().toString();
                heroe.evasion = Hevasion.getText().toString();
                heroe.agilidad = Hagilidad.getText().toString();
                heroe.mana = Hmana.getText().toString();
                heroe.magia = Hmagia.getText().toString();
                heroe.habilidades = Hhabilidades.getText().toString();
                heroe.inventario = Hinventario.getText().toString();

                heroeViewModel.insertHeroe(heroe);
                finish();

            }
        });
    }
}
