package com.example.tst_mvp3.Services;

import com.android.volley.Request;

public interface S_VolleyRequest {
    <T> void addToRequestQueue(Request<T> req, String tag);
    <T> void addToRequestQueue(Request<T> req);
    void cancelPendingRequests(Object tag);
}
