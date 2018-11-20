package com.example.retrofitfirst.entity.dino.create;


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
 * @see FieldDinoBirthDate
 */
public class Value {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("hour")
    @Expose
    private String hour;
    @SerializedName("minute")
    @Expose
    private String minute;
    @SerializedName("second")
    @Expose
    private String second;

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
