package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.altafhshaikh.androidmvpsimple.R;
import com.example.interfaces.IMyView;
import com.example.presenter.MyPresenter;
import com.example.services.MyContentServices;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements IMyView {

    @BindView(R.id.btnLoad)
    Button btnLoad;

    @BindView(R.id.txtLoaditems)
    TextView txtLoaditems;

    MyPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        presenter = new MyPresenter(this, new MyContentServices());
    }

    @OnClick(R.id.btnLoad)
    public void loadItems() {
        presenter.load();
    }

    @Override
    public void showItems(List<String> items) {
        String result = null;
        for (int i = 0; i < items.size(); i++) {
            txtLoaditems.setText(result += items.get(i));
        }

    }
}
