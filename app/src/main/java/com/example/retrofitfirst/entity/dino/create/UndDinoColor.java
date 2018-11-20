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
 * @see FieldDinoColor
 */
public class UndDinoColor {

    @SerializedName("tid")
    @Expose
    private String tid;

    public void setTid(String tid) {
        this.tid = tid;
    }

}
