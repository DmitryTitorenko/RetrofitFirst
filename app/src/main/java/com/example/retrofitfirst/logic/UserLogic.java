package com.example.retrofitfirst.logic;

import android.util.Log;

import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.user.UserResponse;
import com.example.retrofitfirst.entity.user.UserSend;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class UserLogic {
    private static final String TAG = "MyLog";

    public static void sendUser(UserAPI userAPI, String name, String mail, String pass) {

        UserSend userSend = new UserSend();

        userSend.setName(name);
        userSend.setMail(mail);
        userSend.setPass(pass);

        userAPI.saveUser(userSend)
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "works user");
                            Log.i(TAG, response.body().getUid());
                            Log.i(TAG, response.body().getUri());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
