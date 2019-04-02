package com.jadgroup.demoapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jadgroup.demoapp.R;
import com.jadgroup.demoapp.resources.AddUserResource;

public class AddUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        init();
    }

    private void init() {
        AddUserResource addUserResource = new AddUserResource(this);
    }

}
