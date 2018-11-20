package com.example.retrofitfirst.entity.dino.create;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
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
 * }
 *
 * @see DinoCreate
 */
public class FieldDinoBirthDate {

    @SerializedName("und")
    @Expose
    private List<UndBirthDateValue> und = null;

    public void setUnd(List<UndBirthDateValue> und) {
        this.und = und;
    }
}
