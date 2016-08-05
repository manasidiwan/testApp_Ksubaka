package com.manasidiwan.android.testapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by manasidiwan on 05/08/2016.
 */
public class Search {

    @SerializedName("Search")
    private List<Movie> mSearchList;

    public List<Movie> getSearchResults() {
        return mSearchList;
    }

    public void setSearchResults(List<Movie> searchResults) {
        this.mSearchList = searchResults;
    }
}
