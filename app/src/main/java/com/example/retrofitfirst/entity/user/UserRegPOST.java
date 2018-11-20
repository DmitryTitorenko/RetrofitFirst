package com.example.retrofitfirst.entity.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 * <p>
 * This POJO use for correct registration user in JSON to server:
 * {
 * "name": "[NAME]",
 * "mail": "[MAIL]",
 * "pass": "[PASS]"
 * }
 */
public class UserRegPOST {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mail")
    @Expose
    private String mail;
    @SerializedName("pass")
    @Expose
    private String pass;

    public void setName(String name) {
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

}
