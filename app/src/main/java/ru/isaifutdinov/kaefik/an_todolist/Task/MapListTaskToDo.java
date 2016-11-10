package ru.isaifutdinov.kaefik.an_todolist.Task;


import java.util.List;
import java.util.Map;

//хранилище списков дел с задачами

public class MapListTaskToDo {

    Map<String, List<TaskToDo>> mTaskListMap;
    private String mCursorItemList; // название выбранного списка задач
    private Long mCursorItemCount; // номер элемента в выбранном списке задач



}


////заполнения тестовыми задачами
//mTaskListMap = new ArrayMap<String, List<TaskToDo>>();
//
//        List<TaskToDo> tempTask = new ArrayList<TaskToDo>();
//        tempTask.add(new TaskToDo("Milk", false));
//        tempTask.add(new TaskToDo("Хлеб"));
//        tempTask.add(new TaskToDo("купить незамерзайку Love Milk How match?", true));
//        tempTask.add(new TaskToDo("позввонить любимой"));
//        mTaskListMap.put(this.getListNames().get(0), tempTask);
