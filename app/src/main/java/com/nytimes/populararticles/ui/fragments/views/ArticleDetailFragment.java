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
import com.nytimes.populararticles.retrofit.responsemodel.Result;

/**
 * Simple View fragment, not following mvp pattern here.
 *
 * @author peeyooshkhare
 * A simple {@link Fragment} subclass.
 * @version 1.0
 */
public class ArticleDetailFragment extends Fragment {

    public static final String TAG = "ArticleDetailFragment";

    public static final String KEY_RESULT = "key_result";

    private Result result = null;

    /**
     * A static method to instantiate a fragment
     *
     * @param bundle used to get parcelable data from caller
     * @return a fragment
     */
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

    /**
     * A static method to instantiate a fragment
     *
     * @param inflater used to inflate view
     * @return a fragment
     */
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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
        tvSourceDetails.setText(String.format("%1s%2s", getString(R.string.source), result.getSource()));
        tvPublishDateDetails.setText(result.getPublishedDate());
    }


}
