package com.example.retrofitfirst.entity.dino.create;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * <p>
 * {
 * "und": [{"value": "[DINO_ABOUT]"}]
 * }
 *
 * @see FieldDinoAbout
 */
public class UndValueAbout {

    @SerializedName("value")
    @Expose
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

}
