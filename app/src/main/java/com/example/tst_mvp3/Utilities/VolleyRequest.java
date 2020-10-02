package com.example.tst_mvp3.Utilities;

import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.tst_mvp3.Services.S_VolleyRequest;

public class VolleyRequest implements S_VolleyRequest {

    public static final String TAG = VolleyRequest.class.getSimpleName();

    Context context;
    RequestQueue mRequestQueue;

    public VolleyRequest(Context context) {
        this.context = context;
        mRequestQueue = Volley.newRequestQueue(context);
    }

    @Override
    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG : tag);
        mRequestQueue.add(req);
    }

    @Override
    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        mRequestQueue.add(req);
    }

    @Override
    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

}
