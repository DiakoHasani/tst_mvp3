package com.example.tst_mvp3.Views.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tst_mvp3.R;
import com.example.tst_mvp3.Views.Fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frameMain,new HomeFragment()).addToBackStack(null).commit();
    }
}
