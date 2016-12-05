package com.example.interfaces;

import com.example.model.DummyUsersModel;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by altaf.h.shaikh on 12/2/2016.
 */

public interface MyAPIServices {

    @GET("api")
    Observable<DummyUsersModel> getUsersList();

}
