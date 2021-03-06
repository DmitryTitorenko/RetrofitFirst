package com.example.retrofitfirst.entity.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 16.11.2018.
 * <p>
 * This POJO use for correct get login user in JSON from server:
 * {
 * "sessid":"[session_id]",
 * "session_name":"[session_name]",
 * "token":"[token]",
 * "user":{ ... }
 * }
 */
public class UserLogInResponse {
    @SerializedName("sessid")
    @Expose
    private String sessid;
    @SerializedName("session_name")
    @Expose
    private String sessionName;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user")
    @Expose
    private UserRegPOST user;

    public String getSessid() {
        return sessid;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getToken() {
        return token;
    }

    public UserRegPOST getUser() {
        return user;
    }

}

