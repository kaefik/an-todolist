package ru.isaifutdinov.kaefik.an_todolist.Task;


import android.content.Intent;

import java.util.List;
import java.util.Map;

import ru.isaifutdinov.kaefik.an_todolist.AddTaskActivity;

//хранилище списков дел с задачами

public class MapListTaskToDo {

    Map<String, List<TaskToDo>> mTaskListMap;
    private String mCursorItemList; // название выбранного списка задач
    private Long mCursorItemCount; // номер элемента в выбранном списке задач

    public MapListTaskToDo(Map<String, List<TaskToDo>> mTaskListMap) {
        this.mTaskListMap = mTaskListMap;
        this.setmCursorItemList("");
        this.setmCursorItemCount(-1L);
    }

    public String getmCursorItemList() {
        return mCursorItemList;
    }

    public void setmCursorItemList(String mCursorItemList) {
        this.mCursorItemList = mCursorItemList;
    }

    public Long getmCursorItemCount() {
        return mCursorItemCount;
    }

    public void setmCursorItemCount(Long mCursorItemCount) {
        this.mCursorItemCount = mCursorItemCount;
    }
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
