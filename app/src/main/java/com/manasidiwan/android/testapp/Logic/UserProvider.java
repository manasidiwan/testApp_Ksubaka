package com.manasidiwan.android.testapp.Logic;


import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;

import rx.Observable;

/**
 * @author manasidiwan on 01/08/2016.
 */
public interface UserProvider {

    Observable<Search> getSearchResults(String searchString);

    Observable<Movie> getMovie(String imdbID);

}
