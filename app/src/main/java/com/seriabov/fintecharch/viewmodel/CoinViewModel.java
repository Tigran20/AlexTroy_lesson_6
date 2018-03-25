package com.seriabov.fintecharch.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.seriabov.fintecharch.model.CoinInfo;
import com.seriabov.fintecharch.model.repository.AppDelegate;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by werk on 25/03/2018.
 */

public class CoinViewModel extends ViewModel {
    private MutableLiveData<List<CoinInfo>> coins;
    private Context context;
    private ListenerCoinViewModel listener;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setListener(ListenerCoinViewModel listener) {
        this.listener = listener;
    }

    public LiveData<List<CoinInfo>> getCoins() {
        if (coins == null) {
            coins = new MutableLiveData<>();
            getData(false);
        }
        return coins;
    }

    public void refreshData(){
        getData(true);
    }

    private void getData(boolean isRefresh) {
        listener.showLoading();
        AppDelegate.from(context)
                .getApiService()
                .getCoinsList()
                .enqueue(new Callback<List<CoinInfo>>() {
                    @Override
                    public void onResponse(Call<List<CoinInfo>> call, Response<List<CoinInfo>> response) {
                        coins.setValue(response.body());
                        if (isRefresh){
                            listener.setNewData(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<CoinInfo>> call, Throwable t) {
                        listener.showError(t);
                    }
                });
    }

    public interface ListenerCoinViewModel {
        void showError(Throwable error);
        void showLoading();
        void setNewData(List<CoinInfo> coinInfos);
    }
}
