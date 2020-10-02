package com.example.tst_mvp3.Views.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tst_mvp3.Contracts.HomeContract;
import com.example.tst_mvp3.DependencyInjections.Centrals.InitApplication;
import com.example.tst_mvp3.DependencyInjections.DaggerFragmentComponent;
import com.example.tst_mvp3.DependencyInjections.HomeModule;
import com.example.tst_mvp3.Models.NewsModel;
import com.example.tst_mvp3.R;

import javax.inject.Inject;

public class HomeFragment extends Fragment implements HomeContract.ViewCallBack {

    TextView label;
    ProgressBar loading;
    Button btn, btn_Next;

    @Inject
    HomeContract.PresenterCallBack presenterCallBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        DaggerFragmentComponent.builder()
                .appComponent(InitApplication.get(getActivity().getApplicationContext()).component())
                .homeModule(new HomeModule(this))
                .build().inject(this);

        btn = view.findViewById(R.id.btn);
        loading = view.findViewById(R.id.loading);
        label = view.findViewById(R.id.label);
        btn_Next = view.findViewById(R.id.btn_Next);

        btn.setOnClickListener(view1 -> {
            presenterCallBack.getNews();
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showNews(NewsModel model) {
        label.setText(model.getAbstractNews());
    }

    @Override
    public void onLoading(boolean load) {
        if (load) {
            loading.setVisibility(View.VISIBLE);
        } else {
            loading.setVisibility(View.GONE);
        }
    }

    @Override
    public void onSucces() {
        label.setVisibility(View.VISIBLE);
    }
}
