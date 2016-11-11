package ru.isaifutdinov.kaefik.an_todolist.Task;


import android.content.Intent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ru.isaifutdinov.kaefik.an_todolist.AddTaskActivity;

//хранилище списков дел с задачами

public class MapListTaskToDo {

    protected Map<String, List<TaskToDo>> mTaskListMap;
    private String mCursorItemList; // название выбранного списка задач
    //    private Long mCursorItemCount; // номер элемента в выбранном списке задач
    private TaskToDo mCursorItem; // текущий элемент в выбранном списке задач

    public MapListTaskToDo(Map<String, List<TaskToDo>> mTaskListMap) {
        this.mTaskListMap = mTaskListMap;
        clearCursorItem();
        clearCursorItemList();
    }


    public MapListTaskToDo() {
        this.mTaskListMap = new HashMap<String, List<TaskToDo>>();
//        this.setmCursorItemList("");
//        this.clearCursorItemCount();
        clearCursorItem();
        clearCursorItemList();
    }

    public String getmCursorItemList() {
        return mCursorItemList;
    }

    public void setmCursorItemList(String mCursorItemList) {
        this.mCursorItemList = mCursorItemList;
    }

    // изменение текущий элемент в текущем списке задач
    public void modifyCurrentItemInCurrentList(TaskToDo taskToDo){
        // TODO: изменение текущий элемент в текущем списке задач

    }

    //получение выбранного текущего элемента
    public TaskToDo getmCursorItem() {
        return mCursorItem;
    }

    // текущий элемент
    public void setmCursorItem(TaskToDo mCursorItem) {
        this.mCursorItem = mCursorItem;
    }

    // получить спиcок дел по названию списка
    public List<TaskToDo> getListTaskToDo(String str) {
        return this.mTaskListMap.get(str);
    }

    public void setListTaskToDo(String strList, List<TaskToDo> listTaskToDo) {
        mTaskListMap.put(strList, listTaskToDo);
    }

    //очистить текущий элемент
    public void clearCursorItem() {
        mCursorItem = null;
    }

    public void clearCursorItemList() {
        this.setmCursorItemList("");
    }

}

