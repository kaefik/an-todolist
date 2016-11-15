package ru.isaifutdinov.kaefik.an_todolist;

import org.junit.Before;
import org.junit.Test;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TaskToDoUnitTest {

    TaskToDo mTaskToDo1;
    TaskToDo mTaskToDo2;
    TaskToDo mTaskToDo3;

    @Before
    public void setUp() throws Exception {
        //инициализация тестовых данных
        mTaskToDo1 = new TaskToDo("Milk", false);
        mTaskToDo2 = new TaskToDo("купить незамерзайку Love Milk How match?", true);
        mTaskToDo3 = new TaskToDo("купить незамерзайку Love Milk How match?", true);


    }

    @Test
    public void compareTitleAndCheck_isCorrect() throws Exception {

        assertEquals(mTaskToDo1.compareTitle(mTaskToDo2),false);
        assertEquals(mTaskToDo1.compareTitle(mTaskToDo1),true);
        assertEquals(mTaskToDo2.compareTitle(mTaskToDo3),true);

        assertEquals(mTaskToDo2.compareCheck(mTaskToDo3),true);
        assertEquals(mTaskToDo1.compareCheck(mTaskToDo3),false);
    }


    @Test
    public void compare_isCorrect() throws Exception {

        assertEquals(mTaskToDo1.compare(mTaskToDo3),false);
        assertEquals(mTaskToDo3.compare(mTaskToDo3),true);

//        public boolean compare(TaskToDo taskToDo) {

    }


    // изменение текущий элемент в текущем списке задач
//    public void modifyCurrentItemInCurrentList(TaskToDo taskToDo)

}