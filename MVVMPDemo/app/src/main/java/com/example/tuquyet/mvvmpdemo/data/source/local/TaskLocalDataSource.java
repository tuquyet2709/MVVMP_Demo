package com.example.tuquyet.mvvmpdemo.data.source.local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.tuquyet.mvvmpdemo.data.model.Task;
import com.example.tuquyet.mvvmpdemo.data.source.TaskDataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class TaskLocalDataSource extends DatabaseHelper implements TaskDataSource {
    private Context mContext;
    private DatabaseHelper mDatabaseHelper;

    public TaskLocalDataSource(Context context) {
        super(context);
    }

    @Override
    public void addTask(Task task, CallBack<Boolean> callBack) {
        //add task
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskTable.TaskDatabaseEntry.COLUMN_TITLE, task.getTitle());
        values.put(TaskTable.TaskDatabaseEntry.COLUMN_ISCHECKED, task.isChecked());
        long result = db.insert(TaskTable.TaskDatabaseEntry.TABLE_NAME, null, values);
        if (result >= 0) {
            task.setId((int) result);
            callBack.onSuccess(Boolean.TRUE);
        } else callBack.onFailed("ADD TASK FAILED");
        db.close();
    }

    @Override
    public void editTask(Task task, CallBack<Boolean> callBack) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TaskTable.TaskDatabaseEntry.COLUMN_TITLE, task.getTitle());
        values.put(TaskTable.TaskDatabaseEntry.COLUMN_ISCHECKED, task.isChecked());
        int result = db.update(TaskTable.TaskDatabaseEntry.TABLE_NAME, values,
            TaskTable.TaskDatabaseEntry._ID + " = " + task.getId(), null);
        if (result > 0) callBack.onSuccess(Boolean.TRUE);
        else callBack.onFailed("EDIT TASK FAILED");
        db.close();
    }

    @Override
    public void deleteTask(Task task, CallBack<Boolean> callBack) {
        SQLiteDatabase db = this.getWritableDatabase();
        int result = db.delete(TaskTable.TaskDatabaseEntry.TABLE_NAME,
            TaskTable.TaskDatabaseEntry._ID + " = " + task.getId(), null);
        if (result >= 0) callBack.onSuccess(Boolean.TRUE);
        else callBack.onFailed("DELETE TASK FAILED");
        db.close();
    }

    @Override
    public void getAllTask(CallBacks<Task> callBack) {
        List<Task> taskList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(SElECT_QUERY, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(
                    cursor.getColumnIndex(TaskTable.TaskDatabaseEntry._ID));
                String title = cursor.getString(
                    cursor.getColumnIndex(TaskTable.TaskDatabaseEntry.COLUMN_TITLE));
                boolean isChecked = cursor.getInt(cursor.getColumnIndex(
                    TaskTable.TaskDatabaseEntry.COLUMN_ISCHECKED)) != 0;
                taskList.add(new Task(id, title, isChecked));
            }
        }
        cursor.close();
        db.close();
    }
}