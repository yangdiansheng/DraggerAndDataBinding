package com.dragger.yangdiansheng.dragger2.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.dragger.yangdiansheng.dragger2.BR;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

public class User extends BaseObservable{
    private String name;
    private String age;

    public User(String name,String age){
        this.name = name;
        this.age = age;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setAge(String age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
