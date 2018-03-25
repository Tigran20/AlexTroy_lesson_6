package com.seriabov.fintecharch.viewModel;

import android.content.res.Resources;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.seriabov.fintecharch.R;
import com.seriabov.fintecharch.model.CoinInfo;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by werk on 25/03/2018.
 */

public class CoinDetailViewModel extends BaseObservable {
    private CoinInfo coinInfo;
    private Resources resources;

    public CoinDetailViewModel(CoinInfo coinInfo, Resources resources) {
        this.coinInfo = coinInfo;
        this.resources = resources;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view).load(imageUrl).into(view);
    }

    @Bindable
    public String getImageUrl() {
        return resources.getString(R.string.coin_logo_url, coinInfo.getSymbol().toLowerCase());
    }

    @Bindable
    public String getTitle() {
        return coinInfo.getName();
    }

    @Bindable
    public String getPrice() {
        return resources.getString(R.string.price_format, coinInfo.getPriceUsd());
    }

    @Bindable
    public String getChange7d() {
        return resources.getString(R.string.percent_format, coinInfo.getPercentChange7d());
    }

    @Bindable
    public int getColorChange7d() {
        if (coinInfo.getPercentChange7d() > 0) {
            return resources.getColor(R.color.green700);
        } else {
            return resources.getColor(R.color.red700);
        }
    }

    @Bindable
    public String getChange24d() {
        return resources.getString(R.string.percent_format, coinInfo.getPercentChange24h());
    }

    @Bindable
    public int getColorChange24d() {
        if (coinInfo.getPercentChange24h() > 0) {
            return resources.getColor(R.color.green700);
        } else {
            return resources.getColor(R.color.red700);
        }
    }

    @Bindable
    public String getChange1d() {
        return resources.getString(R.string.percent_format, coinInfo.getPercentChange1h());
    }

    @Bindable
    public String getMarketCup(){
        return resources.getString(R.string.price_format, coinInfo.getMarketCapUsd());
    }

    @Bindable
    public int getColorChange1d() {
        if (coinInfo.getPercentChange1h() > 0) {
            return resources.getColor(R.color.green700);
        } else {
            return resources.getColor(R.color.red700);
        }
    }

    @Bindable
    public String getLastUpdate(){
        return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, Locale.getDefault())
                .format(new Date(coinInfo.getLastUpdated()));
    }
}
