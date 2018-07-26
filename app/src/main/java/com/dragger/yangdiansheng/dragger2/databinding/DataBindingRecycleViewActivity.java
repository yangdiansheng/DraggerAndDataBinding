package com.dragger.yangdiansheng.dragger2.databinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.dragger.yangdiansheng.dragger2.databinding.DatabindingRecycleviewItemBinding;

import com.dragger.yangdiansheng.dragger2.R;
import com.dragger.yangdiansheng.dragger2.data.User;

import java.util.ArrayList;
import java.util.List;

public class DataBindingRecycleViewActivity extends AppCompatActivity{


    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, DataBindingRecycleViewActivity.class);
        activity.startActivity(intent);
    }

    private ActivityDatabindingRecycleviewBinding mBuidling;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view = View.inflate(this,R.layout.activity_databinding_recycleview,null);
//        addContent(view);
//        mBuidling =  DataBindingUtil.bind(view);
        mBuidling = DataBindingUtil.setContentView(this,R.layout.activity_databinding_recycleview);
        mBuidling.rlvList.setLayoutManager(new LinearLayoutManager(this));
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            User user = new User("name" + i,"age" +i);
            list.add(user);
        }
        mBuidling.rlvList.setAdapter(new StringAdapter(list));

    }

    public static class StringAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<User> mList;

        public StringAdapter(List<User> list){
            mList = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            DatabindingRecycleviewItemBinding binding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.getContext()),
                    R.layout.databinding_recycleview_item,
                    parent,
                    false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.mBinding.setItem(mList.get(position));
            holder.mBinding.executePendingBindings();
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public DatabindingRecycleviewItemBinding mBinding;

        public ViewHolder(DatabindingRecycleviewItemBinding itemView) {
            super(itemView.getRoot());
            mBinding = itemView;
        }
    }
}
