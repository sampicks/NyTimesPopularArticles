package com.nytimes.populararticles;

import com.nytimes.populararticles.ui.fragments.views.ArticleDetailFragment;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArticleDetailFragmentUnitTest {

    private ArticleDetailFragment articleDetailFragment;

    @Before
    public void setup() {
        articleDetailFragment = new ArticleDetailFragment();
    }

    @Test
    public void testExistenceOfFragment() {
        Assert.assertNotNull(articleDetailFragment);
        Assert.assertEquals(ArticleDetailFragment.class.getSimpleName(), ArticleDetailFragment.TAG);
    }

    @After
    public void tearDown() {
        articleDetailFragment = null;
    }
}
