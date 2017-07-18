package com.example.tuquyet.mvvmpdemo.data.source.local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DB_NAME = "TaskDB";
    public static final int DB_VERSION = 1;
    private static Context mContext;
    public final static String CREATE_QUERY = "CREATE TABLE "
        + TaskTable.TaskDatabaseEntry.TABLE_NAME
        + " ( "
        + TaskTable.TaskDatabaseEntry._ID
        + " INTEGER PRIMARY KEY, "
        + TaskTable.TaskDatabaseEntry.COLUMN_TITLE
        + " TEXT, "
        + TaskTable.TaskDatabaseEntry.COLUMN_ISCHECKED
        + " INTEGER)";
    public static final String DROP_QUERY = "drop table " + TaskTable.TaskDatabaseEntry.TABLE_NAME;
    public static final String SElECT_QUERY =
        "select * from " + TaskTable.TaskDatabaseEntry.TABLE_NAME;

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}