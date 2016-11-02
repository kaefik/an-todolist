package ru.isaifutdinov.kaefik.an_todolist.Task;


import java.util.ArrayList;
import java.util.List;

//список задач TaskToDo
// TODO: возможно этот класс не нужен будет
public class ListTaskToDo {

    List<TaskToDo> list;

    public ListTaskToDo(List<TaskToDo> list) {
        this.list = list;
    }

    public ListTaskToDo() {
        this.list = new ArrayList<TaskToDo>();
    }

    int size(){
        return list.size();
    }

}
