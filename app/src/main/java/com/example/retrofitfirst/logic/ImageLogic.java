package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.entity.image.ImageResponse;
import com.example.retrofitfirst.entity.image.ImageSend;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class ImageLogic {

    private static final String TAG = "MyLog";

    /**
     * Send JSON to upload image and get response from server.
     *
     * @param imageAPI corresponding image api for interaction with server;
     * @param bitmap   image to upload.
     */
    public static void sendImage(ImageAPI imageAPI, Bitmap bitmap) {

        ImageSend imageSend = new ImageSend();

        imageSend.setFileName("dinosaur_PNG1657188.jpg");
        imageSend.setTargetUri("pictures/dinosaur_PNG1657188.jpg");
        imageSend.setFileMime("image/jpeg");
        imageSend.setFile(ConvertBitmapToString.Convert(bitmap));
        imageSend.setFileSize("22803");

        imageAPI.saveImagePost(imageSend)
                .enqueue(new Callback<ImageResponse>() {
                    @Override
                    public void onResponse(Call<ImageResponse> call, Response<ImageResponse> response) {

                        if (response.isSuccessful()) {
                            Log.i(TAG, "works Image");
                            Log.i(TAG, response.body().getFid());
                            Log.i(TAG, response.body().getUri());
                        }
                    }

                    @Override
                    public void onFailure(Call<ImageResponse> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
