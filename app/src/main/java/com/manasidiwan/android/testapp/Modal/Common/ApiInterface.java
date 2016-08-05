package com.manasidiwan.android.testapp.Modal.Common;


import com.manasidiwan.android.testapp.Modal.Movie;
import com.manasidiwan.android.testapp.Modal.Search;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * @author manasidiwan
 */
public interface ApiInterface {

    @GET("/")
    Observable<Search> getSearchResults(@Query("s") String searchString);

    @GET("/")
    Observable<Movie> getMovie(@Query("i") String imdbID);
}
