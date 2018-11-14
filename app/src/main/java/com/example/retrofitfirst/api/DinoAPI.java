package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.DinoWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public interface DinoAPI {

    @GET("dinos")
    Call<DinoWrapper> loadDinos();
}

