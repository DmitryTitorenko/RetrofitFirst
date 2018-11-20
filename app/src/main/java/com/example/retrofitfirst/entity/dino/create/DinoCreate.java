package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * This POJO use for correct send create dino in JSON to server:
 * {
 * "title": "[DINO_NAME]",
 * "status": "1",
 * "name": "[NAME]",
 * "type": "dino",
 * "field_dino_color": {
 * "und": {"tid": "[DINO_COLOR_TID]"}
 * },
 * "field_dino_about": {
 * "und": [{"value": "[DINO_ABOUT]"}]
 * },
 * "field_dino_birth_date": {
 * "und": [{
 * "value": {
 * "day": "[DAY]",
 * "month": "[MONTH]",
 * "year": "[YEAR]",
 * "hour": "00",
 * "minute": "00",
 * "second": "00"
 * }
 * }]
 * },
 * "field_dito_image": {
 * "und": [{"fid": "[FID]"}]
 * }
 * }
 * <p>
 * Comment:
 * [DINO_NAME] - Dino name
 * [NAME] - Author Username
 * [DINO_COLOR_TID] - (integer) TID (98 - Green, 99 - Red, 100 - Purple)
 * [DINO_ABOUT] - Dino about
 * [DAY] - ex. 1
 * [MONTH] - ex. 9
 * [YEAR] - ex. 2017
 * [FID] - Image file ID (ref. File Tab)
 * [NID] - Entity ID
 */
public class DinoCreate {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("field_dino_color")
    @Expose
    private FieldDinoColor fieldDinoColor;
    @SerializedName("field_dino_about")
    @Expose
    private FieldDinoAbout fieldDinoAbout;
    @SerializedName("field_dino_birth_date")
    @Expose
    private FieldDinoBirthDate fieldDinoBirthDate;
    @SerializedName("field_dito_image")
    @Expose
    private FieldDitoImage fieldDitoImage;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFieldDinoColor(FieldDinoColor fieldDinoColor) {
        this.fieldDinoColor = fieldDinoColor;
    }

    public void setFieldDinoAbout(FieldDinoAbout fieldDinoAbout) {
        this.fieldDinoAbout = fieldDinoAbout;
    }

    public void setFieldDinoBirthDate(FieldDinoBirthDate fieldDinoBirthDate) {
        this.fieldDinoBirthDate = fieldDinoBirthDate;
    }

    public void setFieldDitoImage(FieldDitoImage fieldDitoImage) {
        this.fieldDitoImage = fieldDitoImage;
    }
}
