package com.example.retrofitfirst.entity.dino.get;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 14.11.2018.
 * <p>
 * {
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
 * @see Dino
 */
public class DinoFields {

    @SerializedName("dino_title")
    @Expose
    private String dinoTitle;
    @SerializedName("dino_color")
    @Expose
    private String dinoColor;
    @SerializedName("dino_birthdate")
    @Expose
    private String dinoBirthdate;
    @SerializedName("dino_image")
    @Expose
    private DinoImage dinoImage;
    @SerializedName("dino_about")
    @Expose
    private String dinoAbout;

    public String getDinoTitle() {
        return dinoTitle;
    }

    public String getDinoColor() {
        return dinoColor;
    }

    public String getDinoBirthdate() {
        return dinoBirthdate;
    }

    public DinoImage getDinoImage() {
        return dinoImage;
    }

    public String getDinoAbout() {
        return dinoAbout;
    }

}