package com.example.retrofitfirst.entity.dino.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * {
 * "src": "[IMG_URL]",
 * "alt": ""
 * }
 *
 * @see Dino
 */
public class DinoImage {

    @SerializedName("src")
    @Expose
    private String src;
    @SerializedName("alt")
    @Expose
    private String alt;

    public String getSrc() {
        return src;
    }

}
