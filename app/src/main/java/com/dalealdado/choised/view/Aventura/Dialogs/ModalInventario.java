package com.dalealdado.choised.view.Aventura.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dalealdado.choised.model.Protagonista;
import com.dalealdado.dalealdado.R;

public class ModalInventario {

    int[] item, cantidad;
    ImageView ivitem1, ivitem2, ivitem3, ivitem4, ivitem5, ivitem6, ivitem7, ivitem8, ivitem9;
    TextView cant1, cant2, cant3, cant4, cant5, cant6, cant7, cant8, cant9;
    Button salir;



    public interface ObjetoUsado{
        void IdObjeto(int id);
    }

    private ObjetoUsado interfaz;

    public ModalInventario (Context context, ObjetoUsado actividad){

        interfaz = actividad;
        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_modal_inventario);
        salir = dialog.findViewById(R.id.exit);
        item = Protagonista.getInventario();
        cantidad = Protagonista.getCantidad();


        ivitem1 = (ImageView) dialog.findViewById(R.id.item1);
        ivitem2 = (ImageView) dialog.findViewById(R.id.item2);
        ivitem3 = (ImageView) dialog.findViewById(R.id.item3);
        ivitem4 = (ImageView) dialog.findViewById(R.id.item4);
        ivitem5 = (ImageView) dialog.findViewById(R.id.item5);
        ivitem6 = (ImageView) dialog.findViewById(R.id.item6);
        ivitem7 = (ImageView) dialog.findViewById(R.id.item7);
        ivitem8 = (ImageView) dialog.findViewById(R.id.item8);
        ivitem9 = (ImageView) dialog.findViewById(R.id.item9);
        cant1 = dialog.findViewById(R.id.cant1);
        cant2 = dialog.findViewById(R.id.cant2);
        cant3 = dialog.findViewById(R.id.cant3);
        cant4 = dialog.findViewById(R.id.cant4);
        cant5 = dialog.findViewById(R.id.cant5);
        cant6 = dialog.findViewById(R.id.cant6);
        cant7 = dialog.findViewById(R.id.cant7);
        cant8 = dialog.findViewById(R.id.cant8);
        cant9 = dialog.findViewById(R.id.cant9);

        PonerImagen();

        ivitem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.IdObjeto(item[0]);
                Protagonista.eliminarInventario(item[0]);
                dialog.dismiss();
            }
        });

        ivitem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaz.IdObjeto(item[1]);
                Protagonista.eliminarInventario(item[1]);
                dialog.dismiss();
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

    private void PonerImagen(){
        ImagenObjeto(item[0], ivitem1);
        ImagenObjeto(item[1], ivitem2);
        ImagenObjeto(item[2], ivitem3);
        ImagenObjeto(item[3], ivitem4);
        ImagenObjeto(item[4], ivitem5);
        ImagenObjeto(item[5], ivitem6);
        ImagenObjeto(item[6], ivitem7);
        ImagenObjeto(item[7], ivitem8);
        ImagenObjeto(item[8], ivitem9);
        cant1.setText(String.valueOf(cantidad[0]));
        cant2.setText(String.valueOf(cantidad[1]));
        cant3.setText(String.valueOf(cantidad[2]));
        cant4.setText(String.valueOf(cantidad[3]));
        cant5.setText(String.valueOf(cantidad[4]));
        cant6.setText(String.valueOf(cantidad[5]));
        cant7.setText(String.valueOf(cantidad[6]));
        cant8.setText(String.valueOf(cantidad[7]));
        cant9.setText(String.valueOf(cantidad[8]));
    }

    public void ImagenObjeto(int tipo, ImageView imageView){

        switch (tipo){
            case 0:
                imageView.setImageResource(R.drawable.empty);
                break;
            case 1:
                imageView.setImageResource(R.drawable.potion);
                break;
            case 2:
                imageView.setImageResource(R.drawable.librog);
                break;
            case 3:
                imageView.setImageResource(R.drawable.emblema);
        }
    }


}

