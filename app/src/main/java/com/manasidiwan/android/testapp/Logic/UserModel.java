package com.manasidiwan.android.testapp.Logic;

import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;

import rx.Observable;

/**
 * @author manasidiwan.
 */
public interface UserModel {

    Observable<Search> getSearchResults(String searchString);

    Observable<Movie> getMovie(String imdbId);


}
