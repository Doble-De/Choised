package com.dalealdado.choised.view.Aventura;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.dalealdado.dalealdado.R;

public class TablonActivity extends AppCompatActivity {

    ImageView hoja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablon);

        hoja = findViewById(R.id.hoja);

        hoja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TablonActivity.this, MisionActivity.class));
            }
        });

    }
}
