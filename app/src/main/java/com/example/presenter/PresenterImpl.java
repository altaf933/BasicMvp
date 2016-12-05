package com.example.presenter;

import com.example.interfaces.MyView;
import com.example.interfaces.Presenter;
import com.example.model.DummyUsersModel;
import com.example.services.RetroService;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by altaf.h.shaikh on 12/2/2016.
 */

public class PresenterImpl implements Presenter {
    private MyView myView;
    private RetroService retroService;
    private Subscription subscription;
    private CompositeSubscription mCompositeSubscription;

    public PresenterImpl(MyView myView) {
        this.myView = myView;
        retroService = new RetroService();
        mCompositeSubscription = new CompositeSubscription();

    }

    @Override
    public void getBackgroundAsyncData() {
        myView.showProgressDialoge();

        subscription = retroService.getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DummyUsersModel>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        myView.errorDialoge();
                    }

                    @Override
                    public void onNext(DummyUsersModel dummyUsersModel) {
                        myView.setResult(dummyUsersModel);
                    }
                });
        mCompositeSubscription.add(subscription);
    }

    @Override
    public void onDestroy() {
        mCompositeSubscription.unsubscribe();
    }
}
