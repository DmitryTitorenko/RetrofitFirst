package com.example.retrofitfirst.api;

import com.example.retrofitfirst.entity.image.ImagePost;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;
/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public interface ImageAPI {

    @Headers({"Content-Type: application/json","Accepts: application/json"})
    @POST("file")
    @FormUrlEncoded
    Call<ImagePost> saveImagePost(@Field("filename") String filename,
                                  @Field("target_uri") String targetUri,
                                  @Field("filemime") String filemime,
                                  @Field("file")  String file,
                                  @Field("filesize") String filesize);
}
