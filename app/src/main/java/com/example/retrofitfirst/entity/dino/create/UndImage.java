package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
 * "und": [{"fid": "[FID]"}]
 * }
 *
 * @see FieldDitoImage
 */
public class UndImage {

    @SerializedName("fid")
    @Expose
    private String fid;

    public void setFid(String fid) {
        this.fid = fid;
    }

}
