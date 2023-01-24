package com.sarthi.myapplication.network;




import com.sarthi.myapplication.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sarthi on 06/09/17.
 */

public class ApiClient {

    private static Retrofit retrofit = null;
    public static ApiClient apiClient=null;


    /*
    * single instance
    * */
    public static ApiClient getInstance()
    {
        if(apiClient==null)
        {
            apiClient=new ApiClient();
        }
        return apiClient;

    }

    /*
    * creating retrofit object
    * */
    public Retrofit getClient() {
      //  if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build())
                    .build();
        //}
        return retrofit;
    }


    public Retrofit getClienttemp() {
       // if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BuildConfig.SERVER_URL)
                    .addConverterFactory(GsonConverterFactory.create()).client(httpClient.build())
                    .build();
       // }
        return retrofit;
    }

    /*
    * coupling retrofit with interface
    * */
    public ApiInterface getApiService() {
        return getClient().create(ApiInterface.class);

    }

    public ApiInterface getApiServicetemp()
    {
        return getClienttemp().create(ApiInterface.class);
    }

    public static OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60L, TimeUnit.SECONDS)
            .writeTimeout(60L, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));





}
