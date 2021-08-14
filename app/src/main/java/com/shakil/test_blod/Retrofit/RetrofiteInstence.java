package com.shakil.test_blod.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofiteInstence {

    private static Retrofit retrofit;
    private static final String BaseUrl="https://jsonkeeper.com/b/";

    public static Retrofit getRetrofit() {
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
