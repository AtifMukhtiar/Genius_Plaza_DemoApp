package com.jadgroup.demoapp.networks;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Atif Mukhtiar on 4/1/2019.
 */

public class ApisResponse {

    public void getUsers(final NetworkCallBack networkCallBack) {
        RetroClient.getClient().getUsers()
                .enqueue(new Callback<JsonObject>() {
                    @Override
                    public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                        if (response.code() == 200) {
                            networkCallBack.updateResponse(true, response);
                        } else {
                            networkCallBack.updateResponse(false, response);
                        }
                    }

                    @Override
                    public void onFailure(Call<JsonObject> call, Throwable t) {
                        networkCallBack.updateResponse(false, null);
                    }
                });
    }// end of getWallpaper




}
