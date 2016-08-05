package com.manasidiwan.android.testapp.UI.Detail.Impl;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.manasidiwan.android.testapp.R;
import com.manasidiwan.android.testapp.UI.Home.Impl.HomeActivity;

import roboguice.activity.RoboActionBarActivity;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class DetailActivity extends RoboActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(getApplicationContext());
        setContentView(R.layout.activity_home);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String movieId = getIntent().getStringExtra(HomeActivity.EXTRA_MOVIE_ID);
        DetailFragment fragment = DetailFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putSerializable(HomeActivity.EXTRA_MOVIE_ID, movieId);
        fragment.setArguments(bundle);
        ft.add(R.id.fragment_container, fragment, "DETAIL_FRAGMENT");
        ft.commit();
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
    }
}
