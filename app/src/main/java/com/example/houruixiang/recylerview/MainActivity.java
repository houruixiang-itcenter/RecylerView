package com.example.houruixiang.recylerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.houruixiang.recylerview.adapter.MyAdapter;
import com.example.houruixiang.recylerview.customView.CustomDecoration;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }

    private void initEvent() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new CustomDecoration(this));
        //recyclerView.addItemDecoration(new MyDecoration(this,MyDecoration.VERTICAL_LIST));
        recyclerView.setAdapter(new MyAdapter(this));

    }
}
