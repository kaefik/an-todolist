package ru.isaifutdinov.kaefik.an_todolist.sqlite;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

    // Номера столбцов
    private static final int NUM_TASK_ID = 0;
    private static final int NUM_TASK_TITLE = 1;
    private static final int NUM_TASK_CHECK = 2;
    private static final int NUM_DATECREATE = 3;

    private SQLiteDatabase mDataBase;
    private OpenHelper mOpenHelper;

    public DBConnector(Context context, List<String> nameTableList) {
        this.mNameTableList = nameTableList;

        // открываем (или создаем и открываем) БД для записи и чтения
        mOpenHelper = new OpenHelper(context, mNameTableList);
        mDataBase = mOpenHelper.getWritableDatabase();
    }


    // Метод добавления строки в БД,  в таблицу tableName  - t+
    public long insert(TaskToDo md, String tableName) {
        ContentValues cv = new ContentValues();
        cv.put(TASK_ID, md.getId());
        cv.put(TASK_TITLE, md.getTitle());
        cv.put(TASK_CHECK, md.isCheck());
        cv.put(TASK_DATECREATE, md.getDateToDoCreate());
        return mDataBase.insert(tableName, null, cv);
    }


    // Метод удаления всех записей из БД из таблицы  - t+
    public int deleteAll(String tableName) {
        return mDataBase.delete(tableName, null, null);
    }


    // Метод удаления всех записей из БД из всех таблиц
    public void deleteAll() {
        for (String nameTable : mNameTableList) {
            deleteAll(nameTable);
        }
    }

    // Метод удаления записи по id   - t+
    public int delete(int id, String tableName) {
        return mDataBase.delete(tableName, TASK_ID + " = ?", new String[]{String.valueOf(id)});
    }

    // Метод редактирования строки в БД
    public int update(TaskToDo md, String tableName) {
        ContentValues cv = new ContentValues();
        cv.put(TASK_ID, md.getId());
        cv.put(TASK_TITLE, md.getTitle());
        cv.put(TASK_CHECK, md.isCheck());
        cv.put(TASK_DATECREATE, md.getDateToDoCreate());
        return mDataBase.update(tableName, cv, TASK_ID + " = ?", new String[]{String.valueOf(md.getId())});
    }


    // Метод выборки одной записи  - t+
    public TaskToDo select(int id, String tableName) {
        Cursor mCursor = mDataBase.query(tableName, null, TASK_ID + " = ?", new String[]{String.valueOf(id)}, null, null, TASK_DATECREATE);  // ???
        boolean check;
        mCursor.moveToFirst();
        if (mCursor.getCount() == 0) {  // если не нашли ничего, то возращаем пустой объект TaskToDo
            return new TaskToDo("");
        }
        String title = mCursor.getString(NUM_TASK_TITLE);
        if (mCursor.getInt(NUM_TASK_CHECK) == 0) {
            check = false;
        } else {
            check = true;
        }
        String datecreate = mCursor.getString(NUM_DATECREATE);
        mCursor.close();
        return new TaskToDo(id, title, check, datecreate);
    }


    // Метод выборки всех записей в виде списка объектов TaskToDo   - t+
    public List<TaskToDo> selectAll(String tableName) {
        boolean check;
        Cursor mCursor = mDataBase.query(tableName, null, null, null, null, null, TASK_DATECREATE);  // ???
        List<TaskToDo> arr = new ArrayList<TaskToDo>();
        mCursor.moveToFirst();
        if (mCursor.getCount() == 0) {  // если не нашли ничего, то возращаем пустой объект ArrayList<TaskToDo>
            return arr;
        }
        if (!mCursor.isAfterLast()) {
            do {
                String title = mCursor.getString(NUM_TASK_TITLE);
                if (mCursor.getInt(NUM_TASK_CHECK) == 0) {
                    check = false;
                } else {
                    check = true;
                }
                String datecreate = mCursor.getString(NUM_DATECREATE);
                int id = mCursor.getInt(NUM_TASK_ID);

                arr.add(new TaskToDo(id, title, check, datecreate));
            } while (mCursor.moveToNext());
        }
        mCursor.close();
        return arr;
    }


    //метод возвращает список всех таблиц - один из имен служебная таблица android_metadata  - t+
    public ArrayList<String> getTableName() {
        Cursor mCursor = mDataBase.rawQuery("SELECT name FROM sqlite_master WHERE type = 'table'", null);
        mCursor.moveToFirst();

        ArrayList<String> arr = new ArrayList<String>();

        if (mCursor.getCount() == 0) {  // если не нашли ничего, то возращаем пустой объект TaskToDo
            return arr;
        }
        mCursor.moveToFirst();

        do {
            arr.add(mCursor.getString(0));
        } while (mCursor.moveToNext());

        return arr;
    }

    //метод возвращения максимального ID в указанной таблице, если ошибка то возвращает -1  - t+
    public int getMaxId(String tableName) {
        //        SELECT MAX(idTask) FROM Alls;
        String queryString = "SELECT MAX(idTask) FROM Alls";
        Cursor mCursor = mDataBase.rawQuery(queryString, null);

        mCursor.moveToFirst();
        if (mCursor.getCount() == 0) {  // если не нашли ничего, то возращаем пустой объект TaskToDo
            return -1;
        }

        return mCursor.getInt(0);
    }

    // метод возвращения количество элементов в указанной таблице, иначе -1    - t+
    public int getCount(String tableName) {
        //        SELECT COUNT(idTask) FROM Alls;

        String queryString = "SELECT COUNT(idTask) FROM Alls";
        Cursor mCursor = mDataBase.rawQuery(queryString, null);

        mCursor.moveToFirst();
        if (mCursor.getCount() == 0) {  // если не нашли ничего, то возращаем пустой объект TaskToDo
            return -1;
        }

        return mCursor.getInt(0);
    }

    // TODO: написать метод "дефрагментации" , т. е. перенумеровывает id чтобы они шли по порядку? ,без дырок
    public int getDefragId(String tableName) {
        return 0;
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
                String query = "CREATE TABLE IF NOT EXISTS " + nameTable + "(" + TASK_ID
                        + " INTEGER PRIMARY KEY," + TASK_TITLE + " TEXT," + TASK_CHECK + " INTEGER," + TASK_DATECREATE + " TEXT" + ")";
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
