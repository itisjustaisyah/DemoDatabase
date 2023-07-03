package com.myapplicationdev.android.demodatabase;

import androidx.annotation.NonNull;

/**
 * Created by Nuur Aisyah Binte Farouk on 3/7/2023.
 * C346-1D-E63A-A
 */
public class Task {

    private int id;
    private String decription;
    private String date;

    public Task(int id, String decription, String date){
        this.id = id;
        this.decription = decription;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getDecription() {
        return decription;
    }

    public String getDate() {
        return date;
    }


    @NonNull
    @Override

    public String toString() {
        return id + "\n" + decription + "\n" + date;
    }
}
