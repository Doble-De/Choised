package com.dalealdado.choised.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.dalealdado.choised.DADViewModel;
import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.dalealdado.R;

public class EnemigosNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemigos_new);

        final DADViewModel enemigoViewModel = ViewModelProviders.of(this).get(DADViewModel.class);
        findViewById(R.id.guardar).setOnClickListener(new View.OnClickListener() {

            EditText Enombre = findViewById(R.id.etEnombre);
            EditText Eraza = findViewById(R.id.etEraza);
            EditText Edesc = findViewById(R.id.etEdesc);
            EditText Evida = findViewById(R.id.etEvida);
            EditText Efuerza = findViewById(R.id.etEfuerza);
            EditText Edefensa = findViewById(R.id.etEdefensa);
            EditText Eevasion = findViewById(R.id.etEevasion);
            EditText Eagilidad = findViewById(R.id.etEagilidad);
            EditText Emana = findViewById(R.id.etEmana);
            EditText Emagia = findViewById(R.id.etEmagia);
            EditText Ehabilidades = findViewById(R.id.etEhabilidades);
            EditText Edrop = findViewById(R.id.etdrop);

            @Override
            public void onClick(View v) {

                Enemigo enemigo = new Enemigo();

                enemigo.nombre = Enombre.getText().toString();
                enemigo.raza = Eraza.getText().toString();
                enemigo.descripcion = Edesc.getText().toString();
                enemigo.vida = Evida.getText().toString();
                enemigo.fuerza = Efuerza.getText().toString();
                enemigo.defensa = Edefensa.getText().toString();
                enemigo.evasion = Eevasion.getText().toString();
                enemigo.agilidad = Eagilidad.getText().toString();
                enemigo.mana = Emana.getText().toString();
                enemigo.magia = Emagia.getText().toString();
                enemigo.habilidades = Ehabilidades.getText().toString();
                enemigo.drop = Edrop.getText().toString();

                enemigoViewModel.insertEnemigo(enemigo);
                finish();
            }
        });
    }
}
