package com.shakil.test_blod.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @GET("DSN7")
    Call<List<PostPojo>> getposts();

    @POST("DSN7")
    Call<PostPojo> creat_post(@Body PostPojo postPojo);

}