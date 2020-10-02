package com.example.tst_mvp3.Repositories.Servers;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.Models.NewsModel;
import com.example.tst_mvp3.Services.S_VolleyRequest;

import io.reactivex.Single;

public class Api_News implements HomeContract.ModelCallBack {

    S_VolleyRequest volleyRequest;

    public Api_News(S_VolleyRequest volleyRequest) {
        this.volleyRequest = volleyRequest;
    }

    @Override
    public void getNews(FinishedGetNews finishedGetNews) {
        finishedGetNews.onFinish(Single.create(emitter -> {
            new Thread(() -> {

                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, "http://karsanjob.ir/api/News/GetOneNews?Id=1034", null, response -> {
                    NewsModel model=new NewsModel();
                    try {
                        model.setAbstractNews(response.getString("AbstractNews"));
                    }catch (Exception e){}
                    emitter.onSuccess(model);
                }, error -> {
                    emitter.onError(error);
                });
                volleyRequest.addToRequestQueue(request);
            }).start();
        }));
    }

    @Override
    public void onDestroy() {

    }

}
