package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 */
public class FieldDinoColor {

    @SerializedName("und")
    @Expose
    private Und und;

    public Und getUnd() {
        return und;
    }

    public void setUnd(Und und) {
        this.und = und;
    }
}
