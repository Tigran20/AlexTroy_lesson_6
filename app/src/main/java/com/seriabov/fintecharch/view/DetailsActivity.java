package com.seriabov.fintecharch.view;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.seriabov.fintecharch.R;
import com.seriabov.fintecharch.databinding.ActivityDetailsBinding;
import com.seriabov.fintecharch.model.CoinInfo;
import com.seriabov.fintecharch.viewModel.CoinDetailViewModel;

public class DetailsActivity extends AppCompatActivity {

    private static final String EXTRA_INFO = "extra_info";
    private ActivityDetailsBinding binding;

    public static void start(Activity activity, CoinInfo coinInfo) {
        Intent intent = new Intent(activity, DetailsActivity.class);
        intent.putExtra(EXTRA_INFO, coinInfo);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_details);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CoinInfo info = (CoinInfo) getIntent().getSerializableExtra(EXTRA_INFO);
        getSupportActionBar().setTitle(info.getSymbol());

        binding.setViewModel(new CoinDetailViewModel(info, getResources()));
    }
}
