package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
 * "und": {"tid": "[DINO_COLOR_TID]"}
 * }
 *
 * @see DinoCreate
 */
public class FieldDinoColor {

    @SerializedName("und")
    @Expose
    private UndDinoColor und;

    public void setUndDinoColor(UndDinoColor undDinoColor) {
        this.und = undDinoColor;
    }
}
