package com.example.tst_mvp3.DependencyInjections.Centrals;

import android.content.Context;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.Repositories.Servers.Api_News;
import com.example.tst_mvp3.Services.S_VolleyRequest;
import com.example.tst_mvp3.Utilities.VolleyRequest;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    public HomeContract.ModelCallBack provideApi_news(S_VolleyRequest volleyRequest) {
        return new Api_News(volleyRequest);
    }

    @Provides
    public S_VolleyRequest provideVolleyRequest(Context context) {
        return new VolleyRequest(context);
    }

}
