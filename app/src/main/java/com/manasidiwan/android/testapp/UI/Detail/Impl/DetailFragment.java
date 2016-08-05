package com.manasidiwan.android.testapp.UI.Detail.Impl;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.R;
import com.manasidiwan.android.testapp.UI.Detail.DetailPresenter;
import com.manasidiwan.android.testapp.UI.Detail.DetailView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.manasidiwan.android.testapp.UI.Home.Impl.HomeActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import roboguice.fragment.RoboFragment;

/**
 * @author manasidiwan on 01/08/2016.
 */
public class DetailFragment extends RoboFragment implements DetailView {

    public static DetailFragment newInstance() {
        return new DetailFragment();
    }


    @Inject
    DetailPresenter mPresenter;


    private GridLayoutManager mLayoutManager;


    @Bind(R.id.movie_title)
    TextView mMovieTitle;

    @Bind(R.id.plot)
    TextView mPlot;

    @Bind(R.id.director)
    TextView mDirector;

    @Bind(R.id.item_image)
    public SimpleDraweeView mImageView;

    private String mMovieId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovieId = getArguments().getString(HomeActivity.EXTRA_MOVIE_ID);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.prepareData(mMovieId);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onViewAttach(this);
    }


    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onViewDetach();
    }

    @Override
    public void updateMovieDetails(Movie movie) {
        Uri imageUri = Uri.parse(movie.getPoster());
        mImageView.setImageURI(imageUri);
        mMovieTitle.setText(movie.getTitle());
        mPlot.setText(movie.getPlot());
        mDirector.setText(movie.getDirector());
    }
}
