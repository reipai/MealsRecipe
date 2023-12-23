package com.reivai.mealrecipes.network;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.reivai.mealrecipes.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient extends Application {

    private static Retrofit retrofit;

    public static NetworkApi getNetworkClient() {
        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(NetworkApi.class);
    }

    public static OkHttpClient getClient() {
        Interceptor interceptor = chain -> {
            SystemClock.sleep(1000);
            return chain.proceed(chain.request());
        };

        return new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.MINUTES)
                .readTimeout(1, TimeUnit.MINUTES)
                .writeTimeout(1, TimeUnit.MINUTES)
                .addInterceptor(getLoggingInterceptor())
                .addNetworkInterceptor(interceptor)
                .build();
    }

    public static HttpLoggingInterceptor.Level getInterceptorLevel() {
        if (BuildConfig.DEBUG)
            return HttpLoggingInterceptor.Level.BODY;
        else
            return HttpLoggingInterceptor.Level.NONE;
    }

    public static HttpLoggingInterceptor getLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.level(getInterceptorLevel());
        return httpLoggingInterceptor;
    }

}
