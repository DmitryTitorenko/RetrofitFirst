package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.image.ImageResponse;
import com.example.retrofitfirst.entity.image.ImageSend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public interface ImageAPI {

    @Headers({"Content-Type: application/json","Accepts: application/json"})
    @POST("file")
    Call<ImageResponse> saveImagePost(@Body ImageSend imageSend);
}