package com.dragger.yangdiansheng.dragger2.mvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dragger.yangdiansheng.dragger2.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MVPActivity extends AppCompatActivity implements LoginMVP.View {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_status)
    TextView tvStatus;

    private LoginMVP.Presenter mPresenter;

    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, MVPActivity.class);
        activity.startActivity(intent);
    }

    @OnClick(R.id.bt_login)
    void login(){
        mPresenter.login("1111","22222");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        ButterKnife.bind(this);
        mPresenter = new LoginPresenter(this);
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

    @Override
    public void setLoginStatus(String s) {
        tvStatus.setText(s);
    }
}
