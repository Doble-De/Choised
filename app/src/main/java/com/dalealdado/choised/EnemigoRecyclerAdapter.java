package com.dalealdado.choised;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.dalealdado.R;
import com.dalealdado.choised.view.EnemigosShowActivity;

import java.util.List;

public class EnemigoRecyclerAdapter extends RecyclerView.Adapter<EnemigoRecyclerAdapter.EnemigoViewHolder> {
    List<Enemigo> list;

    @Override
    public EnemigoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemPersonaje = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new EnemigoViewHolder(itemPersonaje);
    }

    @Override
    public void onBindViewHolder (final EnemigoViewHolder holder, int position) {
        final Enemigo enemigo = list.get(position);

        holder.enemigoNombre.setText(enemigo.nombre);
        holder.enemigoRaza.setText(enemigo.raza);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), EnemigosShowActivity.class);
                intent.putExtra("enemigoid", enemigo.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return (list !=null ? list.size() : 0);
    }

    public void setList(List<Enemigo> enemigos){
        this.list = enemigos;
    }

    class EnemigoViewHolder extends RecyclerView.ViewHolder{
        private TextView enemigoNombre;
        private TextView enemigoRaza;

        EnemigoViewHolder(View itemEnemigo){
            super(itemEnemigo);
            enemigoNombre = itemEnemigo.findViewById(R.id.nombre);
            enemigoRaza = itemEnemigo.findViewById(R.id.raza);
        }
    }
}
