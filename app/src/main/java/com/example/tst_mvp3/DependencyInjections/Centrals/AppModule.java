package com.example.tst_mvp3.DependencyInjections.Centrals;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    InitApplication initApplication;

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return initApplication;
    }
}
