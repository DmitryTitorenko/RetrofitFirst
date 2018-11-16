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
 * <p>
 * Create corresponding user api for interaction with server;
 * Each call yields its own HTTP request and response pair.
 */
public interface UserAPI {

    /**
     * Registration user.
     *
     * @param userRegPOST user for registration .
     */
    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("user")
    Call<UserRegResponse> regUser(@Body UserRegPOST userRegPOST);

    /**
     * Log In user.
     *
     * @param userLogInPOST user for login .
     */
    @Headers({"Content-Type: application/json", "Accepts: application/json"})
    @POST("user/login")
    Call<UserLogInResponse> logInUser(@Body UserLogInPOST userLogInPOST);
}
