package com.zepto.zoovies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainMovieActivity extends AppCompatActivity implements View.OnClickListener, Callback<PopularMovies> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movie);

        Button btnApi = findViewById(R.id.btn_call_api);
        btnApi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getPopularMovies();
    }

    private void getPopularMovies() {
        Retrofit retrofit = Network.getInstance();
        MovieRequests requests = retrofit.create(MovieRequests.class);

        requests.getPopularMovies().enqueue(this);

    }

    @Override
    public void onResponse(Call<PopularMovies> call, Response<PopularMovies> response) {
        Log.d("OnResponse", response.body().total_results);
        if (response.isSuccessful()) {
            PopularMovies popularMovies = response.body();
            Log.d("MOvie name", popularMovies.results.get(0).title);
        }
    }

    @Override
    public void onFailure(Call<PopularMovies> call, Throwable t) {
        Log.d("onFailure", t.getLocalizedMessage());

    }
}
