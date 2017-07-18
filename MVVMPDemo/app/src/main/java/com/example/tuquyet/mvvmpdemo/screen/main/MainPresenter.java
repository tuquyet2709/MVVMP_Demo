package com.example.tuquyet.mvvmpdemo.screen.main;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.data.source.TaskDataSource;
import com.example.tuquyet.mvvmpdemo.screen.ViewModel.ItemViewModel;
import com.example.tuquyet.mvvmpdemo.screen.ViewModel.MainViewModel;

import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class MainPresenter implements MainContract.Presenter {
    private MainViewModel mMainViewModel;
    private TaskDataSource mTaskRepository;

    public MainPresenter(MainViewModel viewModel, TaskDataSource taskRepository) {
        mMainViewModel = viewModel;
        mMainViewModel.setPresenter(this);
        mTaskRepository = taskRepository;
    }

    @Override
    public void addTask(final Task task) {
        mTaskRepository.addTask(task, new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mMainViewModel.onAddTaskSuccess(task);
            }

            @Override
            public void onFailed(String msg) {
                mMainViewModel.onAddTaskFailed(msg);
            }
        });
    }

    @Override
    public void editTask(final ItemViewModel itemViewModel) {
        mTaskRepository.editTask(itemViewModel.getTask(), new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mMainViewModel.onEditSuccess(itemViewModel);
            }

            @Override
            public void onFailed(String msg) {
                mMainViewModel.onEditFailed(msg);
            }
        });
    }

    @Override
    public void deleteTask(final ItemViewModel itemViewModel) {
        mTaskRepository.deleteTask(itemViewModel.getTask(), new TaskDataSource.CallBack<Boolean>() {
            @Override
            public void onSuccess(Boolean data) {
                mMainViewModel.onDeleteSuccess(itemViewModel);
            }

            @Override
            public void onFailed(String msg) {
                mMainViewModel.onDeleteFailed(msg);
            }
        });
    }

    @Override
    public void getAllTask() {
        mTaskRepository.getAllTask(new TaskDataSource.CallBacks<Task>() {
            @Override
            public void onSuccess(List<Task> data) {
                mMainViewModel.onGetSuccess(data);
            }

            @Override
            public void onFailed(String msg) {
                mMainViewModel.onGetFailed(msg);
            }
        });
    }

}
