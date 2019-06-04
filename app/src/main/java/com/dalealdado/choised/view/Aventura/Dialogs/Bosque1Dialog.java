package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class Bosque1Dialog {

    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont = 1, cont2 = 0;
    boolean pagar = false, pelear= false;
    String[] historia = {"Vaya vaya...", "Parece que hay un intruso en mi bosque","¿Ehh? ¿Como que tu bosque?", "Como lo oyes, he vivido en este bosque toda mi vida","por lo tanto es mi bosque","Vaya lógica...","He visto que has estado cazando jabalíes","Si, para el carnicero de la ciudad","No me importa, o me pagas 20 de oro de comisión...","O lo vas a pasar mal","¿¡QUE!?"};
    String[] dinero = {"Bueno, toma...","HAS PERDIDO 20 DE ORO","JAJAJAJAJAJAJA","Así me gusta","gente que sepa lo que es de lo demás.","Quédate por aquí el tiempo que quieras", "ahora eres mi invitado","Ehh... Gracias supongo","Venga que vaya bien"};
    String[] pelea = {"No te voy a dar nada", "Te vas a arrepentir", "Ya veremos..."};


    public interface pelea{
        void lucha(int id);
    }
    private pelea interfaz;

    public Bosque1Dialog(final Context context, pelea actividad) {

        interfaz=actividad;
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_fuente_dialog);

        name = dialog.findViewById(R.id.name);
        texto = dialog.findViewById(R.id.texto);
        next = dialog.findViewById(R.id.next);
        pj = dialog.findViewById(R.id.personaje);
        npc = dialog.findViewById(R.id.npc);
        opcion1 = dialog.findViewById(R.id.opcion1);
        opcion2 = dialog.findViewById(R.id.opcion2);
        Protagonista.setBandido(true);

        turnonpc();
        texto.setText(historia[0]);

        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomOut)
                        .duration(1000)
                        .playOn(opcion1);
                YoYo.with(Techniques.ZoomOut)
                        .duration(500)
                        .playOn(opcion1);
                opcion1.setVisibility(View.INVISIBLE);
                opcion2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

                pagar = true;
                cont = 0;
                texto.setText(dinero[0]);
                Protagonista.setDinero(Protagonista.getDinero()-20);
                Protagonista.setPagado(true);
            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.ZoomOut)
                        .duration(500)
                        .playOn(opcion1);
                YoYo.with(Techniques.ZoomOut)
                        .duration(1000)
                        .playOn(opcion1);
                opcion1.setVisibility(View.INVISIBLE);
                opcion2.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);

                turnoprota();
                pelear = true;
                cont = 0;
                texto.setText(pelea[0]);
                Protagonista.setJabali(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (cont == historia.length) {
                    turnoprota();
                    texto.setText("");
                    if (Protagonista.getDinero() < 20){
                        opcion1.setEnabled(false);
                    }
                    opcion1.setText("Darle el Dinero");
                    opcion2.setText("No le voy a dar nada");
                    opcion1.setVisibility(View.VISIBLE);
                    opcion2.setVisibility(View.VISIBLE);
                    next.setVisibility(View.INVISIBLE);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomIn)
                            .duration(1200)
                            .playOn(opcion2);
                } else if (pagar) {
                    cont2++;
                    if (cont2 == dinero.length) {
                        interfaz.lucha(1);
                        dialog.dismiss();
                    } else {
                        rutaDinero();
                    }
                } else if (pelear) {
                    cont2++;
                    if (cont2 == pelea.length) {
                        interfaz.lucha(0);
                        dialog.dismiss();
                    } else {
                        rutaGo();
                    }
                } else {
                    ponerTexto();
                    cont++;
                }


            }
        });

        dialog.show();
    }

    public void ponerTexto() {

        switch (cont) {
            case 1:
                texto.setText(historia[cont]);
                break;
            case 2:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 3:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 4:
                texto.setText(historia[cont]);
                break;
            case 5:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 6:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 7:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 8:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 9:
                texto.setText(historia[cont]);
                break;
            case 10:
                texto.setText(historia[cont]);
                turnoprota();
                break;
        }
    }

    public void rutaDinero() {

        switch (cont2) {
            case 1:
                texto.setText(dinero[cont2]);
                pj.setImageResource(R.color.transparente);
                npc.setImageResource(R.color.transparente);
                name.setText("");
                break;
            case 2:
                texto.setText(dinero[cont2]);
                turnonpc();
                break;
            case 3:
                texto.setText(dinero[cont2]);
                break;
            case 4:
                texto.setText(dinero[cont2]);
                break;
            case 5:
                texto.setText(dinero[cont2]);
                break;
            case 6:
                texto.setText(dinero[cont2]);
                break;
            case 7:
                texto.setText(dinero[cont2]);
                turnoprota();
                break;
            case 8:
                texto.setText(dinero[cont2]);
                turnonpc();
                break;

        }

    }

    public void rutaGo() {
        switch (cont2) {
            case 1:
                texto.setText(pelea[cont2]);
                turnonpc();
                break;
            case 2:
                texto.setText(pelea[cont2]);
                turnoprota();
                break;
        }
    }

    void imagenProta() {
        switch (Protagonista.getImagen()) {
            case 1:
                pj.setImageResource(R.drawable.pm1);
                break;
            case 2:
                pj.setImageResource(R.drawable.pm2);
                break;
            case 3:
                pj.setImageResource(R.drawable.pm3);
                break;
            case 4:
                pj.setImageResource(R.drawable.pm4);
                break;
            case 5:
                pj.setImageResource(R.drawable.pf1);
                break;
            case 6:
                pj.setImageResource(R.drawable.pf2);
                break;
            case 7:
                pj.setImageResource(R.drawable.pf3);
                break;
            case 8:
                pj.setImageResource(R.drawable.pf4);
                break;
        }
    }

    void turnoprota() {
        npc.setImageResource(R.color.transparente);
        name.setText(Protagonista.getNombre());
        imagenProta();
    }

    void turnonpc() {
        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.drawable.cazador);
        name.setText("Cazador");
    }
}