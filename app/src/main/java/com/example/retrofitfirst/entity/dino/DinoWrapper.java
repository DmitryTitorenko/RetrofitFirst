package com.example.retrofitfirst.entity.dino;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 */
public class DinoWrapper {

    @SerializedName("dinos")
    @Expose
    private List<Dino> dinos = null;

    public List<Dino> getDinos() {
        return dinos;
    }

    public void setDinos(List<Dino> dinos) {
        this.dinos = dinos;
    }
}