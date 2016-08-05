package com.manasidiwan.android.testapp.UI.Home.Impl;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.manasidiwan.android.testapp.R;

import roboguice.activity.RoboActionBarActivity;

public class HomeActivity extends RoboActionBarActivity {

    public static String EXTRA_MOVIE_ID = "extra_movie_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, HomeFragment.newInstance(), "HOME_FRAGMENT");
        ft.commit();
    }
}
