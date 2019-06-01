package com.dalealdado.choised.view;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.dalealdado.choised.DADViewModel;
import com.dalealdado.dalealdado.R;

public class EnemigosModifActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enemigos_modif);

        final DADViewModel enemigoViewModel = ViewModelProviders.of(this).get(DADViewModel.class);

        EditText Enombre = findViewById(R.id.etEMnombre);
        EditText Eraza = findViewById(R.id.etEMraza);
        EditText Edesc = findViewById(R.id.etEMdesc);
        EditText Evida = findViewById(R.id.etEMvida);
        EditText Efuerza = findViewById(R.id.etEMfuerza);
        EditText Edefensa = findViewById(R.id.etEMdefensa);
        EditText Eevasion = findViewById(R.id.etEMevasion);
        EditText Eagilidad = findViewById(R.id.etEMagilidad);
        EditText Emana = findViewById(R.id.etEMmana);
        EditText Emagia = findViewById(R.id.etEMmagia);
        EditText Ehabilidades = findViewById(R.id.etEMhabilidades);
        EditText Edrop = findViewById(R.id.etMdrop);

        final String id = getIntent().getStringExtra("id");
        final String nombre = getIntent().getStringExtra("nombre");
        final String raza = getIntent().getStringExtra("raza");
        final String desc = getIntent().getStringExtra("descripcion");
        final String vida = getIntent().getStringExtra("vida");
        final String fuerza = getIntent().getStringExtra("fuerza");
        final String defensa = getIntent().getStringExtra("defensa");
        final String evasion = getIntent().getStringExtra("evasion");
        final String agilidad = getIntent().getStringExtra("agilidad");
        final String magia = getIntent().getStringExtra("magia");
        final String mana = getIntent().getStringExtra("mana");
        final String hab = getIntent().getStringExtra("habi");
        final String drop = getIntent().getStringExtra("drop");


        Enombre.setText(nombre);
        Eraza.setText(raza);
        Edesc.setText(desc);
        Evida.setText(vida);
        Efuerza.setText(fuerza);
        Edefensa.setText(defensa);
        Eevasion.setText(evasion);
        Eagilidad.setText(agilidad);
        Emagia.setText(magia);
        Emana.setText(mana);
        Ehabilidades.setText(hab);
        Edrop.setText(drop);


//        findViewById(R.id.guardarM).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Enemigo enemigos = Enemigo;
//                enemigos.nombre = Enombre.getText().toString();
//                enemigos.raza = Eraza.getText().toString();
//                enemigos.descripcion = Edesc.getText().toString();
//                enemigos.vida = Evida.getText().toString();
//                enemigos.fuerza = Efuerza.getText().toString();
//                enemigos.defensa = Edefensa.getText().toString();
//                enemigos.evasion = Eevasion.getText().toString();
//                enemigos.agilidad = Eagilidad.getText().toString();
//                enemigos.mana = Emana.getText().toString();
//                enemigos.magia = Emagia.getText().toString();
//                enemigos.habilidades = Ehabilidades.getText().toString();
//                enemigos.drop = Edrop.getText().toString();
//
//                enemigoViewModel.insertEnemigo(enemigos);
//                finish();
//            }
//        });


    }
}
