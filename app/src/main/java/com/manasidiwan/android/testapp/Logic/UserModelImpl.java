package com.manasidiwan.android.testapp.Logic;

import android.content.Context;

import com.manasidiwan.android.testapp.Modal.Common.ApiClient;
import com.manasidiwan.android.testapp.Modal.Common.ApiInterface;
import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public class UserModelImpl implements UserModel {

    private Context mContext;

    @Inject
    public UserModelImpl(Context context) {
        mContext = context;
    }

    @Override
    public Observable<Search> getSearchResults(String searchString) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        return apiService.getSearchResults(searchString)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }

    @Override
    public Observable<Movie> getMovie(String imdbId) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        return apiService.getMovie(imdbId)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .asObservable();
    }
}
