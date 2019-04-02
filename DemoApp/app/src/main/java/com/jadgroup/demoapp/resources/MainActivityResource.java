package com.jadgroup.demoapp.resources;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.jadgroup.demoapp.R;
import com.jadgroup.demoapp.adapters.UserAdapter;
import com.jadgroup.demoapp.models.Data;
import com.jadgroup.demoapp.models.RootModel;
import com.jadgroup.demoapp.models.User;
import com.jadgroup.demoapp.networks.ApisResponse;
import com.jadgroup.demoapp.networks.NetworkCallBack;
import com.jadgroup.demoapp.ui.AddUser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class MainActivityResource implements NetworkCallBack, View.OnClickListener {

    Activity context;
    FloatingActionButton fb_addUser;
    RecyclerView rv_users;
    UserAdapter userAdapter;
    ApisResponse apisResponse = new ApisResponse();
    ArrayList<User> usersList;

    public MainActivityResource(Activity context) {
        this.context = context;
        usersList = new ArrayList<>();
        initResource();
        setTextViewText();
        addViewListener();
    }

    private void initResource() {
        fb_addUser = context.findViewById(R.id.fb_addUser);
        rv_users = context.findViewById(R.id.rv_users);
        userAdapter = new UserAdapter(context, usersList);
        rv_users.setLayoutManager(new LinearLayoutManager(context));
        rv_users.setAdapter(userAdapter);

        apisResponse.getUsers(this);


    }

    private void setTextViewText() {

    }

    private void addViewListener() {
        fb_addUser.setOnClickListener(this);
    }

    @Override
    public void updateResponse(boolean result, Response<JsonObject> response) {
        if (result) {
            Type listType = new TypeToken<Data>() {
            }.getType();
            Data usersData = new Gson().fromJson(response.body(), listType);
            RootModel.getInstance().setData(usersData);
            if (userAdapter != null) {
                userAdapter.addList((ArrayList<User>) RootModel.getInstance().getData().getData());
                userAdapter.notifyDataSetChanged();
            }


        } else {
            /**
             * TODO: temporary error message
             */
            System.out.print("Internet Error");
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fb_addUser:
                newUserActivity();
                break;
        }
    }

    private void newUserActivity() {
        context.startActivity(new Intent(context, AddUser.class));
    }


    public void onResume() {
        apisResponse.getUsers(this);
    }

    public void onStop() {
    }
}
