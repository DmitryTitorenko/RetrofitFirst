package com.example.retrofitfirst.logic;

import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.entity.DinoWrapper;
import com.example.retrofitfirst.entity.image.ImagePost;
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
    private ImageAPI imageAPI;

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        /*
        //get dinos
        DinoAPI dinoAPI = retrofit.create(DinoAPI.class);

        Call<DinoWrapper> call = dinoAPI.loadDinos();
        call.enqueue(this);*/


        //get image
        imageAPI = retrofit.create(ImageAPI.class);
        sendImage();
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


    public void sendImage() {
        String filename = "dinosaur_PNG16571";
        String targetUri = "pictures/dinosaur_PNG16571";
        String filemime = "image/png";
        String file = "";
        String filesize = "307239";

        imageAPI.saveImagePost(
                filename,
                targetUri,
                filemime,
                file,
                filesize)
                .enqueue(new Callback<ImagePost>() {
                    @Override
                    public void onResponse(Call<ImagePost> call, Response<ImagePost> response) {

                        if (response.isSuccessful()) {
                            System.out.println("works Image");
                            System.out.println(response.body().getFid());
                            System.out.println(response.body().getUri());
                        }
                    }

                    @Override
                    public void onFailure(Call<ImagePost> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}