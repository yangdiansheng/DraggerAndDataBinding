package com.dragger.yangdiansheng.dragger2.dragger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dragger.yangdiansheng.dragger2.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DraggerActivity extends AppCompatActivity implements LoginMVP.View{

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_status)
    TextView tvStatus;


    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, DraggerActivity.class);
        activity.startActivity(intent);
    }

    @Inject
    LoginPresenter mLoginViewModel;

    @OnClick(R.id.bt_login)
    void login(){
        mLoginViewModel.login("111","222");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvvm);
        ButterKnife.bind(this);
        DaggerLoginComponent.builder()
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void clearName() {
        etName.setText("");
    }

    @Override
    public void clearPassword() {
        etPassword.setText("");
    }

    @Override
    public void buttonEnable(boolean flag) {
        btLogin.setEnabled(flag);
    }

    public void setLoginStatus(String s) {
        tvStatus.setText(s);
    }
}
