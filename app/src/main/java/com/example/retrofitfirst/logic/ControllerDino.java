package com.example.retrofitfirst.logic;

import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.entity.DinoWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public class ControllerDino implements Callback<DinoWrapper> {

    private static final String BASE_URL = "http://dinotest.art-coral.com/rest/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        DinoAPI dinoAPI = retrofit.create(DinoAPI.class);

        Call<DinoWrapper> call = dinoAPI.loadDinos();
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<DinoWrapper> call, Response<DinoWrapper> response) {
        if (response.isSuccessful()) {
            DinoWrapper dinoWrapper = response.body();
            System.out.println(dinoWrapper.getDinos());
            dinoWrapper.getDinos().forEach(dino -> System.out.println("Dino title: " + dino.getDino().getDinoTitle()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<DinoWrapper> call, Throwable t) {
        t.printStackTrace();
    }
}