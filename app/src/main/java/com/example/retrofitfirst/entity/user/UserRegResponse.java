package com.example.retrofitfirst.entity.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 * <p>
 * This POJO use for correct get response about user registration in JSON from server:
 * {
 * "uid": "[UID]",
 * "uri": "BASE_URL/rest/user/[UID]"
 * }
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

    public String getUri() {
        return uri;
    }

}
