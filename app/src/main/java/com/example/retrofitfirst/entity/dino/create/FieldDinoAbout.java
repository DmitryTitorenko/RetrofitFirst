package com.example.retrofitfirst.entity.dino.create;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 */
public class FieldDinoAbout {

    @SerializedName("und")
    @Expose
    private List<Und_> und = null;

    public List<Und_> getUnd() {
        return und;
    }

    public void setUnd(List<Und_> und) {
        this.und = und;
    }

}
