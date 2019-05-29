package com.dalealdado.choised;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.choised.model.Escenario;
import com.dalealdado.choised.model.Heroe;

import java.util.List;

@Dao
public abstract class DAO {

    @Insert
    abstract void insert(Heroe heroe);

    @Insert
    abstract void insert(Enemigo enemigo);

    @Insert
    abstract void  insert(Escenario escenario);

    @Delete
    abstract void delete(Heroe heroe);

    @Delete
    abstract void delete(Escenario escenario);

    @Delete
    abstract void delete(Enemigo enemigo);

    @Query("DELETE FROM Enemigo WHERE id = :id")
    abstract void deleteEnemigo(int id);

    @Query("DELETE FROM Heroe WHERE id = :id")
    abstract int deleteHeroe(int id);

    @Query("DELETE FROM Escenario WHERE id = :id")
    abstract int deleteEscenario(int id);

    @Query("SELECT * FROM Heroe")
    abstract LiveData<List<Heroe>> getAllHeroes();

    @Query("SELECT * FROM Enemigo")
    abstract LiveData<List<Enemigo>> getAllEnemigos();

    @Query("SELECT * FROM escenario")
    abstract LiveData<List<Escenario>> getEscenarios();

    @Query("SELECT * FROM Heroe WHERE id = :id")
    abstract LiveData<Heroe> getHeroe(int id);

    @Query("SELECT * FROM Enemigo WHERE id = :id")
    abstract LiveData<Enemigo> getEnemigo(int id);

    @Query("SELECT * from escenario WHERE id=:id")
    abstract LiveData<Escenario> getEscenario(int id);
}
