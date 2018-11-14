package com.example.retrofitfirst.entity.image;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public class ImagePost {

    @SerializedName("fid")
    @Expose
    private String fid;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getFid() {
        return fid;
    }

    public String getUri() {
        return uri;
    }

}
