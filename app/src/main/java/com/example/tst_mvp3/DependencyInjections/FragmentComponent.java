package com.example.tst_mvp3.DependencyInjections;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.DependencyInjections.Centrals.ActivityScope;
import com.example.tst_mvp3.DependencyInjections.Centrals.AppComponent;
import com.example.tst_mvp3.Views.Fragments.HomeFragment;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {
        HomeModule.class
})
public interface FragmentComponent {
    void inject(HomeFragment homeFragment);

    HomeContract.PresenterCallBack getHomePresenter();
}
