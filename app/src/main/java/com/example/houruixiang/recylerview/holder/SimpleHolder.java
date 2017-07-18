package com.example.houruixiang.recylerview.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


import com.example.houruixiang.recylerview.R;


/**
 * Created by houruixiang on 2017/7/17.
 */

public class SimpleHolder extends RecyclerView.ViewHolder {


    public TextView tv;

    public SimpleHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.tv);
    }
}
