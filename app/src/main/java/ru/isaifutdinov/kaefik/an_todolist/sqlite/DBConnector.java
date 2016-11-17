package ru.isaifutdinov.kaefik.an_todolist.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class DBConnector {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "maplisttasktodoDb"; // БД в которой таблица это
    private String mTableName; // название таблицы


    // TODO: имена полей таблицы должны соответствовать классу TaskToDo -
    // ....

    private SQLiteDatabase mDataBase;

    public DBConnector(Context context, String tableName) {
        this.mTableName = tableName;
    }

    //класс для создания БД
    private class OpenHelper extends SQLiteOpenHelper {

        private List<String> nameTableList; // массив названия таблиц, каждая таблица это отдельный список задач

        public OpenHelper(Context context, List<String> nameTableList) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
            this.nameTableList = nameTableList;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String query ="create table " + nameTable + "(" + TaskToDo.TASK_ID
                    + " integer primary key," + TaskToDo.TASK_TITLE + " text," + TaskToDo.TASK_CHECK + "integer" + TaskToDo.TASK_DATECREATE + "text" + TaskToDo.TASK_UPDATECHECK + "integer" + ")";
            db.execSQL(query);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + nameTable);
        }
    }
}
