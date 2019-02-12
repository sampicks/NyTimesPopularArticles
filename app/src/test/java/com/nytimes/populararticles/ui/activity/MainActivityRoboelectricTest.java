package com.nytimes.populararticles.ui.activity;

import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.nytimes.populararticles.BuildConfig;
import com.nytimes.populararticles.R;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainActivityRoboelectricTest {

    private MainActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    @Ignore
    public void clickButton() {
        Toolbar toolbar = activity.findViewById(R.id.toolbar);
        assertNotNull("Toolbar could not be found", toolbar);
        assertNotNull("content framelayout not found", activity.findViewById(R.id.container));
    }
}