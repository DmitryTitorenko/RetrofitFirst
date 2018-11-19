package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.image.ImageResponse;
import com.example.retrofitfirst.entity.image.ImageSend;
import com.example.retrofitfirst.entity.user.UserLogInResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * Create corresponding image api for interaction with server.
 */
public interface ImageAPI {

    /**
     * Send image in BASE6 format and get FID (File ID) this image.
     *
     * @param imageSend image in BASE6 to send.
     * @param headers   store dynamic request headers (X-CSRF-Token and Cookie)
     */
    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("file")
    Call<ImageResponse> saveImagePost(@Body ImageSend imageSend,
                                      @HeaderMap Map<String, String> headers);
}