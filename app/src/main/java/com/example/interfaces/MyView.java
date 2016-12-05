package com.example.interfaces;

import com.example.model.DummyUsersModel;

public interface MyView {

    void showProgressDialoge();

    void setResult(DummyUsersModel dummyUsersModel);

    void errorDialoge();
}