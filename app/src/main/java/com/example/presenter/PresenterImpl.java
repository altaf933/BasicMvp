package com.example.presenter;

import com.example.interfaces.MyView;
import com.example.interfaces.Presenter;

/**
 * Created by altaf.h.shaikh on 12/2/2016.
 */

public class PresenterImpl implements Presenter {
    private MyView myView;

    public PresenterImpl(MyView myView) {
        this.myView = myView;

    }

    @Override
    public void getBackgroundAsyncData() {


    }
}
