package com.example.tuquyet.mvvmpdemo.data.source;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.data.source.local.TaskLocalDataSource;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class TaskRepository implements TaskDataSource {
    private TaskLocalDataSource mLocalDataSource;

    public TaskRepository(
        TaskLocalDataSource localDataSource) {
        mLocalDataSource = localDataSource;
    }

    @Override
    public void addTask(Task task, CallBack<Boolean> callBack) {
        mLocalDataSource.addTask(task, callBack);
    }

    @Override
    public void editTask(Task task, CallBack<Boolean> callBack) {
        mLocalDataSource.editTask(task, callBack);
    }

    @Override
    public void deleteTask(Task task, CallBack<Boolean> callBack) {
        mLocalDataSource.deleteTask(task, callBack);
    }

    @Override
    public void getAllTask(CallBacks<Task> callBack) {
        mLocalDataSource.getAllTask(callBack);
    }
}
