package ru.isaifutdinov.kaefik.an_todolist.Task;


import android.content.Context;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//хранилище списков дел с задачами

public class MapListTaskToDo {

    protected Map<String, List<TaskToDo>> mTaskListMap;
    private String mCursorNameList; // название выбранного списка задач
    //    private Long mCursorItemCount; // номер элемента в выбранном списке задач
    private TaskToDo mCursorItem; // текущий элемент в выбранном списке задач

    public MapListTaskToDo(Map<String, List<TaskToDo>> mTaskListMap) {
        this.mTaskListMap = mTaskListMap;
        clearCursorItem();
        clearCursorNameList();
    }


    public MapListTaskToDo() {
        this.mTaskListMap = new HashMap<String, List<TaskToDo>>();
        clearCursorItem();
        clearCursorNameList();
    }

    public String getmCursorNameList() {
        return mCursorNameList;
    }

    public void setmCursorNameList(String mCursorNameList) {
        this.mCursorNameList = mCursorNameList;
    }

    // изменение текущий элемент в текущем списке задач
    public void modifyCurrentItemInCurrentList(TaskToDo taskToDo) {
        List<TaskToDo> tempListTaskToDo = getListTaskToDo(getmCursorNameList());

        taskToDo.setUpdateCheck(true); // помечаем данную задачу как измененную

        for (int i = 0; i < tempListTaskToDo.size(); i++) {
            if (tempListTaskToDo.get(i).compare(this.getmCursorItem())) {
                setItemTaskToDo(getmCursorNameList(),i,taskToDo);
            }
        }
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

    //добавить в список название strList
    public void setListTaskToDo(String strList, List<TaskToDo> listTaskToDo) {
        mTaskListMap.put(strList, listTaskToDo);
    }


    //изменить в списке с названием strList с номером numItem поменять на задачу taskToDo
    public void setItemTaskToDo(String strList, int numItem, TaskToDo taskToDo) {
        List<TaskToDo> tempListTaskToDo = getListTaskToDo(strList);
        tempListTaskToDo.set(numItem,taskToDo);
        mTaskListMap.put(strList, tempListTaskToDo);
    }



    //очистить текущий элемент
    public void clearCursorItem() {
        mCursorItem = null;
    }

    public void clearCursorNameList() {
        this.setmCursorNameList("");
    }

}

