package ru.isaifutdinov.kaefik.an_todolist;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;
import ru.isaifutdinov.kaefik.an_todolist.sqlite.DBConnector;

import static org.junit.Assert.assertEquals;
import static android.support.test.InstrumentationRegistry.getTargetContext;


@RunWith(AndroidJUnit4.class)
public class DBConnectorUnitTest extends AndroidTestCase {

    public static String TAG_TEST = "testdbconnector";

    DBConnector dbConnector;

    TaskToDo mTaskToDo1;
    TaskToDo mTaskToDo2;
    TaskToDo mTaskToDo3;

    @Before
    public void setUp() throws Exception {

        //инициализация тестовых данных
        mTaskToDo1 = new TaskToDo("Milk", false);
        mTaskToDo1.setId(0);
        mTaskToDo1.setDateToDoCreate();
        mTaskToDo2 = new TaskToDo("купить незамерзайку Love Milk How match?", true);
        mTaskToDo2.setId(1);
        mTaskToDo2.setDateToDoCreate();
        mTaskToDo3 = new TaskToDo("купить незамерзайку Love Milk How match?", false);
        mTaskToDo3.setId(2);
        mTaskToDo3.setDateToDoCreate();

        //инициализация тестовых данных
        List<String> nameListTable = new ArrayList<String>();
        nameListTable.add("Alls");
        nameListTable.add("Today");
        nameListTable.add("Shopping");

        dbConnector = new DBConnector(getTargetContext(), nameListTable);

    }

    @Test
    public void insert_isCorrect() throws Exception {
//        dbConnector.insert(mTaskToDo1, "Alls");
//        dbConnector.insert(mTaskToDo2, "Alls");
//        dbConnector.insert(mTaskToDo3, "Alls");

    }

    @Test
    public void select_isCorrect() throws Exception {
        TaskToDo taskToDo = dbConnector.select(1, "Alls");
        TaskToDo taskToDo1 =dbConnector.select(4, "Alls");
        Log.i(TAG_TEST, "Title: " + taskToDo.getTitle());
    }


    @Test
    public void getMaxId_isCorrect() throws Exception {
        assertEquals(dbConnector.getMaxId("Alls"),2);
    }

    @Test
    public void getCount_isCorrect() throws Exception {
        assertEquals(dbConnector.getCount("Alls"),3);
    }

}
