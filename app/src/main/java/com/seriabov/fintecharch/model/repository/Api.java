package com.seriabov.fintecharch.model.repository;

import com.seriabov.fintecharch.model.CoinInfo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("ticker/?limit=20")
    Call<List<CoinInfo>> getCoinsList();
}
