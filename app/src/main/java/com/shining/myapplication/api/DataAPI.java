package com.shining.myapplication.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016-10-31.
 */

public class DataAPI {
    private Services service;
    private Services dataService;
    public DataAPI(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(Services.class);

        Retrofit retrofit2 = new Retrofit.Builder()
                .baseUrl(Constants.DATA_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dataService = retrofit2.create(Services.class);
    }
    public Services getService(){
        return service;
    }
    public Services getDataService(){
        return dataService;
    }
}
