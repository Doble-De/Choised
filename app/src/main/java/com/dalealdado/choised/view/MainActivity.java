package com.dalealdado.choised.view;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dalealdado.choised.DadosActivity;
import com.dalealdado.choised.EscenariosActivity;
import com.dalealdado.choised.PersonajesActivity;
import com.dalealdado.choised.view.Aventura.TablonActivity;
import com.dalealdado.dalealdado.R;
import com.dalealdado.choised.view.Aventura.ProtagonistaActivity;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.minicio);
        mp.start();
        findViewById(R.id.bdados).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, DadosActivity.class) );
                mp.stop();
            }
        });
        findViewById(R.id.info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent (MainActivity.this, InfoActivity.class) );
                mp.stop();
            }
        });

        findViewById(R.id.bpersonajes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PersonajesActivity.class));
                mp.stop();
            }
        });

        findViewById(R.id.baventura).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TablonActivity.class));
                mp.stop();
            }
        });

        findViewById(R.id.bescenarios).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EscenariosActivity.class));
                mp.stop();
            }
        });
    }
}
