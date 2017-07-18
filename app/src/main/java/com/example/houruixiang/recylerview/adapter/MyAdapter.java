package com.example.houruixiang.recylerview.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.houruixiang.recylerview.R;
import com.example.houruixiang.recylerview.holder.SimpleHolder;


/**
 * Created by houruixiang on 2017/7/17.
 */
public class MyAdapter extends RecyclerView.Adapter<SimpleHolder> {

    private Activity mActivity;

    public MyAdapter(Activity mainActivity) {
        this.mActivity = mainActivity;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mActivity).inflate(R.layout.list_item, parent,false);
        /*TextView textView = new TextView(mActivity);
        textView.setTextSize(15);
        textView.setGravity(Gravity.CENTER);
        textView.setText("帅亚飞最帅");
        textView.setPadding(200,15,0,15);
        textView.setTextColor(Color.BLUE);*/
        return new SimpleHolder(inflate);
    }

    @Override
    public void onBindViewHolder(SimpleHolder holder, int position) {
        holder.tv.setText(position + "zyf_zs");
    }

    @Override
    public int getItemCount() {
        return 100;
    }
}
