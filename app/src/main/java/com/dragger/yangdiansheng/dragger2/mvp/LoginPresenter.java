package com.dragger.yangdiansheng.dragger2.mvp;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

public class LoginPresenter implements LoginMVP.Presenter{

    private LoginMVP.Model mModel;
    private LoginMVP.View mView;

    public LoginPresenter(LoginMVP.View view){
        mModel = new LoginModel();
        mView = view;
    }

    @Override
    public void login(String name, String password) {
        mView.buttonEnable(false);
        mModel.login(name, password, new LoginMVP.CallBack() {
            @Override
            public void success(String s) {
                mView.clearName();
                mView.clearPassword();
                mView.buttonEnable(true);
                mView.setLoginStatus(s);
            }

            @Override
            public void error() {
                mView.clearName();
                mView.clearPassword();
                mView.buttonEnable(true);
            }
        });
    }
}
