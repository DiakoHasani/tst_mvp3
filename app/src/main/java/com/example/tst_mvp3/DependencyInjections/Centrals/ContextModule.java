package com.example.tst_mvp3.DependencyInjections.Centrals;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext(){
        return context;
    }
}
