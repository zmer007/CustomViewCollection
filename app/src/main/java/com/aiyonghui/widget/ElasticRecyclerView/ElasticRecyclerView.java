package com.aiyonghui.widget.ElasticRecyclerView;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * User: lgd(1973140289@qq.com)
 * Date: 2017-03-26
 * Function: 一个有弹性的有下拉刷新和上拉加载更多功能的RecyclerView，100%与多看阅读列表相同。
 */
public class ElasticRecyclerView extends RecyclerView {

    public ElasticRecyclerView(Context context) {
        super(context);
    }

    public ElasticRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ElasticRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

}
