package com.aiyonghui.widget.ElasticRecyclerView;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.util.AttributeSet;

/**
 * User: lgd(1973140289@qq.com)
 * Date: 2017-03-26
 * Function: 一个有弹性的有下拉刷新和上拉加载更多功能的RecyclerView，100%与多看阅读列表相同。
 */
public class ElasticRecyclerView extends SwipeRefreshLayout {

    private SwipeRefreshLayout mSwipeLayout;
    private RecyclerView mRecyclerView;

    private OnLoadListener mLoadListener;

    private boolean mLoading = false;


    public ElasticRecyclerView(Context context) {
        super(context);
        addRecyclerView(context);
    }

    public ElasticRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        addRecyclerView(context);
    }

    private void addRecyclerView(Context context) {
        mRecyclerView = new RecyclerView(context);
        mRecyclerView.setLayoutParams(new SwipeRefreshLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (mLoadListener != null && isIdle() && !ViewCompat.canScrollVertically(mRecyclerView, 1)) {
                    mLoading = true;
                    mLoadListener.onLoad();
                }
            }
        });

        addView(mRecyclerView);
    }

    public void setLayoutManager(LayoutManager layoutManager) {
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public void setAdapter(RecyclerView.Adapter adapter) {
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void setOnRefreshListener(OnRefreshListener listener) {
        super.setOnRefreshListener(listener);
    }

    public void setOnLoadListener(OnLoadListener loadListener) {
        mLoadListener = loadListener;
    }

    public interface OnLoadListener {
        void onLoad();
    }

    public void setLoading(boolean loading){
        mLoading = loading;
    }

    public boolean isIdle() {
        return !mLoading && !isRefreshing();
    }

    public boolean isLoading() {
        return mLoading;
    }
}
