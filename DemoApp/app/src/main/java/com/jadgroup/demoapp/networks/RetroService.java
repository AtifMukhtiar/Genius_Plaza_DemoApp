package com.jadgroup.demoapp.networks;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Atif Mukhtiar on 4/1/2019.
 */

public interface RetroService {

    @GET("users")
    Call<JsonObject> getUsers();

    @Headers({"Accept: application/json"})
    @POST("users")
    Call<JsonObject> createUser(@Body JsonObject body);


}
