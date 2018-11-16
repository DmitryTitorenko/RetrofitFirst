package com.example.retrofitfirst.logic;

import android.util.Log;

import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.user.UserLogInPOST;
import com.example.retrofitfirst.entity.user.UserLogInResponse;
import com.example.retrofitfirst.entity.user.UserRegResponse;
import com.example.retrofitfirst.entity.user.UserRegPOST;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class UserLogic {
    private static final String TAG = "MyLog";

    public static void regUser(UserAPI userAPI, String name, String mail, String pass) {

        UserRegPOST userRegPOST = new UserRegPOST();

        userRegPOST.setName(name);
        userRegPOST.setMail(mail);
        userRegPOST.setPass(pass);

        userAPI.regUser(userRegPOST)
                .enqueue(new Callback<UserRegResponse>() {
                    @Override
                    public void onResponse(Call<UserRegResponse> call, Response<UserRegResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "reg user correct");
                            Log.i(TAG, "getUid: " + response.body().getUid());
                            Log.i(TAG, "getUri: " + response.body().getUri());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserRegResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public static void logInUser(UserAPI userAPI, String username, String password) {

        UserLogInPOST userLogInPOST = new UserLogInPOST();

        userLogInPOST.setUsername(username);
        userLogInPOST.setPassword(password);

        userAPI.logInUser(userLogInPOST)

                // Asynchronously send the request and notify {@code callback} of its response form server.
                .enqueue(new Callback<UserLogInResponse>() {
                    @Override
                    public void onResponse(Call<UserLogInResponse> call, Response<UserLogInResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "logIn user correct");
                            Log.i(TAG, "user getSessid: " + response.body().getSessid());
                            Log.i(TAG, "user getSessionName: " + response.body().getSessionName());
                            Log.i(TAG, "user getToken: " + response.body().getToken());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserLogInResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
