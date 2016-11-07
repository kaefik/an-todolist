package ru.isaifutdinov.kaefik.an_todolist.Task;

import java.util.Date;

// класс задачи
public class TaskToDo {


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
}
