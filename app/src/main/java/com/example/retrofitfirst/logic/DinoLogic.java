package com.example.retrofitfirst.logic;

import android.util.Log;

import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.entity.dino.DinoWrapper;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 17.11.2018.
 */
public class DinoLogic {

    private static final String TAG = "MyLog";

    private static DinoWrapper dinoWrapper;


    public static void getDinos(DinoAPI dinoAPI) {

        Call<DinoWrapper> call = dinoAPI.loadDinos();

        call.enqueue(new Callback<DinoWrapper>() {
            @Override
            public void onResponse(Call<DinoWrapper> call, Response<DinoWrapper> response) {
                if (response.isSuccessful()) {

                    dinoWrapper = response.body();

                    Log.i(TAG, "get Dino correct");
                    Log.i(TAG, response.body().getDinos().get(0).getDino().getDinoTitle());

                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<DinoWrapper> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    public static DinoWrapper getDinoWrapper() {
        return dinoWrapper;
    }
}
