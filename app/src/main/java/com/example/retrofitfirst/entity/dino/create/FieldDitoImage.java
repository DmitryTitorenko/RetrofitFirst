package com.example.retrofitfirst.entity.dino.create;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
 * "und": [{"fid": "[FID]"}]
 * }
 *
 * @see DinoCreate
 */
public class FieldDitoImage {

    @SerializedName("und")
    @Expose
    private List<UndImage> und = null;

    public void setUnd(List<UndImage> und) {
        this.und = und;
    }
}
