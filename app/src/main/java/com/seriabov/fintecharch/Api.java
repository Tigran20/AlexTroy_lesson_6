package com.seriabov.fintecharch;

import com.seriabov.fintecharch.service.model.CoinInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("ticker/?limit=20")
    Call<List<CoinInfo>> getCoinsList();
}
