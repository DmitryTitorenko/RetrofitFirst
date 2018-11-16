package com.example.retrofitfirst.entity.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class UserRegResponse {
    @SerializedName("uid")
    @Expose
    private String uid;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
