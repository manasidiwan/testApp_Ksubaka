package com.manasidiwan.android.testapp.UI.Home;


import com.manasidiwan.android.testapp.Modal.Movie;

/**
 * Created by manasidiwan on 01/08/2016.
 */
public interface HomePresenter {

    void onViewAttach(HomeView view);

    void onViewDetach();

    void movieClicked(Movie movie);

    void fetchSearchResults(String searchString);
}
