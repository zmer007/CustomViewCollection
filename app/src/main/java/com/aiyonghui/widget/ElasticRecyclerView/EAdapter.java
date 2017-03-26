package com.aiyonghui.widget.ElasticRecyclerView;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aiyonghui.widget.ElasticRecyclerView.EAdapter.EViewHolder;
import com.aiyonghui.widget.R;

import java.util.List;

/**
 * User: lgd(1973140289@qq.com)
 * Date: 2017-03-26
 * Function:
 */
public class EAdapter extends RecyclerView.Adapter<EViewHolder> {

    private List<String> mData = MockData.DATA;

    @Override
    public EViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.e_item, parent, false);
        return new EViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EViewHolder holder, int position) {
        holder.textView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class EViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        EViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.e_textView);
        }
    }
}
