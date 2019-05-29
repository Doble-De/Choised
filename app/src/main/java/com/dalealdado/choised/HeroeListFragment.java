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

import com.dalealdado.choised.model.Heroe;
import com.dalealdado.dalealdado.R;

import java.util.List;


public abstract class HeroeListFragment extends Fragment {
    DADViewModel heroeViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_heroe_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.heroeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        final HeroeRecyclerAdapter heroeRecyclerAdapter = new HeroeRecyclerAdapter();
        recyclerView.setAdapter(heroeRecyclerAdapter);

        heroeViewModel = ViewModelProviders.of(this).get(DADViewModel.class);

        getHeroes().observe(this, new Observer<List<Heroe>>() {
            @Override
            public void onChanged(@Nullable List<Heroe> heroes) {
                heroeRecyclerAdapter.setList(heroes);
                heroeRecyclerAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }

    abstract LiveData<List<Heroe>> getHeroes();
}

