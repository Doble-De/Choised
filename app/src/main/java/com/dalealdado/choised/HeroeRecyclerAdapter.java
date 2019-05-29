package com.dalealdado.choised;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dalealdado.choised.model.Heroe;
import com.dalealdado.dalealdado.R;
import com.dalealdado.choised.view.HeroesShowActivity;

import java.util.List;

public class HeroeRecyclerAdapter extends RecyclerView.Adapter<HeroeRecyclerAdapter.HeroeViewHolder> {

    List<Heroe> list;

    @Override
    public HeroeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemPersonaje = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_personaje, parent, false);
        return new HeroeViewHolder(itemPersonaje);
    }

    @Override
    public void onBindViewHolder (final HeroeViewHolder holder, int position) {
        final Heroe heroe = list.get(position);

        holder.heroeNombre.setText(heroe.nombre);
        holder.heroeRaza.setText(heroe.raza);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), HeroesShowActivity.class);
                intent.putExtra("heroeid", heroe.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount(){
        return (list !=null ? list.size() : 0);
    }

    public void setList(List<Heroe> heroes){
        this.list = heroes;
    }

    class HeroeViewHolder extends RecyclerView.ViewHolder{
        private TextView heroeNombre;
        private TextView heroeRaza;

        HeroeViewHolder(View itemHeroe){
            super(itemHeroe);
            heroeNombre = itemHeroe.findViewById(R.id.nombre);
            heroeRaza = itemHeroe.findViewById(R.id.raza);
        }
    }
}
