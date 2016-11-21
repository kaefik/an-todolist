package ru.isaifutdinov.kaefik.an_todolist.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class DBConnector {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "maplisttasktodoDb"; // БД в которой таблица это
    private List<String> mNameTableList; // массив названия таблиц, каждая таблица это отдельный список задач


    // TODO: имена полей таблицы должны соответствовать классу TaskToDo - здесь все поля кроме updateCheck
    public static final String TASK_ID = "idTask";
    public static final String TASK_TITLE = "titleTask";
    public static final String TASK_CHECK = "checkTask";
    public static final String TASK_DATECREATE = "dateCreateTask";

    private SQLiteDatabase mDataBase;
    private OpenHelper mOpenHelper;

    public DBConnector(Context context, List<String> nameTableList) {
        this.mNameTableList = nameTableList;

        // открываем (или создаем и открываем) БД для записи и чтения
        mOpenHelper = new OpenHelper(context, mNameTableList);
        mDataBase = mOpenHelper.getWritableDatabase();
    }


    // Метод добавления строки в БД,  в таблицу tableName
    public long insert(TaskToDo md, String tableName) {
        ContentValues cv=new ContentValues();
        cv.put(TASK_ID, md.getId());
        cv.put(TASK_TITLE, md.getTitle());
        cv.put(TASK_CHECK, md.isCheck());
        return mDataBase.insert(tableName, null, cv);
    }





    //класс для создания БД
    private class OpenHelper extends SQLiteOpenHelper {

//        private List<String> mNameTableList; // массив названия таблиц, каждая таблица это отдельный список задач

        public OpenHelper(Context context, List<String> nameTableList) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
//            .mNameTableList = nameTableList;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            if (mNameTableList == null) return;
            for (String nameTable : mNameTableList) {
                String query = "CREATE TABLE " + nameTable + "(" + TASK_ID
                        + " INTEGER primary key," + TASK_TITLE + " TEXT," + TASK_CHECK + " INTEGER," + TASK_DATECREATE + " TEXT"  + ")";
                db.execSQL(query);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (mNameTableList == null) return;
            for (String nameTable : mNameTableList) {
                db.execSQL("drop table if exists " + nameTable);
            }
        }
    }
}
