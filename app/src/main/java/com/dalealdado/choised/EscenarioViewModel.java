package com.dalealdado.choised;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.dalealdado.choised.model.Escenario;

import java.util.List;

public class EscenarioViewModel extends AndroidViewModel {

    private EscenarioRepository mEscenario;

    public EscenarioViewModel(Application application){
        super(application);
        mEscenario = new EscenarioRepository(application);
    }

    LiveData<List<Escenario>> getEscenarios(){return mEscenario.getEscenarios();}

    LiveData<Escenario> getEscenario(int id){ return mEscenario.getEscenario(id);}

    public void insertEscenario(Escenario escenario) { mEscenario.insert(escenario);}
}
