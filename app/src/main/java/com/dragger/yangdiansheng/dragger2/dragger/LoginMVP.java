package com.dragger.yangdiansheng.dragger2.dragger;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

public interface LoginMVP {

    public interface CallBack{
        void success(String s);
        void error();
    }

    public interface Model{
        void login(String name, String password, CallBack callBack);
    }

    public interface View {
        void clearName();
        void clearPassword();
        void buttonEnable(boolean flag);
        void setLoginStatus(String s);
    }

    public interface ViewModel{
        void login(String name, String password);
    }
}
