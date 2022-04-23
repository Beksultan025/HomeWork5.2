package com.example.lesson52.data.remote;

import com.example.lesson52.data.models.Post;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PostApi {

    @GET("/posts")
    Call<List<Post>> getPosts();

    @POST("/posts")
    Call<Post> createPost(@Body Post post);

    @PUT("/posts/{id}")
    Call<ResponseBody> update(@Path("id") int id, @Body Post post);

    @DELETE("/posts/{id}")
    Call<ResponseBody> delete(@Path("id") int id);
}
