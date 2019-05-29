package com.dalealdado.choised;

import android.arch.lifecycle.LiveData;

import com.dalealdado.choised.model.Heroe;

import java.util.List;

public class HeroesListFragment extends HeroeListFragment {
    @Override
    LiveData<List<Heroe>> getHeroes() {
        return heroeViewModel.getAllHeroes();
    }
}

