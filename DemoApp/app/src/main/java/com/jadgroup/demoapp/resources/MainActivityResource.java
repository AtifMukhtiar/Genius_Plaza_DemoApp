package com.jadgroup.demoapp.resources;

import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

public class MainActivityResource implements NetworkCallBack {

    Activity context;
    RecyclerView rv_users;
    UserAdapter userAdapter;
    ApisResponse apisResponse;
    ArrayList<User> usersList;

    public MainActivityResource(Activity context) {
        this.context = context;
        apisResponse = new ApisResponse();
        usersList = new ArrayList<>();
        initResource();
        setTextViewText();
        addViewListener();
    }

    private void initResource() {
        rv_users = context.findViewById(R.id.rv_users);
        userAdapter = new UserAdapter(context, usersList);
        rv_users.setLayoutManager(new LinearLayoutManager(context));
        rv_users.setAdapter(userAdapter);

        apisResponse.getUsers(this);


    }

    private void setTextViewText() {

    }

    private void addViewListener() {

    }

    @Override
    public void updateResponse(boolean result, Response<JsonObject> response) {
        if (result) {
            Type listType = new TypeToken<Data>() {
            }.getType();
            Data usersData = new Gson().fromJson(response.body(), listType);
            RootModel.getInstance().setData(usersData);
            userAdapter.addList((ArrayList<User>) RootModel.getInstance().getData().getData());
            userAdapter.notifyDataSetChanged();

        } else {
            /**
             * TODO: temporary error message
             */
            System.out.print("Internet Error");
        }

    }
}
