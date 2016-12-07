package ru.isaifutdinov.kaefik.an_todolist.Task;

import android.content.Context;
import android.content.Intent;
import android.text.format.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

import ru.isaifutdinov.kaefik.an_todolist.AddTaskActivity;
import ru.isaifutdinov.kaefik.an_todolist.MainActivity;

// класс задачи
public class TaskToDo {

    //параметры для передачи
    public static final String TASK_ID = "idTask";
    public static final String TASK_TITLE = "titleTask";
    public static final String TASK_CHECK = "checkTask";
    public static final String TASK_DATECREATE = "dateCreateTask";
    public static final String TASK_UPDATECHECK = "updateCheckTask"; // параметр модификации задачи
    //END - параметры для передачи

    private Integer id;  // id задачи
    private String title;  // заголовок задачи
    private boolean check;  // true - задача выполнена, иначе не выполнена
    private String dateToDoCreate;  // дата/время создания задачи
    private boolean updateCheck;  // true - задача была изменена, иначе ничего не меняли
//    private String description;  // описание задачи
//    private String linkToPhoto;  // ссылка на фото для задачи
//    private String location;   // местоположение для задачи
//    private Date dateToDoAlert;  // дата/время  задачи для напоминания
//    private Long priority;  // приоритет задачи


    public TaskToDo(Integer id, String title, boolean check, String dateToDoCreate) {
        this.id = id;
        this.title = title;
        this.check = check;
        this.dateToDoCreate = dateToDoCreate;
        updateCheck=false;
    }


    public TaskToDo(String title) {
        this.title = title;
        this.setDateToDoCreate("");
        check = false;
        id = -1;
        updateCheck=false;
    }

    public TaskToDo(String title, boolean check) {
        this.title = title;
        this.check = check;
        this.setDateToDoCreate();
        id = -1;
        updateCheck=false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getDateToDoCreate() {
        return dateToDoCreate;
    }

    // присвоение текущей даты и времени
    public void setDateToDoCreate() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        this.dateToDoCreate = df.format(new Date()).toString();

    }


    public void setDateToDoCreate(String strDate) {
        // TODO: сделать проверку strDate на соответствия шаблона "dd-MM-yyyy HH:mm:ss"
        this.dateToDoCreate = strDate;

    }

    public boolean isUpdateCheck() {
        return updateCheck;
    }

    public void setUpdateCheck(boolean updateCheck) {
        this.updateCheck = updateCheck;
    }

    // добавление данных класса в Intent
    public Intent putExtraIntent(Context context, Class<?> klass) {
        Intent intent = new Intent(context, klass);
        intent.putExtra(TASK_TITLE, this.getTitle());
        intent.putExtra(TASK_ID, this.getId());
        intent.putExtra(TASK_DATECREATE, this.getDateToDoCreate().toString());
        intent.putExtra(TASK_CHECK, this.isCheck());
        intent.putExtra(TASK_UPDATECHECK, this.isUpdateCheck());
        return intent;
    }

    // получение данных от Intent
    public void getExtraIntent(Intent intent) {
        this.setId(intent.getIntExtra(TASK_ID,0));
        this.setTitle(intent.getStringExtra(TASK_TITLE));
        this.setCheck(intent.getBooleanExtra(TASK_CHECK, false));
        this.setDateToDoCreate(intent.getStringExtra(TASK_DATECREATE));
        this.setUpdateCheck(intent.getBooleanExtra(TASK_UPDATECHECK, false));
    }

    //функция сравнения задач  - сделано проверки только равенства title и check
    public boolean compareTitle(TaskToDo taskToDo) {
        if (getTitle().compareTo(taskToDo.getTitle()) == 0) {
            return true; // совпадение title и check
        } else {
            return false;
        }
    }

    //функция сравнения задач  - сделано проверки только равенства title и check
    public boolean compareCheck(TaskToDo taskToDo) {
        if (isCheck() == taskToDo.isCheck()) {
            return true; // совпадение title и check
        } else {
            return false;
        }
    }

    //функция сравнения двух задач - проверка по Title и Check
    public boolean compare(TaskToDo taskToDo) {
        if (compareTitle(taskToDo) && compareCheck(taskToDo)) {
            return true;
        } else {
            return false;
        }
    }




}
