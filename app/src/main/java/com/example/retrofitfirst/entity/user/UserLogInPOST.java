package com.example.retrofitfirst.entity.user;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 16.11.2018.
 * <p>
 * This POJO use for correct send login user in JSON to server:
 * {
 * "username":"[NAME]",
 * "password":"[PASS]"
 * }
 */
public class UserLogInPOST {
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
