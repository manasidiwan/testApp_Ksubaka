package com.manasidiwan.android.testapp.UI.Home;

import com.manasidiwan.android.testapp.Modal.Movie;

import java.util.List;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface HomeView {

    void showList(List<Movie> posts);

    void openDetailView(Movie post);
}
