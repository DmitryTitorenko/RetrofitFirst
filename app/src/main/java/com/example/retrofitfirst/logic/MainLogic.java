package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;

import com.example.retrofitfirst.AuthorizationActivity;
import com.example.retrofitfirst.ViewDinoAdapter;
import com.example.retrofitfirst.api.DinoAPI;
import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.api.UserAPI;
import com.example.retrofitfirst.entity.dino.create.FieldDinoAbout;
import com.example.retrofitfirst.entity.dino.create.FieldDinoBirthDate;
import com.example.retrofitfirst.entity.dino.create.FieldDinoColor;
import com.example.retrofitfirst.entity.dino.create.FieldDitoImage;
import com.example.retrofitfirst.entity.user.UserLogInResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import androidx.recyclerview.widget.RecyclerView;
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

    private String imageFID;


    private UserLogInResponse userLogInResponse;

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

    public void getDinos(ViewDinoAdapter viewDinoAdapter, RecyclerView rvDinos) {
        dinoAPI = retrofit.create(DinoAPI.class);
        DinoLogic.getDinos(dinoAPI, viewDinoAdapter, rvDinos);
    }


    public void sendImage(Bitmap bitmap, String filemime, String fileName) {

        imageAPI = retrofit.create(ImageAPI.class);
        ImageLogic imageLogic = new ImageLogic();
        imageLogic.sendImage(imageAPI, bitmap, filemime, fileName);
    }

    public void sendDino(String title,
                         String status,
                         String name,
                         String type,
                         FieldDinoColor fieldDinoColor,
                         FieldDinoAbout fieldDinoAbout,
                         FieldDinoBirthDate fieldDinoBirthDate,
                         FieldDitoImage fieldDitoImage) {
        dinoAPI = retrofit.create(DinoAPI.class);
        DinoLogic dinoLogic = new DinoLogic();
        dinoLogic.sendDino(dinoAPI,
                title,
                status,
                name,
                type,
                fieldDinoColor,
                fieldDinoAbout,
                fieldDinoBirthDate,
                fieldDitoImage);
    }


    public void regUserStart(String name, String mail, String pass) {

        userAPI = retrofit.create(UserAPI.class);
        UserLogic.regUser(userAPI, name, mail, pass);
    }

    public void userLogInStart(String name, String password, AuthorizationActivity authorizationActivity) {

        userAPI = retrofit.create(UserAPI.class);
        UserLogic.logInUser(userAPI, name, password, authorizationActivity);

    }


    public UserLogInResponse getUserLogInResponse() {
        return userLogInResponse;
    }

    public void setUserLogInResponse(UserLogInResponse userLogInResponse) {
        this.userLogInResponse = userLogInResponse;
    }

    public String getImageFID() {
        return imageFID;
    }

    public void setImageFID(String imageFID) {
        this.imageFID = imageFID;
    }
}