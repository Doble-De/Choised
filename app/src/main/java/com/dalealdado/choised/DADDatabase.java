package com.dalealdado.choised;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.dalealdado.choised.model.Enemigo;
import com.dalealdado.choised.model.Escenario;
import com.dalealdado.choised.model.Heroe;

@Database(entities = {Heroe.class, Enemigo.class, Escenario.class}, version = 6)
public abstract class DADDatabase extends RoomDatabase {

    public abstract DAO DAO();

    private static volatile DADDatabase INSTANCE;

    static DADDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DADDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DADDatabase.class, "basededatos")
//                            .allowMainThreadQueries()
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
