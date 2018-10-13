package com.antelope.android.tablayout.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.antelope.android.tablayout.MyApplication;
import com.antelope.android.tablayout.R;
import com.antelope.android.tablayout.json.data_item;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.ViewHolder> {

    private List<data_item> mDataItemList;

    public RecAdapter(List<data_item> dataItemList) {
        mDataItemList = dataItemList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivNews;
        TextView tvNews;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivNews = itemView.findViewById(R.id.ivNews);
            tvNews = itemView.findViewById(R.id.tvNews);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rec_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        data_item dataItem = mDataItemList.get(position);
        viewHolder.tvNews.setText(dataItem.getTitle());
        Glide.with(MyApplication.getContext()).load(dataItem.getThumbnail_pic_s()).into(viewHolder.ivNews);
    }

    @Override
    public int getItemCount() {
        return mDataItemList.size();
    }


}
