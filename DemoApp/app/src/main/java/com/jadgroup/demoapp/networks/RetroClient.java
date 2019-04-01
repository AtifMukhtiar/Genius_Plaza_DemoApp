package com.jadgroup.demoapp.networks;


import com.jadgroup.demoapp.keys.KeysString;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Atif Mukhtiar on 4/1/2019.
 */

public class RetroClient {

    static RetroService retroService = null;


    public static RetroService getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(KeysString.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retroService = retrofit.create(RetroService.class);
        return retroService;
    }// end of getClient


}
