package com.dragger.yangdiansheng.dragger2.databinding;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dragger.yangdiansheng.dragger2.R;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivity extends AppCompatActivity{


    public static void show(Activity activity) {
        Intent intent = new Intent();
        intent.setClass(activity, RecycleViewActivity.class);
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
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            list.add("" + i);
        }
        mBuidling.rlvList.setAdapter(new StringAdapter(list));

    }

    public static class StringAdapter extends RecyclerView.Adapter<ViewHolder> {

        private List<String> mList;

        public StringAdapter(List<String> list){
            mList = list;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(),R.layout.recycleview_item,null);
            RecyclerView.LayoutParams params = new RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT);
            view.setLayoutParams(params);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.textView.setText(mList.get(position));
        }

        @Override
        public int getItemCount() {
            return mList.size();
        }
    }



    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_text);
        }
    }
}
