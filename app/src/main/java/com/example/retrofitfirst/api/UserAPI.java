package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.user.UserPost;
import com.example.retrofitfirst.entity.user.UserSend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public interface UserAPI {

    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("user")
    Call<UserPost> saveUser(@Body UserSend userSend);
}
