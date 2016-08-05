package com.manasidiwan.android.testapp.UI.Home.Impl;

import android.content.Context;

import com.manasidiwan.android.testapp.Logic.UserProvider;
import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;
import com.manasidiwan.android.testapp.UI.Home.HomePresenter;
import com.manasidiwan.android.testapp.UI.Home.HomeView;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;

/**
 * @author manasidiwan
 */
public class HomePresenterImpl implements HomePresenter {

    @Inject
    UserProvider mProvider;

    private HomeView mView;
    private Context mContext;

    @Inject
    public HomePresenterImpl(Context context) {
        mContext = context;
    }

    @Override
    public void onViewAttach(HomeView view) {
        mView = view;
    }

    @Override
    public void onViewDetach() {
        mView = null;
    }

    @Override
    public void fetchSearchResults(String searchString) {
        Observable<Search> observable = mProvider.getSearchResults(searchString);
        Observer observer = new Observer<Search>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                //TODO: show error dialog fragment
            }

            @Override
            public void onNext(Search search) {
                mView.showList(search.getSearchResults());
            }
        };

        observable.subscribe(observer);
    }

    @Override
    public void movieClicked(Movie movie) {
        mView.openDetailView(movie);
    }
}
