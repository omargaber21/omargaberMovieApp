
package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MovieTrailers implements Serializable {

    @SerializedName("id")
    private Long mId;
    @SerializedName("results")
    private List<MovieTrailersResult> mMovieTrailersResults;

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public List<MovieTrailersResult> getResults() {
        return mMovieTrailersResults;
    }

    public void setResults(List<MovieTrailersResult> movieTrailersResults) {
        mMovieTrailersResults = movieTrailersResults;
    }

}
