package com.aiyonghui.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.aiyonghui.widget.ElasticRecyclerView.EAdapter;
import com.aiyonghui.widget.ElasticRecyclerView.ElasticRecyclerView;

public class MainActivity extends AppCompatActivity {

    ElasticRecyclerView mElasticRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mElasticRecyclerView = (ElasticRecyclerView) findViewById(R.id.activity_main);
        mElasticRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mElasticRecyclerView.setAdapter(new EAdapter());
    }
}
