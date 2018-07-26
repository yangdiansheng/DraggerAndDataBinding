package com.dragger.yangdiansheng.dragger2.databinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.dragger.yangdiansheng.dragger2.data.User;
import com.dragger.yangdiansheng.dragger2.databinding.ActivityDatabindingBinding;

import com.dragger.yangdiansheng.dragger2.R;

public class DataBindingActivity extends ActivityBase{


    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, DataBindingActivity.class);
        activity.startActivity(intent);
    }

    private ActivityDatabindingBinding mBuidling;

    public interface Event{
        void onclick(View v);
        void onclickkk(View v);
    }

    private User mUser = new User("我是你爸爸","100");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = View.inflate(this,R.layout.activity_databinding,null);
        View viewHead = View.inflate(this,R.layout.activity_head,null);
        View viewFoot = View.inflate(this,R.layout.activity_foot,null);
        addContent(view);
        addHead(viewHead);
        addFoot(viewFoot);
        mBuidling =  DataBindingUtil.bind(view);

        mBuidling.setUser(mUser);
        mBuidling.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBuidling.setContent("我是你大爷");
                mBuidling.setEnable(!mBuidling.btLogin1.isEnabled());

            }
        });
        mBuidling.btLogin2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setName("王美丽");

            }
        });
        mBuidling.btLogin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser.setAge("222222222");

            }
        });
        mBuidling.setEvent(new Event() {
            @Override
            public void onclick(View v) {
                Log.i("yyy","1111");


            }

            @Override
            public void onclickkk(View v) {
                Log.i("yyy","22222");
            }

        });

    }
}
