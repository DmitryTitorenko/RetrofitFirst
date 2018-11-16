package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.user.UserLogInPOST;
import com.example.retrofitfirst.entity.user.UserLogInResponse;
import com.example.retrofitfirst.entity.user.UserRegResponse;
import com.example.retrofitfirst.entity.user.UserRegPOST;

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
    Call<UserRegResponse> regUser(@Body UserRegPOST userRegPOST);

    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("user/login")
    Call<UserLogInResponse> logInUser(@Body UserLogInPOST userLogInPOST);
}
