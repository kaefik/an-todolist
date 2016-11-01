package ru.isaifutdinov.kaefik.an_todolist.Task;

import java.util.Date;

// класс задачи
public class TaskToDo {
    private Long id;  // id задачи
    private String title;  // заголовок задачи
    private String description;  // описание задачи
    private String linkToPhoto;  // ссылка на фото для задачи
    private String location;   // местоположение для задачи
    private Date dateToDoCreate;  // дата/время создания задачи
    private Date dateToDoAlert;  // дата/время  задачи для напоминания
    private Long priority;  // приоритет задачи
    private boolean check;  // true - задача выполнена, иначе не выполнена


}
