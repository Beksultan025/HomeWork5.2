package com.example.lesson52.data;

import android.app.Application;

import com.example.lesson52.data.remote.PostApi;
import com.example.lesson52.data.remote.PostApiClient;
import com.example.lesson52.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static PostApi api;
    public static PostApiClient postApiClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createApi();
        postApiClient = new PostApiClient(api);
    }
}
