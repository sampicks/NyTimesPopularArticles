package com.nytimes.populararticles.ui.activity;

import android.app.Activity;
import android.os.RemoteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.RequiresDevice;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.nytimes.populararticles.R;
import com.nytimes.populararticles.ui.fragments.views.ArticleListFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testUI() {
        Activity activity = activityTestRule.getActivity();
        assertNotNull(activity.findViewById(R.id.toolbar));
        assertNotNull(activity.findViewById(R.id.container));
    }

    @Test
    public void testFragmentExistence() {
        Activity activity = activityTestRule.getActivity();
        ArticleListFragment articleListFragment = ((MainActivity) activity).mArticleListFragment;
        assertNotNull(activity);
        assertNotNull(articleListFragment);
    }

    @Test
    public void testToolbar() {
        Activity activity = activityTestRule.getActivity();
        Toolbar toolbarView = activity.findViewById(R.id.toolbar);
        assertTrue(toolbarView.isShown());
        assertEquals(InstrumentationRegistry.getTargetContext().getString(R.string.popular_articles), toolbarView.getTitle());
    }
}