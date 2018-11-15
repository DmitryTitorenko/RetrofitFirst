package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.DinoWrapper;
import com.example.retrofitfirst.entity.image.ImageResponse;
import com.example.retrofitfirst.entity.image.ImageSend;
import com.example.retrofitfirst.entity.user.UserResponse;
import com.example.retrofitfirst.entity.user.UserSend;
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
public class ControllerDino implements Callback<DinoWrapper> {
    private static final String TAG = "MyLog";

    private static final String BASE_URL = "http://dinotest.art-coral.com/rest/";
    private ImageAPI imageAPI;
    private UserAPI userAPI;

    Retrofit retrofit;

    private Bitmap bitmap;


    public void start() {
        this.bitmap = bitmap;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // for logging json
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



        /*
        //get image
        imageAPI = retrofit.create(ImageAPI.class);
        sendImage();*/

        /*
        //get user
        userAPI=retrofit.create(UserAPI.class);
        sendUser();*/

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

        ImageSend imageSend = new ImageSend();

        imageSend.setFileName("dinosaur_PNG1657188.jpg");
        imageSend.setTargetUri("pictures/dinosaur_PNG1657188.jpg");
        imageSend.setFileMime("image/jpeg");
        imageSend.setFile(ConvertBitmapToString.Convert(bitmap));
        imageSend.setFileSize("22803");

        /*
        String filename = "dinosaur_PNG1657188.jpg";
        String targetUri = "pictures/dinosaur_PNG1657188.jpg";
        String filemime = "image/jpeg";
        String file = ConvertBitmapToString.Convert(bitmap);
        String filesize = "22803";*/

        imageAPI.saveImagePost(imageSend)
                .enqueue(new Callback<ImageResponse>() {
                    @Override
                    public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "works Image");
                            Log.i(TAG, response.body().getFid());
                            Log.i(TAG, response.body().getUri());

                            /*
                            System.out.println("works Image");
                            System.out.println(response.body().getFid());
                            System.out.println(response.body().getUri());*/
                        }
                    }

                    @Override
                    public void onFailure(Call<ImageResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public void sendUser(String name, String mail, String pass) {
        userAPI = retrofit.create(UserAPI.class);
        UserSend userSend = new UserSend();
        userSend.setName(name);
        userSend.setMail(mail);
        userSend.setPass(pass);

        userAPI.saveUser(userSend)
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Log.i(TAG, "response");
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