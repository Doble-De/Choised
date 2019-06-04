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

public class CastilloDialog {

    TextView name, texto;
    ImageView pj, npc, next;
    Button opcion1, opcion2;
    int cont = 1, cont2 = 1;
    boolean decirlo=false, pasar = false, carta=false, sincarta=false;
    String [] historia= {"¡Alto ahí!","Eiiii, cuidado con esa espada","Soy la Ley, cuidado conmigo eh","Sisi tranquilo...","*pensaría:* este viejo esta loco"};
    String [] aviso={"*el anciano estaría un poco en babia*","Ehhh... Hola.","Eh eh eh ah sisi","Soy la Ley, as...", "Si si, ya me sé el cuento...", "escucha tengo una cosa importante que decirte.","Seguro que no es tan importante"};
    String [] contarlo={"¡Si lo es!","He escuchado que esta noche van a matar al rey","hay que contárselo y ponerlo a salvo","Espera un momento...", "¿cres que me voy a creer todo eso?", "Es verdad juro que lo he escuchado","¿Pero acaso tienes pruebas?"};
    String [] nocontarlo={"Sii..., tienes razón no es para tanto", "Ya me lo imaginaba... Estos forasteros...", "Bueno me voy"};
    String [] sinpruebas={"Ehh... Pues no la verdad que no", "pero que lo he escuchado enserio","Claro que sí... Hummmm... Sospechoso", "En realidad solo te veo a ti hablando...", "Hablando de ¡MATAR AL REY!", "¿¡QUE!? Si osea pero porque lo he oído", "No me fio... !SOLDADOS¡", "¡NOOOO, SOLO QUERIA AVISAR!", "Estas detenido, serás encarcelado hasta nuevo aviso"};
    String [] conpruebas={"Pues sí, he encontrado esta carta en la cueva del bosque", "*le entrega la carta*","*la leería atentamente*","¡NO PUEDE SER!","¿El ministro quiere matar al rey?","Si, es lo que te estaba diciendo","Gracias por tus servicios al rey", "Se te recompensara"};

    public interface fin{
        void numerofin(int id);
    }
    private fin interfaz;

    public CastilloDialog(final Context context, fin actividad){

        interfaz = actividad;
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

        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.color.transparente);

        YoYo.with(Techniques.Flash)
                .duration(10000)
                .repeat(100)
                .playOn(next);

        name.setText("");
        if (!Protagonista.getAviso()){
            turnonpc();
            texto.setText(historia[0]);
        } else{
            texto.setText(aviso[0]);
        }

        opcion1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decirlo){
                    YoYo.with(Techniques.ZoomOut)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomOut)
                            .duration(500)
                            .playOn(opcion2);
                    opcion1.setVisibility(View.INVISIBLE);
                    opcion2.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);

                    carta = true;
                    decirlo = false;
                    cont2 = 1;
                    texto.setText(conpruebas[0]);
                }
                else {
                    YoYo.with(Techniques.ZoomOut)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomOut)
                            .duration(500)
                            .playOn(opcion1);
                    opcion1.setVisibility(View.INVISIBLE);
                    opcion2.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);

                    decirlo = true;
                    cont = 0;
                    texto.setText(contarlo[0]);
                }

            }
        });

        opcion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (decirlo){
                    YoYo.with(Techniques.ZoomOut)
                            .duration(1000)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomOut)
                            .duration(500)
                            .playOn(opcion2);
                    opcion1.setVisibility(View.INVISIBLE);
                    opcion2.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);

                    sincarta = true;
                    decirlo = false;
                    cont2 = 1;
                    texto.setText(sinpruebas[0]);
                }else {
                    YoYo.with(Techniques.ZoomOut)
                            .duration(500)
                            .playOn(opcion1);
                    YoYo.with(Techniques.ZoomOut)
                            .duration(1000)
                            .playOn(opcion2);
                    opcion1.setVisibility(View.INVISIBLE);
                    opcion2.setVisibility(View.INVISIBLE);
                    next.setVisibility(View.VISIBLE);

                    turnoprota();
                    pasar = true;
                    cont = 0;
                    texto.setText(nocontarlo[0]);
                }
            }
        });



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!Protagonista.getAviso()){
                    if (cont == historia.length) {
                        dialog.dismiss();
                    } else {
                        ponerTexto();
                        cont++;
                    }
                } else {
                    if (cont == aviso.length) {
                        texto.setText("");
                        turnoprota();
                        opcion1.setText("Contarle lo que has visto");
                        opcion2.setText("No creo que sea buena idea decirselo");
                        opcion1.setVisibility(View.VISIBLE);
                        opcion2.setVisibility(View.VISIBLE);
                        next.setVisibility(View.INVISIBLE);
                        YoYo.with(Techniques.ZoomIn)
                                .duration(1000)
                                .playOn(opcion1);
                        YoYo.with(Techniques.ZoomIn)
                                .duration(1200)
                                .playOn(opcion2);
                    } else if (decirlo) {
                        if ( cont2 == contarlo.length ){
                            texto.setText("");
                            turnoprota();
                            opcion1.setText("Claro que tengo");
                            opcion2.setText("Pues no");
                            opcion1.setVisibility(View.VISIBLE);
                            opcion2.setVisibility(View.VISIBLE);
                            next.setVisibility(View.INVISIBLE);
                            if (Protagonista.getCarta()) {
                                opcion1.setEnabled(true);
                            }else {
                                opcion1.setEnabled(false);
                            }

                            YoYo.with(Techniques.ZoomIn)
                                    .duration(1000)
                                    .playOn(opcion1);
                            YoYo.with(Techniques.ZoomIn)
                                    .duration(1200)
                                    .playOn(opcion2);
                        } else{
                            rutaContar();
                        }
                        cont2++;
                    } else if (pasar){
                        if ( cont2 == nocontarlo.length ){
                            dialog.dismiss();
                            Protagonista.setCarniceria(false);
                        } else{
                            rutaPasar();
                        }
                        cont2++;
                    } else if (carta){
                        if ( cont2 == conpruebas.length ){
                            interfaz.numerofin(2);
                            dialog.dismiss();
                        } else{
                            rutaPruebas();
                        }
                        cont2++;
                    } else if (sincarta){
                        if ( cont2 == sinpruebas.length ){
                            interfaz.numerofin(3);
                            dialog.dismiss();
                        } else{
                            rutaSinPruebas();
                        }
                        cont2++;
                    }
                    else {
                        rutaAviso();
                        cont++;
                    }
                }

            }
        });

        dialog.show();
    }

    public void ponerTexto(){
        switch (cont){
            case 1:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 2:
                texto.setText(historia[cont]);
                turnonpc();
                break;
            case 3:
                texto.setText(historia[cont]);
                turnoprota();
                break;
            case 4:
                texto.setText(historia[cont]);
                break;
        }
    }

    void rutaAviso(){
        switch (cont){
            case 1:
                texto.setText(aviso[cont]);
                turnoprota();
                break;
            case 2:
                texto.setText(aviso[cont]);
                turnonpc();
                break;
            case 3:
                texto.setText(aviso[cont]);
                break;
            case 4:
                texto.setText(aviso[cont]);
                turnoprota();
                break;
            case 5:
                texto.setText(aviso[cont]);
                break;
            case 6:
                texto.setText(aviso[cont]);
                turnonpc();
                break;
        }
    }

    void rutaPasar(){
        switch (cont2) {
            case 1:
                texto.setText(nocontarlo[cont2]);
                turnonpc();
                break;
            case 2:
                texto.setText(nocontarlo[cont2]);
                turnoprota();
                break;
        }
    }

    void rutaContar(){
        switch (cont2){
            case 1:
                texto.setText(contarlo[cont2]);
                break;
            case 2:
                texto.setText(contarlo[cont2]);
                break;
            case 3:
                texto.setText(contarlo[cont2]);
                turnonpc();
                break;
            case 4:
                texto.setText(contarlo[cont2]);
                break;
            case 5:
                texto.setText(contarlo[cont2]);
                turnoprota();
                break;
            case 6:
                texto.setText(contarlo[cont2]);
                turnonpc();
                break;
        }

    }

    void rutaSinPruebas(){
        switch (cont2){
            case 1:
                texto.setText(sinpruebas[cont2]);
                break;
            case 2:
                texto.setText(sinpruebas[cont2]);
                turnonpc();
                break;
            case 3:
                texto.setText(sinpruebas[cont2]);
                break;
            case 4:
                texto.setText(sinpruebas[cont2]);
                break;
            case 5:
                texto.setText(sinpruebas[cont2]);
                turnoprota();
                break;
            case 6:
                texto.setText(sinpruebas[cont2]);
                turnonpc();
                break;
            case 7:
                texto.setText(sinpruebas[cont2]);
                turnoprota();
                break;
            case 8:
                texto.setText(sinpruebas[cont2]);
                turnonpc();
                break;
        }

    }

    void rutaPruebas(){
        switch (cont2){
            case 1:
                texto.setText(conpruebas[cont2]);
                turnoprota();
                break;
            case 2:
                texto.setText(conpruebas[cont2]);
                turnonpc();
                break;
            case 3:
                texto.setText(conpruebas[cont2]);
                turnonpc();
                break;
            case 4:
                texto.setText(conpruebas[cont2]);
                break;
            case 5:
                texto.setText(conpruebas[cont2]);
                turnoprota();
                break;
            case 6:
                texto.setText(conpruebas[cont2]);
                turnonpc();
                break;
            case 7:
                texto.setText(conpruebas[cont2]);
                break;
        }

    }


    void imagenProta(){
        switch (Protagonista.getImagen()){
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


    void turnoprota(){
        npc.setImageResource(R.color.transparente);
        name.setText(Protagonista.getNombre());
        imagenProta();
    }

    void turnonpc(){
        pj.setImageResource(R.color.transparente);
        npc.setImageResource(R.drawable.viejo_caballero);
        if (Protagonista.getAviso()){
            name.setText("Anciano Pluriempleado");
        }else {
            name.setText("Anciando Caballero");
        }

    }

}
