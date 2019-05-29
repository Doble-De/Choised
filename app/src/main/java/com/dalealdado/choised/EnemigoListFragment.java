package com.dalealdado.choised;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.dalealdado.R;

import java.util.List;


public abstract class EnemigoListFragment extends Fragment {
    DADViewModel enemigoViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_enemigo_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.enemigoList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final EnemigoRecyclerAdapter enemigoRecyclerAdapter = new EnemigoRecyclerAdapter();
        recyclerView.setAdapter(enemigoRecyclerAdapter);

        enemigoViewModel = ViewModelProviders.of(this).get(DADViewModel.class);

        getEnemigos().observe(this, new Observer<List<Enemigo>>() {
            @Override
            public void onChanged(@Nullable List<Enemigo> enemigos) {
                enemigoRecyclerAdapter.setList(enemigos);
                enemigoRecyclerAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    abstract LiveData<List<Enemigo>> getEnemigos();
}
