package com.jadgroup.demoapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jadgroup.demoapp.R;
import com.jadgroup.demoapp.resources.MainActivityResource;

public class MainActivity extends AppCompatActivity {
    MainActivityResource mainActivityResource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mainActivityResource = new MainActivityResource(this);
    }
}
