package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.interfaces.MyView;
import com.example.interfaces.Presenter;
import com.example.model.DummyUsersModel;
import com.example.presenter.PresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MyView {

    @BindView(R.id.btnLoad)
    Button btnLoad;

    @BindView(R.id.txtLoaditems0)
    TextView txtLoaditems0;
    @BindView(R.id.txtLoaditems1)
    TextView txtLoaditems1;
    @BindView(R.id.txtLoaditems2)
    TextView txtLoaditems2;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter = new PresenterImpl(this);
    }

    @OnClick(R.id.btnLoad)
    public void loadItems() {
        if (presenter != null)
            presenter.getBackgroundAsyncData();
    }


    @Override
    public void showProgressDialoge() {

    }

    @Override
    public void setResult(DummyUsersModel userDetail) {
        if (userDetail.getResults().get(0).getName() != null) {
            txtLoaditems0.setText(userDetail.getResults().get(0).getName().getFirst());
            txtLoaditems1.setText(userDetail.getResults().get(0).getName().getLast());
            txtLoaditems2.setText(userDetail.getResults().get(0).getName().getTitle());

        }

    }

    @Override
    public void errorDialoge() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Unscribed your detail
        presenter.onDestroy();

    }
}
