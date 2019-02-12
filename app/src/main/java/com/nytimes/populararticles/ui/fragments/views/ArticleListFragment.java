package com.nytimes.populararticles.ui.fragments.views;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.widget.Toolbar;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.activity.MainActivity;
import com.nytimes.populararticles.ui.fragments.adapter.ArticleListAdapter;
import com.nytimes.populararticles.ui.fragments.mvp.FragmentViewPresenter;
import com.nytimes.populararticles.ui.fragments.presenter.ArticleListPresenterImpl;
import com.nytimes.populararticles.ui.retrofit.responseModel.ArticleListResponse;
import com.nytimes.populararticles.ui.retrofit.responseModel.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleListFragment extends Fragment implements FragmentViewPresenter.View<ArticleListResponse>, ArticleListAdapter.RecyclerViewItemClickListener {
    public static final String TAG = "ArticleListFragment";

    private RecyclerView mRecyclerView;
    private ArticleListAdapter adapter;

    public ArticleListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvArticles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        FragmentViewPresenter.Presenter presenter = new ArticleListPresenterImpl(getActivity(), this);
        presenter.fetchData();
    }

    @Override
    public void setData(ArticleListResponse articleListResponse) {
        if (articleListResponse != null && articleListResponse.getResults() != null && articleListResponse.getResults().size() > 0) {
            adapter = new ArticleListAdapter(this, articleListResponse.getResults());
            mRecyclerView.setAdapter(adapter);
        }

    }

    @Override
    public void displayError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(Result result) {
        Log.d(TAG, "onItemClick : " + result.getTitle());
        Bundle bundle = new Bundle();
        bundle.putParcelable(ArticleDetailFragment.KEY_RESULT, result);
        ArticleDetailFragment articleDetailFragment = ArticleDetailFragment.getInsance(bundle);
        ((MainActivity) getActivity()).addFragment(articleDetailFragment, ArticleDetailFragment.TAG, false);
    }
}