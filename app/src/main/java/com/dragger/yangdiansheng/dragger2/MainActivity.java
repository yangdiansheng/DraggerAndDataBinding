package com.dragger.yangdiansheng.dragger2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dragger.yangdiansheng.dragger2.databinding.DataBindingActivity;
import com.dragger.yangdiansheng.dragger2.mvp.MVPActivity;
import com.dragger.yangdiansheng.dragger2.dragger.DraggerActivity;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @OnClick(R.id.bt_mvp)
    void mvp(){
        MVPActivity.show(this);
    }

    @OnClick(R.id.bt_dragger)
    void dragger(){
        DraggerActivity.show(this);
    }

    @OnClick(R.id.bt_databinding)
    void databinding(){
        DataBindingActivity.show(this);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
