package com.seriabov.fintecharch.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.seriabov.fintecharch.service.model.CoinInfo;

import java.util.List;

public class CoinListViewModel extends ViewModel {

    private final LiveData<List<CoinInfo>> projectListObservable;

    public CoinListViewModel(LiveData<List<CoinInfo>> projectListObservable) {
        this.projectListObservable = projectListObservable;
    }

    public LiveData<List<CoinInfo>> getProjectListObservable() {
        return projectListObservable;
    }
}
