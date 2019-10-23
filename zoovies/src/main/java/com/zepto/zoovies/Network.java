package com.zepto.zoovies;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

/**
 * Created by Junaid on 23,Oct,2019
 */
public class Network {

    private static String baseUrl = "https://api.themoviedb.org/3/";

    private static Retrofit retrofit;

    private Network() {

    }


    public static Retrofit getInstance() {
        if (retrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new RequestInterceptor()).build();
            retrofit = new Retrofit
                    .Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
