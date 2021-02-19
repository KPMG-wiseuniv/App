package com.KPMG_wiseuniv.fitting_room;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL="api server";

    public static RetrofitAPI getApiService(){
        return getInstance().create(RetrofitAPI.class);
    }
    private static Retrofit getInstance(){
        OkHttpClient okHttpClient=new OkHttpClient().newBuilder()
                .connectTimeout(150, TimeUnit.SECONDS)
                .readTimeout(150, TimeUnit.SECONDS)
                .writeTimeout(150, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build();
        Gson gson=new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }
}
