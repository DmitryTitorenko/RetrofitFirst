package com.example.retrofitfirst.entity.dino.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 * <p>
 * {
 * "value": {
 * "day": "[DAY]",
 * "month": "[MONTH]",
 * "year": "[YEAR]",
 * "hour": "00",
 * "minute": "00",
 * "second": "00"
 * }
 * }
 *
 * @see FieldDinoBirthDate
 */
public class UndBirthDateValue {

    @SerializedName("value")
    @Expose
    private Value value;

    public void setValue(Value value) {
        this.value = value;
    }

}
