package com.example.services;

import com.example.AppConstant;
import com.example.interfaces.MyAPIServices;
import com.example.model.DummyUsersModel;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by altaf.h.shaikh on 12/2/2016.
 */

public class RetroService {

    public static MyAPIServices apiServices;

    public RetroService() {
        apiServices = getMyAPIService();
    }

    private MyAPIServices getMyAPIService() {
        Retrofit retrofit = new Retrofit.Builder().
                baseUrl(AppConstant.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())

                .build();
        return retrofit.create(MyAPIServices.class);
    }

    public Observable<DummyUsersModel> getUserList() {
        return apiServices.getUsersList();
    }


}
