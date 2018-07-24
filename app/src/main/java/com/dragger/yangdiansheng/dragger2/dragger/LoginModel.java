package com.dragger.yangdiansheng.dragger2.dragger;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

public class LoginModel implements LoginMVP.Model{


    @Override
    public void login(String name, String password, final LoginMVP.CallBack callBack) {
        if (callBack != null){
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    callBack.success("success");
                }
            },1000);
        }
    }
}
