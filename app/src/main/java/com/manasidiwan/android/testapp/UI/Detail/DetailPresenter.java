package com.manasidiwan.android.testapp.UI.Detail;

/**
 * @author manasidiwan on 01/08/2016.
 */
public interface DetailPresenter {

    void onViewAttach(DetailView view);

    void onViewDetach();

    void prepareData(String movieId);

    void fetchMovie(String movieId);

}
