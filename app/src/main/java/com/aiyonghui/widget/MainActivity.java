package com.aiyonghui.widget;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.aiyonghui.widget.ElasticRecyclerView.EAdapter;
import com.aiyonghui.widget.ElasticRecyclerView.ElasticRecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ElasticRecyclerView mElasticRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mElasticRecyclerView = (ElasticRecyclerView) findViewById(R.id.activity_main);
        mElasticRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mElasticRecyclerView.setAdapter(new EAdapter());
        mElasticRecyclerView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mElasticRecyclerView.setRefreshing(false);
                    }
                }, 3000);
            }
        });
        mElasticRecyclerView.setOnLoadListener(new ElasticRecyclerView.OnLoadListener() {
            @Override
            public void onLoad() {
                Log.d(TAG, "onLoad: +++++++");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mElasticRecyclerView.setLoading(false);
                    }
                }, 3000);
            }
        });
    }
}
