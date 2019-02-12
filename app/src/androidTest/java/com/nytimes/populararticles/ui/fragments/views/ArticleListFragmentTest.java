package com.nytimes.populararticles.ui.fragments.views;

import com.nytimes.populararticles.ui.fragments.presenter.ArticleListPresenterImpl;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class ArticleListFragmentTest {


    @Test
    public void test_FetchData(){
        ArticleListPresenterImpl articleListPresenter = mock(ArticleListPresenterImpl.class);
        articleListPresenter.fetchData();
    }

}