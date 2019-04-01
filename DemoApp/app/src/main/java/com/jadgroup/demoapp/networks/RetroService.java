package com.jadgroup.demoapp.networks;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Atif Mukhtiar on 4/1/2019.
 */

public interface RetroService {

    @GET("users")
    Call<JsonObject> getUsers();


}
