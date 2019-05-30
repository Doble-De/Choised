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

public class ArmeriaDialog {

    ImageButton salir;
    CardView espada, escudo;
    TextView text1, text2, text3, text1_2, text2_2, text3_2, dinero;
    int restDinero;

    public ArmeriaDialog(final Context context){
        final Dialog dialog = new Dialog(context);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.TOP);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_armeria_dialog);

        espada = dialog.findViewById(R.id.espada);
        escudo = dialog.findViewById(R.id.escudo);
        text1 = dialog.findViewById(R.id.text1);
        text2 = dialog.findViewById(R.id.text2);
        text3 = dialog.findViewById(R.id.text3);
        text1_2 = dialog.findViewById(R.id.text1_2);
        text2_2 = dialog.findViewById(R.id.text2_2);
        text3_2 = dialog.findViewById(R.id.text3_2);
        dinero = dialog.findViewById(R.id.dinero);
        salir = dialog.findViewById(R.id.salir);

        dinero.setText(Protagonista.getDinero()+ "");

        espada.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (Protagonista.getDinero() >= 15) {
                    System.out.println(Protagonista.getDinero());
                    text1.setText("VENDIDO");
                    text1.setTextColor(R.color.azulflojo);
                    text2.setText("");
                    text3.setText("");
                    espada.setBackgroundColor(R.color.colorAccent);
                    restDinero = Protagonista.getDinero() - 15;
                    Protagonista.setDinero(restDinero);
                    dinero.setText(Protagonista.getDinero()+ "");
                }
                else {
                    Toast.makeText(context, "No tienes suficiente dinero para comprar ese objeto.",Toast.LENGTH_SHORT);
                    System.out.println("No tienes suficiente dinero");
                }
            }
        });

        escudo.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (Protagonista.getDinero() >= 10) {
                    text1_2.setText("VENDIDO");
                    text1_2.setTextColor(R.color.azulflojo);
                    text2_2.setText("");
                    text3_2.setText("");
                    escudo.setBackgroundColor(R.color.botonescenario);
                    restDinero = Protagonista.getDinero() - 10;
                    Protagonista.setDinero(restDinero);
                    dinero.setText(Protagonista.getDinero()+ "");
                }
                else {
                    Toast.makeText(context, "No tienes suficiente dinero para comprar ese objeto.",Toast.LENGTH_SHORT);
                    System.out.println("No tienes suficiente dinero");
                }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
