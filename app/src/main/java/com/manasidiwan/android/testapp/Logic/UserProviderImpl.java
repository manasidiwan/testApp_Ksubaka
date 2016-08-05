package com.manasidiwan.android.testapp.Logic;

import android.content.Context;

import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;

import javax.inject.Inject;

import roboguice.RoboGuice;
import rx.Observable;

/**
 * @author manasidiwan
 */
public class UserProviderImpl implements UserProvider {

    @Inject
    UserModel mModel;

    private Context mContext;

    @Inject
    public UserProviderImpl(Context context) {
        mContext = context;
        RoboGuice.getInjector(mContext).injectMembers(this);
    }

    @Override
    public Observable<Search> getSearchResults(String searchString) {
        return mModel.getSearchResults(searchString);
    }

    @Override
    public Observable<Movie> getMovie(String imdbID) {
        return mModel.getMovie(imdbID);
    }
}
