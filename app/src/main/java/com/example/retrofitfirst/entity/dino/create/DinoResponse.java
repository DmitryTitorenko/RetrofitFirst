package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * This POJO use for correct get response about create dino in JSON from server:
 * {
 * "nid": "[NID]",
 * "uri": "BASE_URL/rest/node/[NID]"
 * }
 */
public class DinoResponse {

    @SerializedName("nid")
    @Expose
    private String nid;
    @SerializedName("uri")
    @Expose
    private String uri;

    public String getNid() {
        return nid;
    }


    public String getUri() {
        return uri;
    }


}
