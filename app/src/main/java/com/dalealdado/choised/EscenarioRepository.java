package com.dalealdado.choised;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.dalealdado.choised.model.Escenario;

import java.util.List;

public class EscenarioRepository {

    DAO DAO;

    public EscenarioRepository(Application application){
        DAO= DADDatabase.getDatabase(application).DAO();
    }

    public LiveData<List<Escenario>> getEscenarios(){
        return DAO.getEscenarios();
    }

    public void insert(Escenario Escenario) {
        new insertAsyncTask(DAO).execute(Escenario);
    }

    private static class insertAsyncTask extends AsyncTask<Escenario, Void, Void> {

        private DAO mAsyncTaskDao;

        insertAsyncTask(DAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Escenario... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    public LiveData<Escenario> getEscenario(int id){
        return DAO.getEscenario(id);
    }
}