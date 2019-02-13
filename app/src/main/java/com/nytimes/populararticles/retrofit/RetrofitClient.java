package com.nytimes.populararticles.retrofit;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * The type Retrofit client.
 */
public class RetrofitClient {


    /**
     * empty private constructor
     */
    private RetrofitClient() {
    }

    /**
     * Gets retrofit.
     *
     * @return the retrofit
     */
    public final static Retrofit getRetrofitClient() {

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

    /**
     * The constant retrofit.
     */
    private static Retrofit retrofit = null;

    private final static String BASE_URL = "http://api.nytimes.com/";
}
