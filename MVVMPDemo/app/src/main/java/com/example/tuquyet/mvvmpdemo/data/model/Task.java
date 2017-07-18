package com.example.tuquyet.mvvmpdemo.data.model;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class Task {
    private int mId;
    private String mTitle;
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public Task(int id, String title, boolean isChecked) {
        mId = id;
        mTitle = title;
        this.isChecked = isChecked;
    }

    public Task(int id) {
        mId = id;
    }

    public Task(String title) {
        mTitle = title;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
