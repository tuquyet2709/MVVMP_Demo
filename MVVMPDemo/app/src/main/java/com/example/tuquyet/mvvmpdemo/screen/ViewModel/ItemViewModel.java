package com.example.tuquyet.mvvmpdemo.screen.ViewModel;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.screen.main.MainContract;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class ItemViewModel extends BaseObservable{
    private MainContract.Presenter mPresenter;
    private Task mTask;
    private Context mContext;
    private MainContract.ViewModel mViewModel;

    public ItemViewModel(Context context,Task task, MainContract.ViewModel viewModel
                         ) {
        mViewModel = viewModel;
        mTask = task;
        mContext = context;
    }

    public Task getTask() {
        return mTask;
    }

    public void setTask(Task task) {
        mTask = task;
    }

    @Bindable
    public boolean isChecked() {
        return mTask.isChecked();
    }

    public void setChecked(boolean checked) {
        mTask.setChecked(checked);
    }
    @Bindable
    public int getId() {
        return mTask.getId();
    }

    public void setId(int id) {
        mTask.setId(id);
    }
    @Bindable
    public String getTitle() {
        return mTask.getTitle();
    }

    public void setTitle(String title) {
        mTask.setTitle(title);
    }
    public void onAddTaskClick(String title){
        mViewModel.onAddTaskClick();
    }
    public void onDeleteTaskClick(){
        mViewModel.onDeleteTaskClick(this);
    }
    public void onEditTaskClick(){
        mViewModel.onEditTaskClick(this);
    }
}
