package com.example.tuquyet.mvvmpdemo.screen.main;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.screen.BasePresenter;
import com.example.tuquyet.mvvmpdemo.screen.BaseView;
import com.example.tuquyet.mvvmpdemo.screen.BaseViewModel;
import com.example.tuquyet.mvvmpdemo.screen.ViewModel.ItemViewModel;

import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public interface MainContract {
    interface ViewModel extends BaseViewModel<Presenter> {
        void onDeleteTaskClick(ItemViewModel itemViewModel);
        void onAddTaskClick();
        void onEditTaskClick(ItemViewModel itemViewModel);
        void onAddTaskSuccess(Task task);
        void onAddTaskFailed(String msg);
        void onEditSuccess(ItemViewModel itemViewModel);
        void onEditFailed(String msg);
        void onDeleteSuccess(ItemViewModel itemViewModel);
        void onDeleteFailed(String msg);
        void onGetSuccess(List<Task> list);
        void onGetFailed(String msg);
    }

    interface Presenter extends BasePresenter{
        void addTask(Task task);
        void editTask(ItemViewModel itemViewModel);
        void deleteTask(ItemViewModel itemViewModel);
        void getAllTask();
    }
}
