package com.dalealdado.choised.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.dalealdado.dalealdado.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        Glide.with(this).load(R.drawable.lobi).into((ImageView)findViewById(R.id.imagenlobi));
        Glide.with(this).load(R.drawable.dadosp).into((ImageView)findViewById(R.id.imagendados));
        Glide.with(this).load(R.drawable.escenarioslb).into((ImageView)findViewById(R.id.imagenescenarios));
        Glide.with(this).load(R.drawable.escenariosform).into((ImageView)findViewById(R.id.imagenaddescenarios));
        Glide.with(this).load(R.drawable.escenariosshow).into((ImageView)findViewById(R.id.imagenshowescenarios));
        Glide.with(this).load(R.drawable.heroes).into((ImageView)findViewById(R.id.imagenheroes));
        Glide.with(this).load(R.drawable.enemigos).into((ImageView)findViewById(R.id.imagenenemigos));
        Glide.with(this).load(R.drawable.heroesadd).into((ImageView)findViewById(R.id.imagenaddheroes));
        Glide.with(this).load(R.drawable.enemigosadd).into((ImageView)findViewById(R.id.imagenaddenemigos));
        Glide.with(this).load(R.drawable.heroesshow).into((ImageView)findViewById(R.id.imagenshowheroes));
        Glide.with(this).load(R.drawable.enemigosshow).into((ImageView)findViewById(R.id.imagenshowenemigos));
        Glide.with(this).load(R.drawable.botons).into((ImageView)findViewById(R.id.imagenbutons));
        Glide.with(this).load(R.drawable.tienda).into((ImageView)findViewById(R.id.imagenshop));
        Glide.with(this).load(R.drawable.cc).into((ImageView)findViewById(R.id.imagencc));
    }

}
