package com.example.tuquyet.mvvmpdemo.data.source.local;

import android.provider.BaseColumns;

/**
 * Created by tuquyet on 18/07/2017.
 */
public class TaskTable {
    public class TaskDatabaseEntry implements BaseColumns {
        static final String TABLE_NAME = "tasks";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_ISCHECKED = "checked";
    }
}