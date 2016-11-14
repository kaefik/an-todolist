package ru.isaifutdinov.kaefik.an_todolist.Task;

import android.content.Context;
import android.content.Intent;

import java.util.Date;

import ru.isaifutdinov.kaefik.an_todolist.AddTaskActivity;
import ru.isaifutdinov.kaefik.an_todolist.MainActivity;

// класс задачи
public class TaskToDo {

    //параметры для передачи
    public static final String TASK_TITLE = "titleTask";
    public static final String TASK_ID = "idTask";
    public static final String TASK_CHECK = "checkTask";
    public static final String TASK_DATECREATE = "dateCreateTask";
    //END - параметры для передачи

    private Long id;  // id задачи
    private String title;  // заголовок задачи
    private boolean check;  // true - задача выполнена, иначе не выполнена
    private Date dateToDoCreate;  // дата/время создания задачи
//    private String description;  // описание задачи
//    private String linkToPhoto;  // ссылка на фото для задачи
//    private String location;   // местоположение для задачи
//    private Date dateToDoAlert;  // дата/время  задачи для напоминания
//    private Long priority;  // приоритет задачи


    public TaskToDo(Long id, String title, boolean check, Date dateToDoCreate) {
        this.id = id;
        this.title = title;
        this.check = check;
        this.dateToDoCreate = dateToDoCreate;
    }


    public TaskToDo(String title) {
        this.title = title;
        this.setDateToDoCreate();
        check = false;
        id = 0l;
    }

    public TaskToDo(String title, boolean check) {
        this.title = title;
        this.check = check;
        this.setDateToDoCreate();
        id = 0l;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Date getDateToDoCreate() {
        return dateToDoCreate;
    }

    // присвоение текущей даты и времени
    public void setDateToDoCreate() {
        this.dateToDoCreate = new Date();
    }


    public void setDateToDoCreate(String strDate) {
        //TODO: сделать перевод строки в тип даты
//        this.dateToDoCreate = new Date();
    }

    // добавление данных класса в Intent
    public Intent putExtraIntent(Context context, Class<?> klass) {
        Intent intent = new Intent(context, klass);
        intent.putExtra(TASK_TITLE, this.getTitle());
        intent.putExtra(TASK_ID, this.getId());
        intent.putExtra(TASK_DATECREATE, this.getDateToDoCreate().toString());
        intent.putExtra(TASK_CHECK, this.isCheck());
        return intent;
    }

    // получение данных от Intent
    public void getExtraIntent(Intent intent) {
        this.setId(intent.getLongExtra(TASK_ID, 0l));
        this.setTitle(intent.getStringExtra(TASK_TITLE));
        this.setCheck(intent.getBooleanExtra(TASK_CHECK, false));
        //TODO: сделать преобразование из String to Date
//        this.getDateToDoCreate(intent.getStringExtra(TASK_DATECREATE));
    }

    //функция сравнения задач  - сделано проверки только равенства title и check
    public boolean compareTitle(TaskToDo taskToDo){
        if(getTitle().compareTo(taskToDo.getTitle())==0){
            return true; // совпадение title и check
        } else {
            return  false;
        }
    }

    //функция сравнения задач  - сделано проверки только равенства title и check
    public boolean compareCheck(TaskToDo taskToDo){
        if(isCheck()==taskToDo.isCheck()){
            return true; // совпадение title и check
        } else {
            return  false;
        }
    }


    public boolean compare(TaskToDo taskToDo){
        if(compareTitle(taskToDo) && compareCheck(taskToDo)){
            return true;
        }else
    }



}
