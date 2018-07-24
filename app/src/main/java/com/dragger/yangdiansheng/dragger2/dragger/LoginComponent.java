package com.dragger.yangdiansheng.dragger2.dragger;

import dagger.Component;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

@Component(modules = LoginModule.class)
public interface LoginComponent {
    void inject(DraggerActivity activity);
}
