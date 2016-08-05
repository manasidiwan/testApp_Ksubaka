package com.manasidiwan.android.testapp.UI.Detail.Impl;

import android.content.Context;

import com.manasidiwan.android.testapp.Logic.UserProvider;
import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.UI.Detail.DetailPresenter;
import com.manasidiwan.android.testapp.UI.Detail.DetailView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * @author manasidiwan on 01/08/2016.
 */
public class DetailPresenterImpl implements DetailPresenter {

    @Inject
    UserProvider mProvider;

    private DetailView mView;
    private Context mContext;

    @Override
    public void onViewDetach() {
        mView = null;
    }

    @Override
    public void onViewAttach(DetailView view) {
        mView = view;
    }


    @Override
    public void fetchMovie(String movieId) {
        Observable<Movie> observable = mProvider.getMovie(movieId);
        Observer observer = new Observer<Movie>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Movie movie) {
                mView.updateMovieDetails(movie);
            }
        };

        observable.subscribe(observer);
    }

    @Override
    public void prepareData(String movieId) {
        fetchMovie(movieId);
    }
}
