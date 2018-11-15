package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.DinoWrapper;
import com.example.retrofitfirst.entity.image.ImagePost;
import com.example.retrofitfirst.entity.user.UserPost;
import com.example.retrofitfirst.entity.user.UserSend;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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


    public void sendImage() {//add Bitmap bitmap
        //add         this.bitmap = bitmap;
        String filename = "dinosaur_PNG1657188.jpg";
        String targetUri = "pictures/dinosaur_PNG1657188.jpg";
        String filemime = "image/jpeg";
        String file = ConvertBitmapToString(bitmap);
        String filesize = "22803";

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
                    public void onFailure(Call<ImagePost> call, Throwable t) {
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
                .enqueue(new Callback<UserPost>() {
                    @Override
                    public void onResponse(Call<UserPost> call, Response<UserPost> response) {
                        Log.i(TAG, "response");
                        if (response.isSuccessful()) {
                            Log.i(TAG, "works user");
                            Log.i(TAG, response.body().getUid());
                            Log.i(TAG, response.body().getUri());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserPost> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }


    //method to convert the selected image to base64 encoded string
    public static String ConvertBitmapToString(Bitmap bitmap) {
        String encodedImage = "";

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        try {
            encodedImage = URLEncoder.encode(Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedImage;
    }
}