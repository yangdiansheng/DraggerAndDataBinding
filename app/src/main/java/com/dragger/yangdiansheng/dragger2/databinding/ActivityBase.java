package com.dragger.yangdiansheng.dragger2.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.dragger.yangdiansheng.dragger2.databinding.ActivityBaseBinding;
import android.view.View;
import android.widget.LinearLayout;

import com.dragger.yangdiansheng.dragger2.R;

/**
 * Created by yangdiansheng on 2018/7/24.
 */

public class ActivityBase extends AppCompatActivity {

    private ActivityBaseBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_base);
    }

    protected void addContent(final View view){
        mBinding.flContent.addView(view);
    }
    protected void addHead(View view){
        mBinding.flHead.addView(view);
    }
    protected void addFoot(View view){
        mBinding.flFoot.addView(view);
    }
}
