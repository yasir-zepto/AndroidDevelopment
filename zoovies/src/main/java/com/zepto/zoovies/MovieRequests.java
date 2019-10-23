package com.zepto.zoovies;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Junaid on 23,Oct,2019
 */
public interface MovieRequests {

    @GET("movie/popular")
    Call<PopularMovies> getPopularMovies();

}
