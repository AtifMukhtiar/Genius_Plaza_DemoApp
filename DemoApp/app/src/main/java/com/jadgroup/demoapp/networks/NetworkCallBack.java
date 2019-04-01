package com.jadgroup.demoapp.networks;

import com.google.gson.JsonObject;

import retrofit2.Response;

/**
 * Created by Atif Mukhtiar on 2/28/2019.
 */

public interface NetworkCallBack {
    void updateResponse(boolean result, Response<JsonObject> response);
}
