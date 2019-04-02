package com.jadgroup.demoapp.resources;

import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jadgroup.demoapp.R;
import com.jadgroup.demoapp.models.NewUser;
import com.jadgroup.demoapp.models.User;
import com.jadgroup.demoapp.networks.ApisResponse;
import com.jadgroup.demoapp.networks.NetworkCallBack;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Response;

public class AddUserResource implements View.OnClickListener, NetworkCallBack {
    Activity context;


    TextInputEditText txtView_name;
    TextInputEditText txtView_job;
    FloatingActionButton fb_save;
    ApisResponse apisResponse = new ApisResponse();

    public AddUserResource(Activity context) {
        this.context = context;
        initResource();
        setTextViewText();
        addViewListener();
    }

    private void initResource() {
        txtView_name = context.findViewById(R.id.txtView_name);
        txtView_job = context.findViewById(R.id.txtView_job);
        fb_save = context.findViewById(R.id.fb_save);
    }

    private void setTextViewText() {

    }

    private void addViewListener() {
        fb_save.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_save:

                String name = txtView_name.getText().toString();
                String job = txtView_job.getText().toString();

                if (name.trim().length() > 0) {
                    if (job.trim().length() > 0) {
                        NewUser newUser = new NewUser();
                        newUser.setName(name);
                        newUser.setJob(job);
                        apisResponse.createUser(newUser, this);
                    } else {
                        Toast.makeText(context, "Please put something in job", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(context, "Please put something in name", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }

    @Override
    public void updateResponse(boolean result, Response<JsonObject> response) {
        if (result) {
            Toast.makeText(context, "New User Added: " + response, Toast.LENGTH_SHORT).show();
            context.finish();
        } else {
            Toast.makeText(context, "Failure Adding User!" + response, Toast.LENGTH_SHORT).show();
        }
    }
}
