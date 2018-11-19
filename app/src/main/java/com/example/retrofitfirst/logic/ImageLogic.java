package com.example.retrofitfirst.logic;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.retrofitfirst.api.ImageAPI;
import com.example.retrofitfirst.entity.image.ImageResponse;
import com.example.retrofitfirst.entity.image.ImageSend;
import com.example.retrofitfirst.entity.user.UserLogInResponse;

import java.util.HashMap;
import java.util.Map;

import androidx.core.graphics.BitmapCompat;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class ImageLogic {

    private UserLogInResponse userLogInResponse;

    private static final String TAG = "MyLog";

    /**
     * Send JSON to upload image and get response from server.
     *
     * @param imageAPI corresponding image api for interaction with server;
     * @param bitmap   image to upload.
     */
    public void sendImage(ImageAPI imageAPI, Bitmap bitmap, String filemime, String fileName) {

        userLogInResponse = MainLogic.getInstance().getUserLogInResponse();
        //create Headers
        Map<String, String> map = new HashMap<>();

        map.put("X-CSRF-Token", userLogInResponse.getToken());
        map.put("Cookie", userLogInResponse.getSessionName() + "=" + userLogInResponse.getSessid());

        ImageSend imageSend = new ImageSend();


        imageSend.setFileName(fileName);
        imageSend.setTargetUri("pictures/" + fileName);

        imageSend.setFileMime(filemime);

        imageSend.setFile(ConvertBitmapToString.Convert(bitmap));
        imageSend.setFileSize(Integer.toString(BitmapCompat.getAllocationByteCount(bitmap)));

        imageAPI.saveImagePost(imageSend, map)
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
