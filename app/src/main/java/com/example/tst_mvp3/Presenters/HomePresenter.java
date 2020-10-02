package com.example.tst_mvp3.Presenters;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.Models.NewsModel;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public class HomePresenter implements HomeContract.PresenterCallBack, HomeContract.ModelCallBack.FinishedGetNews {

    HomeContract.ViewCallBack viewCallBack;
    HomeContract.ModelCallBack modelCallBack;
    Disposable dispose_onFinish;

    public HomePresenter(HomeContract.ViewCallBack viewCallBack, HomeContract.ModelCallBack modelCallBack) {
        this.viewCallBack = viewCallBack;
        this.modelCallBack = modelCallBack;
    }

    @Override
    public void getNews() {
        if (viewCallBack != null) {
            viewCallBack.onLoading(true);
            modelCallBack.getNews(this);
        }
    }

    @Override
    public void onDestroy() {
        modelCallBack.onDestroy();
        if (dispose_onFinish!=null){
            dispose_onFinish.dispose();
        }
    }

    @Override
    public void onFinish(Single<NewsModel> model) {
        if (viewCallBack != null) {
            dispose_onFinish = model.subscribeWith(new DisposableSingleObserver<NewsModel>() {
                @Override
                public void onSuccess(NewsModel model) {
                    viewCallBack.onSucces();
                    viewCallBack.onLoading(false);
                    viewCallBack.showNews(model);
                }

                @Override
                public void onError(Throwable e) {
                    viewCallBack.onSucces();
                    viewCallBack.onLoading(false);
                }
            });
        }
    }
}
