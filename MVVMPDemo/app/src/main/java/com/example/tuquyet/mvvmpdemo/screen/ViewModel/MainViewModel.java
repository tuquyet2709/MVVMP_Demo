package com.example.tuquyet.mvvmpdemo.screen.ViewModel;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.databinding.BaseObservable;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.screen.BaseActivity;
import com.example.tuquyet.mvvmpdemo.screen.main.MainAdapter;
import com.example.tuquyet.mvvmpdemo.screen.main.MainContract;
import com.example.tuquyet.mvvmpdemo.screen.main.MainPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class MainViewModel extends BaseObservable implements MainContract.ViewModel {
    private Context mContext;
    private MainContract.Presenter mPresenter;
    private MainAdapter mAdapter;
    public MainViewModel(Context context) {
        mContext = context;
        mAdapter = new MainAdapter();
    }

    public void setContext(Context context) {
        mContext = context;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public void setAdapter(MainAdapter adapter) {
        mAdapter = adapter;
    }

    public Context getContext() {
        return mContext;
    }

    public MainContract.Presenter getPresenter() {
        return mPresenter;
    }

    public MainAdapter getAdapter() {
        return mAdapter;
    }

    @Override
    public void onDeleteTaskClick(final ItemViewModel itemViewModel) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Delete ?")
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    mPresenter.deleteTask(itemViewModel);
                }
            })
            .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // do nothing
                }
            })
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show();
    }

    @Override
    public void onAddTaskClick() {
        final EditText text = new EditText(mContext);
        text.setHint("Title");
        new AlertDialog.Builder(mContext).setTitle("Add task")
            .setView(text)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String title = text.getText().toString();
                    Task task = new Task(title);
                    mPresenter.addTask(task);
                }
            })
            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            })
            .show();
    }

    @Override
    public void onEditTaskClick(final ItemViewModel itemViewModel) {
        final EditText text = new EditText(mContext);
        text.setHint("Title");
        new AlertDialog.Builder(mContext).setTitle("Edit task")
            .setView(text)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String title = text.getText().toString();
                    itemViewModel.getTask().setTitle(title);
                    mPresenter.editTask(itemViewModel);
                }
            })
            .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            })
            .show();
    }

    @Override
    public void onAddTaskSuccess(Task task) {
        mAdapter.updateData(new ItemViewModel(mContext, task, this));

    }

    @Override
    public void onAddTaskFailed(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onEditSuccess(ItemViewModel itemViewModel) {
        mAdapter.updateData(itemViewModel);

    }

    @Override
    public void onEditFailed(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeleteSuccess(ItemViewModel itemViewModel) {
        mAdapter.deleteTask(itemViewModel);
    }

    @Override
    public void onDeleteFailed(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetSuccess(List<Task> list) {
        List<ItemViewModel> listTaskViewModel = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listTaskViewModel.add(new ItemViewModel(mContext, list.get(i), this));
        }
        mAdapter.updateData(listTaskViewModel);
    }

    @Override
    public void onGetFailed(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

}
