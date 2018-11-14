package com.example.retrofitfirst.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public class Dino {

    @SerializedName("dino")
    @Expose
    private Dino_ dino;

    public Dino_ getDino() {
        return dino;
    }

    public void setDino(Dino_ dino) {
        this.dino = dino;
    }

}
