package ru.isaifutdinov.kaefik.an_todolist;

import android.test.AndroidTestCase;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import ru.isaifutdinov.kaefik.an_todolist.sqlite.DBConnector;

import static org.junit.Assert.assertEquals;


public class DBConnectorUnitTest extends AndroidTestCase {

    DBConnector dbConnector;

    @Before
    public void setUp() throws Exception {
        //инициализация тестовых данных
        List<String> nameListTable = new ArrayList<String>();
        nameListTable.add("All");
        nameListTable.add("Today");
        nameListTable.add("Shopping");

        dbConnector = new DBConnector(mContext,nameListTable);


    }

    @Test
    public void compareTitleAndCheck_isCorrect() throws Exception {

//        assertEquals(mTaskToDo2.compareCheck(mTaskToDo3),true);

    }


}
