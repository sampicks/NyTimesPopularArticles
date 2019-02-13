package com.nytimes.populararticles;

import com.nytimes.populararticles.ui.fragments.views.ArticleListFragment;

import org.junit.Assert;
import org.junit.Test;

public class ArticleListFragmentUnitTest {

    @Test
    public void testExistenceOfView() {
        ArticleListFragment fragment = new ArticleListFragment();
        Assert.assertNotNull(fragment);
        Assert.assertEquals(ArticleListFragment.class.getSimpleName(), ArticleListFragment.TAG);
    }
}
