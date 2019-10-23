package com.zepto.zoovies;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Junaid on 23,Oct,2019
 */
public class RequestInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl url = original.url().newBuilder().addQueryParameter("api_key", Constants.api_key).build();
        Request updated = original.newBuilder().url(url).build();
        return chain.proceed(updated);
    }
}
