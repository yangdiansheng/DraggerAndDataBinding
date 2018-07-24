package com.dragger.yangdiansheng.dragger2.dragger;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

@Module
public class LoginModule {
    private final LoginMVP.View mView;

    public LoginModule(LoginMVP.View mView) {
        this.mView = mView;
    }

    @Provides
    LoginMVP.View provideLoginView(){
        return mView;
    }
}
