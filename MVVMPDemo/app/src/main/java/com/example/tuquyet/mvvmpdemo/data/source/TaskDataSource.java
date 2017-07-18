package com.example.tuquyet.mvvmpdemo.data.source;

import com.example.tuquyet.mvvmpdemo.data.model.Task;

import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public interface TaskDataSource {
    void addTask(Task task, CallBack<Boolean> callBack);
    void editTask(Task task, CallBack<Boolean> callBack);
    void deleteTask(Task task, CallBack<Boolean> callBack);
    void getAllTask(CallBacks<Task> callBack);
    interface CallBack<T> {
        void onSuccess(T data);
        void onFailed(String msg);
    }

    interface CallBacks<T> {
        void onSuccess(List<T> data);
        void onFailed(String msg);
    }
}
