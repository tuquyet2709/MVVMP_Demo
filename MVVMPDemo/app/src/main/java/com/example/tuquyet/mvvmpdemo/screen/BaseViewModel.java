package com.example.tuquyet.mvvmpdemo.screen;

/**
 * Created by tuquyet on 18/07/2017.
 */
public interface BaseViewModel<T extends BasePresenter> {
    void onStart();
    void onStop();
    void setPresenter(T presenter);
}
