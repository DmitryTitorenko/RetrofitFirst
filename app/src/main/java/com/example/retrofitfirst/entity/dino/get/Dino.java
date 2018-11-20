package com.example.retrofitfirst.entity.dino.get;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * {
 * "dino": {
 * "dino_title": "[DINO_NAME]",
 * "dino_color": "[DINO_COLOR]",
 * "dino_birthdate": "[DINO_BIRTHDATE]",
 * "dino_image": {
 * "src": "[IMG_URL]",
 * "alt": ""
 * },
 * "dino_about": "[DINO_ABOUT]"
 * }
 * }
 *
 * @see DinoWrapper
 */
public class Dino {

    @SerializedName("dino")
    @Expose
    private DinoFields dino;

    public DinoFields getDino() {
        return dino;
    }

    public void setDino(DinoFields dino) {
        this.dino = dino;
    }

}
