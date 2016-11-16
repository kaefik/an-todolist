package ru.isaifutdinov.kaefik.an_todolist.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "maplisttasktodoDb"; // БД в которой таблица это
    //    public static final String TABLE_LIST = "All";
    private List<String> nameListTable; // название списков задач - каждый список находится в своей таблице

    // TODO: имена полей таблицы должны соответствовать классу TaskToDo -


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        nameListTable = new ArrayList<String>();
        nameListTable.add("All");
        nameListTable.add("Today");
        nameListTable.add("Shopping");

        if (nameListTable == null) return;
        for (String nameTable : nameListTable) {
            db.execSQL("create table " + nameTable + "(" + TaskToDo.TASK_ID
                    + " integer primary key," + TaskToDo.TASK_TITLE + " text," + TaskToDo.TASK_CHECK + "integer" + TaskToDo.TASK_DATECREATE + "text" + TaskToDo.TASK_UPDATECHECK + "integer" + ")");
        }

    }

    public void onCreate(SQLiteDatabase db, List<String> namelIst) {
        nameListTable = namelIst;
        if (nameListTable == null) return;
        for (String nameTable : nameListTable) {
            db.execSQL("create table " + nameTable + "(" + TaskToDo.TASK_ID
                    + " integer primary key," + TaskToDo.TASK_TITLE + " text," + TaskToDo.TASK_CHECK + "integer" + TaskToDo.TASK_DATECREATE + "text" + TaskToDo.TASK_UPDATECHECK + "integer" + ")");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (String nameTable : nameListTable) {
            db.execSQL("drop table if exists " + nameListTable);
        }

        onCreate(db);

    }
}