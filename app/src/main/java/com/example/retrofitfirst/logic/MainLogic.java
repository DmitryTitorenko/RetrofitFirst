package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;

import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.dino.DinoWrapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public class MainLogic implements Callback<DinoWrapper> {
    private static final String TAG = "MyLog";

    private static final String BASE_URL = "http://dinotest.art-coral.com/rest/";
    private ImageAPI imageAPI;
    private UserAPI userAPI;

    private Retrofit retrofit;


    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // logging json
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        /*
        //get dinos
        DinoAPI dinoAPI = retrofit.create(DinoAPI.class);

        Call<DinoWrapper> call = dinoAPI.loadDinos();
        call.enqueue(this);*/
    }


    // get dinos
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

    public void sendImage(Bitmap bitmap) {

        imageAPI = retrofit.create(ImageAPI.class);
        ImageLogic.sendImage(imageAPI, bitmap);
    }

    public void regUserStart(String name, String mail, String pass) {

        userAPI = retrofit.create(UserAPI.class);
        UserLogic.regUser(userAPI, name, mail, pass);
    }

    public void userLogInStart(String name, String password) {

        userAPI = retrofit.create(UserAPI.class);
        UserLogic.logInUser(userAPI, name, password);

    }
}