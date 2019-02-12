package com.nytimes.populararticles.ui.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimes.populararticles.ArticleDetailsListActivity;
import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.retrofit.responseModel.Result;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private RecyclerViewItemClickListener recyclerViewItemClickListener;
    private final List<Result> resultList;


    public ArticleListAdapter(RecyclerViewItemClickListener parent,
                              List<Result> items) {
        resultList = items;
        recyclerViewItemClickListener = parent;
    }

    @Override
    public ArticleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.articledetails_list_content, parent, false);
        return new ArticleListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArticleListAdapter.ViewHolder holder, int position) {
        holder.tvTitle.setText(resultList.get(position).getTitle());
        holder.tvPublishDate.setText(resultList.get(position).getPublishedDate());

        holder.itemView.setTag(resultList.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle;
        final TextView tvPublishDate;

        ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvPublishDate = (TextView) view.findViewById(R.id.tvPublishDate);
        }
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Result item = (Result) view.getTag();
            recyclerViewItemClickListener.onItemClick(item);
        }
    };

    public interface RecyclerViewItemClickListener {
        void onItemClick(Result result);
    }
}
