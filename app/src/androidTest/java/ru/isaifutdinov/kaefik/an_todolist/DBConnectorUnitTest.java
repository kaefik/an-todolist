package ru.isaifutdinov.kaefik.an_todolist;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.runner.AndroidJUnit4;


import java.util.ArrayList;
import java.util.List;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;
import ru.isaifutdinov.kaefik.an_todolist.sqlite.DBConnector;

import static org.junit.Assert.assertEquals;
import static android.support.test.InstrumentationRegistry.getTargetContext;


@RunWith(AndroidJUnit4.class)
public class DBConnectorUnitTest extends AndroidTestCase {

    DBConnector dbConnector;

    TaskToDo mTaskToDo1;
    TaskToDo mTaskToDo2;
    TaskToDo mTaskToDo3;

    @Before
    public void setUp() throws Exception {

        //инициализация тестовых данных
        mTaskToDo1 = new TaskToDo("Milk", false);
        mTaskToDo2 = new TaskToDo("купить незамерзайку Love Milk How match?", true);
        mTaskToDo3 = new TaskToDo("купить незамерзайку Love Milk How match?", true);

        //инициализация тестовых данных
        List<String> nameListTable = new ArrayList<String>();
        nameListTable.add("All");
        nameListTable.add("Today");
        nameListTable.add("Shopping");

        dbConnector = new DBConnector(getTargetContext(),nameListTable);


    }

    @Test
    public void insert_isCorrect() throws Exception {
//        dbConnector.insert(mTaskToDo1,"All");


//        assertEquals(dbConnector.insert(mTaskToDo1,"All"),true);

    }


}
