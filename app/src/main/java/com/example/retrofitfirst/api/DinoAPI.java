package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.dino.DinoWrapper;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * Create corresponding dino api for interaction with server.
 */
public interface DinoAPI {

    @GET("dinos")
    Call<DinoWrapper> loadDinos();
}

