package com.dalealdado.choised;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.choised.model.Escenario;
import com.dalealdado.choised.model.Heroe;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DADViewModel extends AndroidViewModel {

    private DAO mdao;
    private final Executor executor = Executors.newFixedThreadPool(2);

    public DADViewModel(Application application){
        super(application);
        mdao = DADDatabase.getDatabase(application).DAO();
    }


    /*
        ENEMIGOS
    */

    LiveData<List<Enemigo>> getAllEnemigos(){
        return mdao.getAllEnemigos();
    }

    public LiveData<Enemigo> getEnemigo(int id){ return mdao.getEnemigo(id); }

    public void insertEnemigo(final Enemigo enemigo){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.insert(enemigo);
            }
        });
    }

    public void deleteEnemigo(final Enemigo enemigo){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.delete(enemigo);
            }
        });
    }

    public void deleteEnemigo(final int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.deleteEnemigo(id);
            }
        });
    }


    /*
     ESCENARIOS
     */


    public LiveData<List<Escenario>> getEscenarios(){
        return mdao.getEscenarios();
    }

    public void insertEscenario(final Escenario escenario) {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.insert(escenario);
            }
        });
    }

    public LiveData<Escenario> getEscenario(int id){
        return mdao.getEscenario(id);
    }



    /*
        HEROES
    */

    LiveData<List<Heroe>> getAllHeroes(){
        return mdao.getAllHeroes();
    }


    public LiveData<Heroe> getHeroe(int id){ return mdao.getHeroe(id); }

    public void insertHeroe(final Heroe heroe){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.insert(heroe);
            }
        });
    }

     public void deleteHeroe(final int id){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                mdao.deleteHeroe(id);
            }
        });
    }
}
