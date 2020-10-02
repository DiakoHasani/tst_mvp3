package com.example.tst_mvp3.Contracts;

import com.example.tst_mvp3.Models.NewsModel;
import com.example.tst_mvp3.Utilities.BaseView;

import io.reactivex.Single;

public interface HomeContract {

    interface ViewCallBack extends BaseView {
        void showNews(NewsModel model);
    }

    interface ModelCallBack {

        void getNews(FinishedGetNews finishedGetNews);

        void onDestroy();

        interface FinishedGetNews {
            void onFinish(Single<NewsModel> model);
        }
    }

    interface PresenterCallBack {
        void getNews();

        void onDestroy();
    }

}
