package com.example.retrofitfirst.entity.dino.create;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
 * "und": [{"value": "[DINO_ABOUT]"}]
 * }
 *
 * @see DinoCreate
 */
public class FieldDinoAbout {

    @SerializedName("und")
    @Expose
    private List<UndValueAbout> und = null;

    public void setUnd(List<UndValueAbout> und) {
        this.und = und;
    }

}
