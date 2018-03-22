package com.seriabov.fintecharch.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import com.seriabov.fintecharch.service.model.CoinInfo;

public class CoinViewModel extends ViewModel {

    private final LiveData<CoinInfo> projectObservable;
    public ObservableField<CoinInfo> project = new ObservableField<>();

    public CoinViewModel(LiveData<CoinInfo> projectObservable) {
        this.projectObservable = projectObservable;
    }

    public LiveData<CoinInfo> getObservableProject() {
        return projectObservable;
    }

    public void setProject(CoinInfo project) {
        this.project.set(project);
    }
}
