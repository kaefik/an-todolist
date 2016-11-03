package ru.isaifutdinov.kaefik.an_todolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.util.ArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.isaifutdinov.kaefik.an_todolist.Adapter.TaskRecyclerAdapter;
import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    RecyclerView mTasksRecyclerView;
    Spinner mlistTaskSpinner;

    Map<String, List<TaskToDo>> mTaskListMap; // хранилище списков дел с задачами
    String tekNameList;

    List<TaskToDo> mTaskList; // спсиок дел - пока один -> TODO: заменить на массив списка дел

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        // Обработка нажатия на кнопку + (добавить задачу)
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // заполняем выпадающий список значениями по умолчанию
        Spinner spinner = (Spinner) findViewById(R.id.listTaskSpinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, this.getListNames());
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
//                R.array.listtasks, android.R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //вывод заданий согласно текущему списку
        mlistTaskSpinner = (Spinner) findViewById(R.id.listTaskSpinner);
        mTasksRecyclerView = (RecyclerView) findViewById(R.id.tasksRecyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mTasksRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mTasksRecyclerView.setLayoutManager(mLayoutManager);


        //TODO: сделать выбор списка и фильтрация данных
        //заполнения тестовыми задачами
        mTaskListMap = new ArrayMap<String, List<TaskToDo>>();

        List<TaskToDo> tempTask = new ArrayList<TaskToDo>();
        tempTask.add(new TaskToDo("Milk", false));
        tempTask.add(new TaskToDo("Хлеб"));
        tempTask.add(new TaskToDo("купить незамерзайку Love Milk How match?", true));
        tempTask.add(new TaskToDo("позввонить любимой"));
        mTaskListMap.put(this.getListNames().get(0), tempTask);

        tempTask = new ArrayList<TaskToDo>();
        tempTask.add(new TaskToDo("сходить в магазин", false));
        tempTask.add(new TaskToDo("начать учить анг яз"));
        mTaskListMap.put(this.getListNames().get(1), tempTask);

        tempTask = new ArrayList<TaskToDo>();
        mTaskListMap.put(this.getListNames().get(2), tempTask);
        //END - заполнения тестовыми задачами


//        mAdapter = new TaskRecyclerAdapter(mTaskListMap.get(getListNames().get(0)), null);
        refreshListRecyclerView(getListNames().get(0));


    }

    //возращает имена списков дел (задач) - TODO: сделать чтобы восстановление имеющихся списков дел было из файла настроек или из базы данных
    public List<String> getListNames() {
        List<String> namesList = new ArrayList<String>();
        namesList.add("All");
        namesList.add("Today");
        namesList.add("Shopping");
        return namesList;
    }

    //возвращает текущий список задач

    public String getTekNameList() {
        return tekNameList;
    }


    public void setTekNameList(String tekNameList) {
        this.tekNameList = tekNameList;
    }

    // обработчик выбранного элемента элемента mlistTaskSpinner
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // Получаем выбранный объект
        Object item = parent.getItemAtPosition(pos);
        this.setTekNameList(item.toString());
        refreshListRecyclerView(this.getTekNameList());
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show();

    }

    public void refreshListRecyclerView(String nameList) {
        if (mTaskListMap.get(nameList) != null) {
            mAdapter = new TaskRecyclerAdapter(mTaskListMap.get(nameList), new TaskRecyclerAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(final TaskToDo item) {
//                    startActivityForResult(tmpCityModel.putExtraIntent(getApplicationContext(),  AddTaskActivity.class), RequestCode.REQUEST_CODE_CITY_WEATHER);
                    Intent intent = new Intent(getApplicationContext(),AddTaskActivity.class);
                    intent.putExtra("titleTask",item.getTitle());
                     startActivity(intent);
                    Toast.makeText(getApplicationContext(), "нажали на элемент списка -> " + item.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
            mTasksRecyclerView.setAdapter(mAdapter);
        } else {
            Toast.makeText(getApplicationContext(), " Что-то пошло не так. Свяжитесь с разработчиком.", Toast.LENGTH_SHORT).show();
        }
    }


    public void onNothingSelected(AdapterView<?> parent) {
        // Обработка события
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
