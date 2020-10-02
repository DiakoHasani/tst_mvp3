package com.example.tst_mvp3.DependencyInjections.Centrals;

import android.app.Application;
import android.content.Context;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.Repositories.Servers.Api_News;
import com.example.tst_mvp3.Services.S_VolleyRequest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        AppModule.class,
        ContextModule.class,
        DataModule.class
})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Context getContext();
    HomeContract.ModelCallBack getApi_News();
    S_VolleyRequest getVolleyRequest();
    Application getApplication();
}
