package com.nytimes.populararticles.ui.fragments.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.retrofit.responseModel.Result;

import java.util.List;

/**
 * The type Article list adapter.
 *
 * @author peeyooshkhare A simple implementation class of {@link RecyclerView.Adapter}
 * @version 1.0
 */
public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.ViewHolder> {

    private RecyclerViewItemClickListener recyclerViewItemClickListener;
    private final List<Result> resultList;


    /**
     * Instantiates a new Article list adapter.
     *
     * @param parent the parent
     * @param items  the items
     */
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
        holder.tvBylines.setText(resultList.get(position).getByline());

        holder.itemView.setTag(resultList.get(position));
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return resultList.size();
    }

    /**
     * The type View holder.
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * The Tv title.
         */
        final TextView tvTitle;
        /**
         * The Tv publish date.
         */
        final TextView tvPublishDate;
        /**
         * The Tv bylines.
         */
        final TextView tvBylines;

        /**
         * Instantiates a new View holder.
         *
         * @param view the view
         */
        ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tvTitle);
            tvPublishDate = (TextView) view.findViewById(R.id.tvPublishDate);
            tvBylines = (TextView) view.findViewById(R.id.tvBylines);
        }
    }

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Result item = (Result) view.getTag();
            recyclerViewItemClickListener.onItemClick(item);
        }
    };

    /**
     * The interface Recycler view item click listener.
     */
    public interface RecyclerViewItemClickListener {
        /**
         * On item click.
         *
         * @param result the result
         */
        void onItemClick(Result result);
    }
}
