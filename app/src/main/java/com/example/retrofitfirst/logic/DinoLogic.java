package com.example.retrofitfirst.logic;

import android.util.Log;

import com.example.retrofitfirst.ViewDinoAdapter;
import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.entity.dino.get.DinoWrapper;
import com.example.retrofitfirst.entity.dino.create.DinoCreate;
import com.example.retrofitfirst.entity.dino.create.DinoResponse;
import com.example.retrofitfirst.entity.dino.create.FieldDinoAbout;
import com.example.retrofitfirst.entity.dino.create.FieldDinoBirthDate;
import com.example.retrofitfirst.entity.dino.create.FieldDinoColor;
import com.example.retrofitfirst.entity.dino.create.FieldDitoImage;
import com.example.retrofitfirst.entity.user.UserLogInResponse;


import java.util.HashMap;
import java.util.Map;

import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 17.11.2018.
 */
public class DinoLogic {

    private static final String TAG = "MyLog";

    private static DinoWrapper dinoWrapper;
    private UserLogInResponse userLogInResponse;


    public static void getDinos(DinoAPI dinoAPI, ViewDinoAdapter viewDinoAdapter, RecyclerView rvDinos) {

        Call<DinoWrapper> call = dinoAPI.loadDinos();

        call.enqueue(new Callback<DinoWrapper>() {
            @Override
            public void onResponse(Call<DinoWrapper> call, Response<DinoWrapper> response) {
                if (response.isSuccessful()) {

                    dinoWrapper = response.body();

                    // update dinoWrapper
                    viewDinoAdapter.setDinoWrapper(dinoWrapper);

                    // notify adapter about it
                    rvDinos.getAdapter().notifyDataSetChanged();

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


    public void sendDino(DinoAPI dinoAPI,
                         String title,
                         String status,
                         String name,
                         String type,
                         FieldDinoColor fieldDinoColor,
                         FieldDinoAbout fieldDinoAbout,
                         FieldDinoBirthDate fieldDinoBirthDate,
                         FieldDitoImage fieldDitoImage) {

        userLogInResponse = MainLogic.getInstance().getUserLogInResponse();

        //create Headers
        Map<String, String> map = new HashMap<>();

        map.put("X-CSRF-Token", userLogInResponse.getToken());
        map.put("Cookie", userLogInResponse.getSessionName() + "=" + userLogInResponse.getSessid());

        DinoCreate dinoCreate = new DinoCreate();

        dinoCreate.setTitle(title);
        dinoCreate.setStatus(status);
        dinoCreate.setName(name);
        dinoCreate.setType(type);
        dinoCreate.setFieldDinoColor(fieldDinoColor);
        dinoCreate.setFieldDinoAbout(fieldDinoAbout);
        dinoCreate.setFieldDinoBirthDate(fieldDinoBirthDate);
        dinoCreate.setFieldDitoImage(fieldDitoImage);


        dinoAPI.createDino(dinoCreate, map)
                .enqueue(new Callback<DinoResponse>() {
                    @Override
                    public void onResponse(Call<DinoResponse> call, Response<DinoResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "works create Dino");
                            Log.i(TAG, response.body().getUri());
                            Log.i(TAG, response.body().getNid());
                        }
                    }

                    @Override
                    public void onFailure(Call<DinoResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
