package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.dino.DinoWrapper;
import com.example.retrofitfirst.entity.dino.create.DinoCreate;
import com.example.retrofitfirst.entity.dino.create.DinoResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * Create corresponding dino api for interaction with server.
 */
public interface DinoAPI {

    @GET("dinos")
    Call<DinoWrapper> loadDinos();

    /**
     * Send image in BASE6 format and get FID (File ID) this image.
     *
     * @param dinoCreate entity dino to send.
     * @param headers   store dynamic request headers (X-CSRF-Token and Cookie)
     */
    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("node")
    Call<DinoResponse> createDino(@Body DinoCreate dinoCreate,
                                     @HeaderMap Map<String, String> headers);
}

