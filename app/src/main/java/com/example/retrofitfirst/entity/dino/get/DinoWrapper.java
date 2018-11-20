package com.example.retrofitfirst.entity.dino.get;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * This POJO use for correct get dino in JSON from server:
 * {
 * "dinos": [
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
 * ]
 * }
 * <p>
 * Comment:
 * [DINO_COLOR] - (string) Dino Color
 * [DINO_BIRTHDATE] - 06.04.1988
 * <p>
 * [IMG_URL] - Dino img url (http://....jpeg)
 */
public class DinoWrapper {

    @SerializedName("dinos")
    @Expose
    private List<Dino> dinos = null;

    public List<Dino> getDinos() {
        return dinos;
    }

}