package com.dalealdado.choised.view.Aventura;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.view.MainActivity;
import com.dalealdado.choised.model.Bandido;
import com.dalealdado.choised.model.Cazador;
import com.dalealdado.choised.model.Jabali;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.choised.shake.ShakeDetector;
import com.dalealdado.choised.view.Aventura.Dialogs.FinalCombate;
import com.dalealdado.choised.view.Aventura.Dialogs.ModalDado;
import com.dalealdado.choised.view.Aventura.Dialogs.ModalInventario;
import com.dalealdado.dalealdado.R;

import java.util.Random;

public class BatallasActivity extends AppCompatActivity implements ModalDado.MostrarResultado, ModalInventario.ObjetoUsado, FinalCombate.Volver {

    private Handler mHandler = new Handler();
    Context context;
    TextView resultado, resultadoe, vidarestante;
    int num = 0, tirada;
    ImageView corte, tirodado, bocadillo, escudo, defensahit, enemigo, personaje, estados;
    ProgressBar barravida;
    Button ataque, defensa, huida, objetos;
    String accion, tipodeEnemigo, activityAntigua;
    String [] enemigosPosibles = {"Jabali", "Cazador", "Bandido"};
    String [] activitysPosibles ={"Bosque1", "Bosque2","Bosque3", "Bosque4", "Bosque5", "Bosque6"};
    MediaPlayer mp, mp2, mp3, mp4, heal, fire, firehit;
    int contador = 1;
    Random random = new Random();
    Jabali jabali;
    Cazador cazador;
    Bandido bandido;
    private SensorManager mSensorManager;
    private Sensor mAccelerometrer;
    private ShakeDetector mShakeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_batallas);
        mp = MediaPlayer.create(this, R.raw.slash8);
        mp2 = MediaPlayer.create(this, R.raw.escudo2);
        mp3 = MediaPlayer.create(this, R.raw.escudo);
        mp4 = MediaPlayer.create(this, R.raw.gallina);
        heal = MediaPlayer.create(this, R.raw.heal);
        fire = MediaPlayer.create(this, R.raw.fuego);
        firehit = MediaPlayer.create(this, R.raw.firehit);
        context = this;

        tipodeEnemigo = getIntent().getStringExtra("tipo");
        activityAntigua = getIntent().getStringExtra("activity");

        personaje = findViewById(R.id.personaje);
        enemigo = findViewById(R.id.enemigo);
        bocadillo = findViewById(R.id.bocadillo);
        tirodado = findViewById(R.id.gifdado);
        ataque = (Button) findViewById(R.id.ataque);
        defensa = (Button) findViewById(R.id.defensa);
        huida = (Button) findViewById(R.id.huir);
        objetos = (Button) findViewById(R.id.objeto);
        resultado = (TextView) findViewById(R.id.valor);
        resultadoe = (TextView) findViewById(R.id.valore);
        vidarestante = findViewById(R.id.vidarest);
        barravida = findViewById(R.id.barravida);
        bocadillo.setImageResource(R.color.transparente);
        tirodado.setImageResource(R.color.transparente);
        mSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mAccelerometrer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        barravida.setMax(Protagonista.getVidaMaxima());
        barravida.setProgress(Protagonista.getVidaMaxima()-Protagonista.getVida());
        imagenProta();
        vidarestante.setText(String.valueOf(Protagonista.getVidaMaxima()-Protagonista.getVida()+" / "+Protagonista.getVidaMaxima()));
        if (tipodeEnemigo.equals(enemigosPosibles[0])){
            enemigo.setImageResource(R.drawable.jabali);
            jabali = new Jabali();
        } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
            enemigo.setImageResource(R.drawable.cazador);
            cazador = new Cazador();
        } else if (tipodeEnemigo.equals(enemigosPosibles[2])){
            enemigo.setImageResource(R.drawable.bandido);
            bandido = new Bandido();
        }

        defensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "defensa";
                new ModalDado(context, mShakeDetector, "defensa", BatallasActivity.this);
            }
        });

        ataque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "ataque";
                new ModalDado(context, mShakeDetector, "ataque", BatallasActivity.this);
            }
        });

        huida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accion = "huida";
                new ModalDado(context, mShakeDetector, "huida", BatallasActivity.this);
            }
        });

        objetos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ModalInventario(context, BatallasActivity.this);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mShakeDetector, mAccelerometrer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(mShakeDetector);
    }

    @Override
    public void ResultadoDado(String valor) {
        resultado.setText(valor);
        num = Integer.parseInt(valor);
        YoYo.with(Techniques.ZoomInUp)
                .duration(400)
                .playOn(resultado);
        AnimaciónPegar();
        AnimaciónDefender();
        AnimacionHuida();
    }

    // Golpear y sus animaciones

    public void AnimaciónPegar() {
        corte = (ImageView) findViewById(R.id.animataque);
        if (num <= 5 && accion.equals("ataque")) {
            corte.setImageResource(R.drawable.tajo);
            YoYo.with(Techniques.ZoomInLeft)
                    .duration(1000)
                    .playOn(corte);
            mHandler.postDelayed(sonidotajo, 460);
            YoYo.with(Techniques.ZoomOut)
                    .duration(3000)
                    .playOn(corte);

            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                jabali.setVida(jabali.getVida() - random.nextInt(4)+1);
            }else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                cazador.setVida(cazador.getVida() - random.nextInt(4)+1);
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])) {
                bandido.setVida(bandido.getVida() - random.nextInt(4)+1);
            }

        }else if (num > 5 && num <=17 && accion.equals("ataque")) {
            corte.setImageResource(R.drawable.tajo);
            YoYo.with(Techniques.ZoomInLeft)
                    .duration(1000)
                    .playOn(corte);
            mHandler.postDelayed(sonidotajo, 460);
            YoYo.with(Techniques.ZoomOut)
                    .duration(3000)
                    .playOn(corte);

            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                jabali.setVida(jabali.getVida() - Protagonista.getFuerza());
            }else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                cazador.setVida(cazador.getVida() - Protagonista.getFuerza());
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])) {
                bandido.setVida(bandido.getVida() - Protagonista.getFuerza());
            }

        }else if (num > 17 && accion.equals("ataque")) {
            corte.setImageResource(R.drawable.tajo);
            YoYo.with(Techniques.ZoomInLeft)
                    .duration(1000)
                    .playOn(corte);
            mHandler.postDelayed(sonidotajo, 460);
            YoYo.with(Techniques.ZoomOut)
                    .duration(3000)
                    .playOn(corte);
            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                jabali.setVida(jabali.getVida() - Protagonista.getFuerza()  * 2);
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                cazador.setVida(cazador.getVida() - Protagonista.getFuerza()* 2);
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])){
                bandido.setVida(bandido.getVida() - Protagonista.getFuerza()* 2);
            }

        }

    }

    private Runnable sonidotajo = new Runnable() {
        @Override
        public void run() {
            enemigo = (ImageView) findViewById(R.id.enemigo);
            mp.start();
            YoYo.with(Techniques.Wobble)
                    .duration(200)
                    .playOn(enemigo);

            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                if (jabali.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                    Protagonista.setCarne(Protagonista.getCarne()+1);
                    if(Protagonista.getCarne() == 6){
                        Protagonista.setJabali(true);
                    }
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                if (cazador.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])){
                if (bandido.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                }
            }



        }
    };

    // Defender y sus animaciones

    public void AnimaciónDefender() {
        escudo = (ImageView) findViewById(R.id.escudo);
        defensahit = (ImageView) findViewById(R.id.animdefensa);
        if (num > 5 && accion.equals("defensa")) {
            escudo.setImageResource(R.drawable.escudo);
            YoYo.with(Techniques.StandUp)
                    .duration(500)
                    .playOn(escudo);
            mp2.start();
            mHandler.postDelayed(golpesDefensa, 450);
            mHandler.postDelayed(golpesDefensa, 600);
            mHandler.postDelayed(golpesDefensa, 850);
            mHandler.postDelayed(golpesDefensa, 1000);


        } else if (num <= 5 && accion.equals("defensa")){
            turnoEnemigo();
        }
    }

    private Runnable golpesDefensa = new Runnable() {
        @Override
        public void run() {
            defensahit = (ImageView) findViewById(R.id.animdefensa);
            switch (contador) {
                case 1:
                    defensahit.setImageResource(R.drawable.defensehit1);
                    contador++;
                    YoYo.with(Techniques.Flash)
                            .duration(300)
                            .playOn(defensa);
                    break;
                case 2:
                    defensahit.setImageResource(R.drawable.defensehit2);
                    YoYo.with(Techniques.Flash)
                            .duration(300)
                            .playOn(defensa);
                    contador++;
                    mp3.start();
                    break;
                case 3:
                    defensahit.setImageResource(R.drawable.defensehit3);
                    YoYo.with(Techniques.Flash)
                            .duration(300)
                            .playOn(defensa);
                    contador++;
                    break;
                case 4:
                    defensahit.setImageResource(R.color.transparente);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(escudo);
                    contador = 1;
                    break;
            }


        }
    };

    // Huida

    public void AnimacionHuida() {

        if (num > 5 && accion.equals("huida")) {
            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                if (jabali.getAgilidad() < Protagonista.getAgilidad()){
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                }
                else{
                    turnoEnemigo();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                if (cazador.getAgilidad() < Protagonista.getAgilidad()){
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                }
                else{
                    turnoEnemigo();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])){
                if (bandido.getAgilidad() < Protagonista.getAgilidad()){
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                }
                else{
                    turnoEnemigo();
                }
            }

        }else if (num > 15 && accion.equals("huida")) {
            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                if (jabali.getAgilidad() < Protagonista.getAgilidad()*2){
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                }
                else{
                    turnoEnemigo();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                if (cazador.getAgilidad() < Protagonista.getAgilidad()*2){
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                }
                else{
                    turnoEnemigo();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])) {
                if (bandido.getAgilidad() < Protagonista.getAgilidad()*2) {
                    personaje = (ImageView) findViewById(R.id.personaje);
                    personaje.animate().rotationY(180).start();
                    mp4.start();
                    YoYo.with(Techniques.Bounce)
                            .duration(200)
                            .playOn(personaje);
                    YoYo.with(Techniques.FadeOutLeft)
                            .duration(1000)
                            .playOn(personaje);
                    mHandler.postDelayed(huidaexitosa, 1000);
                } else {
                    turnoEnemigo();
                }
            }
        }
    }

    private Runnable huidaexitosa = new Runnable() {
        @Override
        public void run() {
            volverPantalla();
        }
    };


    //Inventatio y sus animaciones

    @Override
    public void IdObjeto(int id) {
        if (id == 1) {
            mHandler.postDelayed(AnimacionCura, 100);
            mHandler.postDelayed(AnimacionCura, 400);
            mHandler.postDelayed(AnimacionCura, 1000);
            mHandler.postDelayed(AnimacionCura, 1300);
            if (Protagonista.getVida() < 20){
                int curarrestante = Protagonista.getVida();
                Protagonista.setVida(Protagonista.getVida() - curarrestante);
            }else {
                Protagonista.setVida(Protagonista.getVida() - 35);
            }
            vidarestante.setText(String.valueOf(Protagonista.getVidaMaxima()-Protagonista.getVida()+" / "+Protagonista.getVidaMaxima()));
            barravida.setProgress(Protagonista.getVidaMaxima()-Protagonista.getVida());
            turnoEnemigo();
        } else if (id == 2) {
            corte = (ImageView) findViewById(R.id.animataque);
            fire.start();
            corte.setImageResource(R.drawable.fuego);
            YoYo.with(Techniques.ZoomInLeft)
                    .duration(1000)
                    .playOn(corte);
            mHandler.postDelayed(sonidofirehit, 460);
            YoYo.with(Techniques.ZoomOut)
                    .duration(3000)
                    .playOn(corte);

            if (tipodeEnemigo.equals(enemigosPosibles[0]) && jabali.getVida() <=0){
                jabali.setVida(jabali.getVida() - Protagonista.getMagia()+20);
            } else if (tipodeEnemigo.equals(enemigosPosibles[1]) && jabali.getVida() <=0){
                cazador.setVida(cazador.getVida() - Protagonista.getMagia()+20);
            }else if (tipodeEnemigo.equals(enemigosPosibles[2]) && jabali.getVida() <=0){
                bandido.setVida(bandido.getVida() - Protagonista.getMagia()+20);
            }

        }
    }

    private Runnable sonidofirehit = new Runnable() {
        @Override
        public void run() {
            enemigo = (ImageView) findViewById(R.id.enemigo);
            corte.setImageResource(R.drawable.fuegohit);
            firehit.start();
            YoYo.with(Techniques.Wobble)
                    .duration(200)
                    .playOn(enemigo);


            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                if (jabali.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                    Protagonista.setCarne(Protagonista.getCarne()+1);
                    if(Protagonista.getCarne() == 6){
                        Protagonista.setJabali(true);
                    }
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                if (cazador.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])){
                if (bandido.getVida() > 0){
                    turnoEnemigo();
                }else {
                    ganador();
                }
            }
        }
    };

    private Runnable AnimacionCura = new Runnable() {
        @Override
        public void run() {
            estados = (ImageView) findViewById(R.id.estados);

            switch (contador) {
                case 1:
                    estados.setImageResource(R.drawable.heal1);
                    contador++;
                    YoYo.with(Techniques.FadeInUp)
                            .duration(600)
                            .playOn(estados);
                    break;
                case 2:
                    estados.setImageResource(R.drawable.heal2);
                    heal.start();
                    YoYo.with(Techniques.Pulse)
                            .duration(600)
                            .playOn(estados);
                    contador++;
                    break;
                case 3:
                    estados.setImageResource(R.drawable.heal3);
                    YoYo.with(Techniques.Pulse)
                            .duration(400)
                            .playOn(estados);
                    contador++;
                    break;
                case 4:
                    estados.setImageResource(R.drawable.heal3);
                    YoYo.with(Techniques.FadeOutDown)
                            .duration(800)
                            .playOn(estados);
                    contador = 1;
                    break;
            }
        }
    };


    // Enemigo Hit

    void turnoEnemigo() {
        ataque.setEnabled(false);
        defensa.setEnabled(false);
        huida.setEnabled(false);
        objetos.setEnabled(false);

        mHandler.postDelayed(mostrarItems, 2000);
        mHandler.postDelayed(tiradaEnemigo, 5000);
        mHandler.postDelayed(animationPegarEnemigos, 6000);
        //AnimaciónPegarEnemigo();

    }

    private Runnable mostrarItems = new Runnable() {
        @Override
        public void run() {
            bocadillo.setImageResource(R.drawable.bocadillo);
            tirodado.setImageResource(R.drawable.dado);

        }
    };

    private Runnable tiradaEnemigo = new Runnable() {
        @Override
        public void run() {
            tirada = random.nextInt(20)+ 1;
            resultadoe.setText(String.valueOf(tirada));
            YoYo.with(Techniques.ZoomInUp)
                    .duration(400)
                    .playOn(resultadoe);
            bocadillo.setImageResource(R.color.transparente);
            tirodado.setImageResource(R.color.transparente);
        }
    };

    private Runnable animationPegarEnemigos = new Runnable() {
        @Override
        public void run() {
            estados = (ImageView) findViewById(R.id.estados);
                estados.setImageResource(R.drawable.tajoe);
                YoYo.with(Techniques.ZoomInRight)
                        .duration(1000)
                        .playOn(estados);
                mHandler.postDelayed(sonidotajoe, 460);
                YoYo.with(Techniques.ZoomOut)
                        .duration(3000)
                        .playOn(estados);


            ataque.setEnabled(true);
            defensa.setEnabled(true);
            huida.setEnabled(true);
            objetos.setEnabled(true);

        }
    };

    private Runnable sonidotajoe = new Runnable() {
        @Override
        public void run() {
            personaje = (ImageView) findViewById(R.id.personaje);
            mp.start();
            YoYo.with(Techniques.Wobble)
                    .duration(200)
                    .playOn(personaje);


            if (tipodeEnemigo.equals(enemigosPosibles[0])) {
                if (tirada<=5) {
                    Protagonista.setVida(Protagonista.getVida() + random.nextInt(4)+1);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                            derrota();
                    }
                } else if (tirada <= 17){
                    Protagonista.setVida(Protagonista.getVida() + jabali.getFuerza());
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                } else {
                    Protagonista.setVida(Protagonista.getVida() + jabali.getFuerza()*2);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[1])){
                if (tirada<=5) {
                    Protagonista.setVida(Protagonista.getVida() + random.nextInt(4)+1);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                } else if (tirada <= 17){
                    Protagonista.setVida(Protagonista.getVida() + cazador.getFuerza());
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                } else {
                    Protagonista.setVida(Protagonista.getVida() + cazador.getFuerza()*2);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                }
            } else if (tipodeEnemigo.equals(enemigosPosibles[2])) {
                if (tirada<=5) {
                    Protagonista.setVida(Protagonista.getVida() + random.nextInt(4)+1);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                } else if (tirada <= 17){
                    Protagonista.setVida(Protagonista.getVida() + bandido.getFuerza());
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                } else {
                    Protagonista.setVida(Protagonista.getVida() + bandido.getFuerza()*2);
                    if (Protagonista.getVida() >= Protagonista.getVidaMaxima()){
                        derrota();
                    }
                }
                }
            barravida.setProgress(Protagonista.getVidaMaxima()-Protagonista.getVida());
            vidarestante.setText(String.valueOf(Protagonista.getVidaMaxima()-Protagonista.getVida()+" / "+Protagonista.getVidaMaxima()));
        }
    };

    void imagenProta(){
        switch (Protagonista.getImagen()){
            case 1:
                personaje.setImageResource(R.drawable.pm1);
                break;
            case 2:
                personaje.setImageResource(R.drawable.pm2);
                break;
            case 3:
                personaje.setImageResource(R.drawable.pm3);
                break;
            case 4:
                personaje.setImageResource(R.drawable.pm4);
                break;
            case 5:
                personaje.setImageResource(R.drawable.pf1);
                break;
            case 6:
                personaje.setImageResource(R.drawable.pf2);
                break;
            case 7:
                personaje.setImageResource(R.drawable.pf3);
                break;
            case 8:
                personaje.setImageResource(R.drawable.pf4);
                break;
        }
    }

    void ganador(){

        if (tipodeEnemigo.equals(enemigosPosibles[0]) && jabali.getVida() <=0){
            new FinalCombate(context, 0,jabali.getDinero(),BatallasActivity.this);
        } else if (tipodeEnemigo.equals(enemigosPosibles[1]) && cazador.getVida() <=0){
            new FinalCombate(context, 1,cazador.getDinero(),BatallasActivity.this);
        }else if (tipodeEnemigo.equals(enemigosPosibles[2]) && bandido.getVida() <=0){
            new FinalCombate(context, 1,bandido.getDinero(),BatallasActivity.this);
        }
    }

    void derrota(){

            new FinalCombate(context, 2,0,BatallasActivity.this);
    }

    @Override
    public void continuarAventura(String valor) {
        if (valor.equals("win")){
            volverPantalla();
        }else if (valor.equals("derrota")){
            startActivity(new Intent(context, MainActivity.class));
        }
    }

    void volverPantalla(){
        if (activityAntigua.equals(activitysPosibles[0])){
            startActivity(new Intent(context, Bosque1.class));
        } else if (activityAntigua.equals(activitysPosibles[1])){
            startActivity(new Intent(context, Bosque2.class));
        }else if (activityAntigua.equals(activitysPosibles[2])){
            startActivity(new Intent(context, Bosque3.class));
        }else if (activityAntigua.equals(activitysPosibles[3])){
            startActivity(new Intent(context, Bosque4.class));
        }else if (activityAntigua.equals(activitysPosibles[4])){
            startActivity(new Intent(context, Bosque5.class));
        }else if (activityAntigua.equals(activitysPosibles[5])){
            startActivity(new Intent(context, Bosque6.class));
        }
    }
}
