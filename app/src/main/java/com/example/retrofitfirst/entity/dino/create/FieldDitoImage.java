package com.example.retrofitfirst.entity.dino.create;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 */
public class FieldDitoImage {

    @SerializedName("und")
    @Expose
    private List<Und___> und = null;

    public List<Und___> getUnd() {
        return und;
    }

    public void setUnd(List<Und___> und) {
        this.und = und;
    }
}
