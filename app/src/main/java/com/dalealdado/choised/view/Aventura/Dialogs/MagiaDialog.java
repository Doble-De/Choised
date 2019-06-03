package com.dalealdado.choised.view.Aventura.Dialogs;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class MagiaDialog {

    ImageButton salir;
    CardView emblema, poti, tomo;
    TextView text1, text2, text3, text1_2, text2_2, text3_2, text1_3, text2_3, text3_3, dinero;
    int restDinero;

    public MagiaDialog(final Context context){
        final Dialog dialog = new Dialog(context);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.TOP);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_magia_dialog);

        emblema = dialog.findViewById(R.id.emblema);
        poti = dialog.findViewById(R.id.poti);
        tomo = dialog.findViewById(R.id.tomo);
        text1 = dialog.findViewById(R.id.text1);
        text2 = dialog.findViewById(R.id.text2);
        text3 = dialog.findViewById(R.id.text3);
        text1_2 = dialog.findViewById(R.id.text1_2);
        text2_2 = dialog.findViewById(R.id.text2_2);
        text3_2 = dialog.findViewById(R.id.text3_2);
        text1_3 = dialog.findViewById(R.id.text1_3);
        text2_3 = dialog.findViewById(R.id.text2_3);
        text3_3 = dialog.findViewById(R.id.text3_3);
        dinero = dialog.findViewById(R.id.dinero);
        salir = dialog.findViewById(R.id.salir);

        dinero.setText(Protagonista.getDinero()+ "");

        if (!Protagonista.getEmblema()){
            text1_3.setText("VENDIDO");
            text1_3.setTextColor(R.drawable.castillo);
            text2_3.setText("");
            text3_3.setText("");
            emblema.setBackgroundColor(R.drawable.castillo);
        }

        poti.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (Protagonista.getDinero() >= 5) {
                    System.out.println(Protagonista.getDinero());
                    //poti.setBackgroundColor(R.color.fondoCompra);
                    restDinero = Protagonista.getDinero() - 5;
                    Protagonista.setDinero(restDinero);
                    dinero.setText(Protagonista.getDinero()+ "");
                    Protagonista.añadirInventario(1);
                }
                else {
                    Toast.makeText(context, "No tienes suficiente dinero para comprar ese objeto.",Toast.LENGTH_SHORT);
                    //System.out.println("No tienes suficiente dinero");
                }
            }
        });

        tomo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (Protagonista.getDinero() >= 7) {
                    //tomo.setBackgroundColor(R.color.fondoCompra);
                    restDinero = Protagonista.getDinero() - 7;
                    Protagonista.setDinero(restDinero);
                    dinero.setText(Protagonista.getDinero()+ "");
                    Protagonista.añadirInventario(2);
                }
                else {
                    Toast.makeText(context, "No tienes suficiente dinero para comprar ese objeto.",Toast.LENGTH_SHORT);
                    //System.out.println("No tienes suficiente dinero");
                }
            }
        });

        if (Protagonista.getEmblema()){
            emblema.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (Protagonista.getDinero() >= 5) {
                        text1_2.setText("VENDIDO");
                        text1_2.setTextColor(R.color.azulflojo);
                        text2_2.setText("");
                        text3_2.setText("");
                        emblema.setBackgroundColor(R.color.botonescenario);
                        restDinero = Protagonista.getDinero() - 5;
                        Protagonista.setDinero(restDinero);
                        dinero.setText(Protagonista.getDinero()+ "");
                        Protagonista.añadirInventario(3);
                        Protagonista.setEmblema(false);
                    }
                    else {
                        Toast.makeText(context, "No tienes suficiente dinero para comprar ese objeto.",Toast.LENGTH_SHORT);
                        //System.out.println("No tienes suficiente dinero");
                    }
                }
            });
        }


        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
