package com.example.retrofitfirst.entity.dino.create;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dmitry Titorenko on 19.11.2018.
 */
public class FieldDinoBirthDate {

        @SerializedName("und")
        @Expose
        private List<Und__> und = null;

        public List<Und__> getUnd() {
            return und;
        }

        public void setUnd(List<Und__> und) {
            this.und = und;
        }
}
