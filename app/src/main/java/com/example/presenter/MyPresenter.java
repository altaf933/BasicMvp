package com.example.presenter;

import com.example.interfaces.IMyServices;
import com.example.interfaces.IMyView;

import java.util.List;

/**
 * Created by altaf.h.shaikh on 10/28/2016.
 */

public class MyPresenter {

    private IMyView view;
    private IMyServices myServices;

    public MyPresenter(IMyView view, IMyServices myServices) {
        this.view = view;
        this.myServices = myServices;
    }

    public void load() {

        List<String> items = myServices.getItems();
        view.showItems(items);
    }
}
