package com.nytimes.populararticles.retrofit;

import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Retrofit client.
 */
public class RetrofitClient {

    private final static String BASE_URL = "http://api.nytimes.com/";
    /**
     * The constant retrofit.
     */
    public static Retrofit retrofit;

    /**
     * Retrofit client.
     */
    public void RetrofitClient() {

    }

    /**
     * Gets retrofit.
     *
     * @return the retrofit
     */
    public static Retrofit getRetrofit() {

        if (retrofit == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();

        }

        return retrofit;
    }
}
