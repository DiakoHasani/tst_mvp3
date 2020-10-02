package com.example.tst_mvp3.DependencyInjections;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.Presenters.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeModule {

    HomeContract.ViewCallBack viewCallBack;

    public HomeModule(HomeContract.ViewCallBack viewCallBack) {
        this.viewCallBack = viewCallBack;
    }

    @Provides
    public HomeContract.ViewCallBack provideView() {
        return viewCallBack;
    }

    @Provides
    public HomeContract.PresenterCallBack providePresenter(HomeContract.ViewCallBack view, HomeContract.ModelCallBack model) {
        return new HomePresenter(view, model);
    }
}
