package com.sarthi.myapplication.network;


import static com.sarthi.myapplication.network.NetworkConstants.GET_TOP_PLAYERS;

import com.sarthi.myapplication.model.AllResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface ApiInterface {




    @GET(GET_TOP_PLAYERS)
    Call<ResponseBody> getALlData();



}
