package com.nytimes.populararticles.ui.fragments.views;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.retrofit.responseModel.Result;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArticleDetailFragment extends Fragment {

    public static final String TAG = "ArticleDetailFragment";

    public static final String KEY_RESULT = "key_result";

    private Result result = null;

    public static ArticleDetailFragment getInsance(Bundle bundle) {
        ArticleDetailFragment articleDetailFragment = new ArticleDetailFragment();
        articleDetailFragment.setArguments(bundle);
        return articleDetailFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().getParcelable(KEY_RESULT) != null)
            result = getArguments().getParcelable(KEY_RESULT);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_article_detail, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tvTitleDetails = view.findViewById(R.id.tvTitleDetails);
        TextView tvAbstractDetails = view.findViewById(R.id.tvAbstractDetails);
        TextView tvSourceDetails = view.findViewById(R.id.tvSourceDetails);
        TextView tvPublishDateDetails = view.findViewById(R.id.tvPublishDateDetails);


        tvTitleDetails.setText(result.getTitle());
        tvAbstractDetails.setText(result.getAbstract());
        tvSourceDetails.setText(getString(R.string.source) + result.getSource());
        tvPublishDateDetails.setText(result.getPublishedDate());
    }


}
