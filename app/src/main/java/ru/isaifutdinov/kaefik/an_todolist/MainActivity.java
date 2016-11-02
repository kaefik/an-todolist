package ru.isaifutdinov.kaefik.an_todolist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
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

import ru.isaifutdinov.kaefik.an_todolist.Adapter.TaskRecyclerAdapter;
import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    RecyclerView mTasksRecyclerView;
    Spinner listTaskSpinner;

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
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.listtasks, android.R.layout.simple_spinner_item);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        //вывод заданий согласно текущему списку
        listTaskSpinner = (Spinner) findViewById(R.id.listTaskSpinner);
        mTasksRecyclerView = (RecyclerView) findViewById(R.id.tasksRecyclerView);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mTasksRecyclerView.setHasFixedSize(false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mTasksRecyclerView.setLayoutManager(mLayoutManager);


        //TODO: сделать выбор списка и фильтрация данных
        //заполнения тестовыми задачами
        mTaskList = new ArrayList<TaskToDo>();
        mTaskList.add(new TaskToDo("Milk",false));
        mTaskList.add(new TaskToDo("Хлеб"));
        mTaskList.add(new TaskToDo("купить незамерзайку Love Milk How match?",true));
        mTaskList.add(new TaskToDo("позввонить любимой"));



        mAdapter = new TaskRecyclerAdapter(mTaskList,null);
        //TODO: сделать обработку нажатий на элемент списка
//                , new TaskRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(final String item) {
//                Toast.makeText(this,"нажали на элемент списка").show();
//                Log.i(ConfigActivity.TAG_SERVICE, " выбран элемент  -> " + item);


//                AlertDialog.Builder builder = new AlertDialog.Builder(AddNewCityActivity.this);
//                builder.setTitle("Сделали правильный выбор?");
//                builder.setMessage(item);
//                builder.setCancelable(true);
//                builder.setPositiveButton("Да", new DialogInterface.OnClickListener() { // Кнопка ОК
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//
//
//                    }
//                });
//                AlertDialog dialog = builder.create();
//                dialog.show();

//            }
//        });
        mTasksRecyclerView.setAdapter(mAdapter);

    }


    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // Получаем выбранный объект
        Object item = parent.getItemAtPosition(pos);
        Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();

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
