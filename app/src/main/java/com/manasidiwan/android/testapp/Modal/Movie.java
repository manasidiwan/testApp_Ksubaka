package com.manasidiwan.android.testapp.Modal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * @author manasidiwan on 02/08/2016.
 */
public class Movie implements Serializable {

    @SerializedName("imdbID")
    private String mImdbId;
    @SerializedName("Title")
    private String mTitle;
    @SerializedName("Year")
    private String mYear;
    @SerializedName("Rated")
    private String mRated;
    @SerializedName("Released")
    private String mReleased;
    @SerializedName("Runtime")
    private String mRuntime;
    @SerializedName("Genre")
    private String mGenre;
    @SerializedName("Director")
    private String mDirecor;
    @SerializedName("Poster")
    private String mPoster;
    @SerializedName("Plot")
    private String mPlot;

    public void setImdbId(String imdbId) {
        this.mImdbId = imdbId;
    }

    public String getImdbId() {
        return mImdbId;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setYear(String year) {
        this.mYear = year;
    }

    public String getYear() {
        return mYear;
    }

    public String getRated() {
        return mRated;
    }

    public void setRated(String rated) {
        this.mRated = rated;
    }

    public String getReleased() {
        return mReleased;
    }

    public void setReleased(String released) {
        this.mReleased = released;
    }

    public void setRuntime(String runtime) {
        this.mRuntime = runtime;
    }

    public String getRuntime() {
        return mRuntime;
    }

    public void setGenre(String genre) {
        this.mGenre = genre;
    }

    public String getGenre() {
        return mGenre;
    }

    public void setDirector(String director) {
        this.mDirecor = director;
    }

    public String getDirector() {
        return mDirecor;
    }


    public void setPoster(String poster) {
        this.mPoster = poster;
    }

    public String getPoster() {
        return mPoster;
    }

    public void setPlot(String plot) {
        this.mPlot = plot;
    }

    public String getPlot() {
        return mPlot;
    }

}
