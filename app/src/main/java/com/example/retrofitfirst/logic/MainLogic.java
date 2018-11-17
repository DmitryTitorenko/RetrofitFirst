package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;

import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.api.UserAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * It's Singleton
 */
public class MainLogic {

    private static MainLogic instance;

    private static final String BASE_URL = "http://dinotest.art-coral.com/rest/";
    private ImageAPI imageAPI;
    private UserAPI userAPI;
    private DinoAPI dinoAPI;

    private Retrofit retrofit;

    private MainLogic() {

    }

    public static MainLogic getInstance() {
        if (instance == null) {
            return instance = new MainLogic();
        } else return instance;
    }


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
    }

    public void getDinos() {
        dinoAPI = retrofit.create(DinoAPI.class);
        DinoLogic.getDinos(dinoAPI);
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