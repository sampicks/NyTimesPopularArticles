package com.nytimes.populararticles.ui.activity;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.fragments.views.ArticleDetailFragment;
import com.nytimes.populararticles.ui.fragments.views.ArticleListFragment;

/**
 * The type Main activity.
 */
public class MainActivity extends AppCompatActivity {


    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    private ArticleListFragment mArticleListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configureLayout();
    }

    /**
     * method to find all references and setup basic requirement
     */
    private void configureLayout() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
        setTitleBar(getString(R.string.popular_articles));

        fragmentManager = getSupportFragmentManager();
        mArticleListFragment = new ArticleListFragment();
        addFragment(mArticleListFragment, ArticleListFragment.TAG, true);
    }

    /**
     * Sets title bar.
     *
     * @param title the title
     */
    public void setTitleBar(String title) {
        if (TextUtils.isEmpty(title)) return;
        getSupportActionBar().setTitle(title);
    }

    /**
     * method to add/replace fragment
     *
     * @param fragment               the fragment
     * @param tag                    the tag
     * @param isFirstFragmentInStack the is first fragment in stack
     */
    public void addFragment(@NonNull Fragment fragment, String tag, boolean isFirstFragmentInStack) {
        try {
            fragmentTransaction = fragmentManager.beginTransaction();
            if (!isFirstFragmentInStack) {
                fragmentTransaction.add(R.id.container, fragment, tag);
                fragmentTransaction.addToBackStack(tag);
            } else {
                fragmentTransaction.replace(R.id.container, fragment, tag);
            }

            fragmentTransaction.commitAllowingStateLoss();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
