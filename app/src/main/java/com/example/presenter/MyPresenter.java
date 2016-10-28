package com.example.presenter;

import com.example.interfaces.MyServices;
import com.example.interfaces.MyView;

import java.util.List;

/**
 * Created by altaf.h.shaikh on 10/28/2016.
 */

public class MyPresenter {

    private MyView view;
    private MyServices myServices;

    public MyPresenter(MyView view, MyServices myServices) {
        this.view = view;
        this.myServices = myServices;
    }

    public void load() {

        List<String> items = myServices.getItems();
        view.showItems(items);
    }
}
