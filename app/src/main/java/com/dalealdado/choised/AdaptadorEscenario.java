package com.dalealdado.choised;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dalealdado.choised.model.Escenario;
import com.dalealdado.dalealdado.R;

import java.util.List;

public class AdaptadorEscenario extends RecyclerView.Adapter<AdaptadorEscenario.MyViewHolder> {

    List<Escenario> list;
    EscenariosActivity activity;

    public AdaptadorEscenario(EscenariosActivity act) { activity = act; }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemPokemon = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_escenario, parent, false);
        return new MyViewHolder(itemPokemon);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int posicion) {
        final Escenario escenario = list.get(posicion);
        final EscenarioViewModel escenaroViewModel = ViewModelProviders.of(activity).get(EscenarioViewModel.class);

        holder.pokemonName.setText(escenario.nombre);
        holder.pokemonGen.setText(escenario.gen);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), EscenarioShowActivity.class);
                intent.putExtra("Pokid", escenario.id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (list != null ? list.size() : 0);
    }


    public List<Escenario> getList() {
        return list;
    }

    public void setList(List<Escenario> list) {

        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView pokemonName;
        private TextView pokemonGen;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonName = itemView.findViewById(R.id.pokemon_name);
            pokemonGen = itemView.findViewById(R.id.pokemon_gen);
        }
    }

}