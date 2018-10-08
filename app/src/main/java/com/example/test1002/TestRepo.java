
package com.example.test1002;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestRepo {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("menu")
    @Expose
    private String menu;
    @SerializedName("day")
    @Expose
    private String day;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

}
