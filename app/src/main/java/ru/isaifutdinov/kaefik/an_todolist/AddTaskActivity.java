package ru.isaifutdinov.kaefik.an_todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {

    EditText mTitleTaskEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTitleTaskEditText = (EditText) findViewById(R.id.TitleTaskEditText);

        // получение данных от основного активити
        Intent intent = getIntent();
        mTitleTaskEditText.setText(intent.getStringExtra("titleTask"));


    }


//    @Override
//    //обработка нажатия клавиши Назад
//    public void onBackPressed() {
//        try {
//            goBackMainActivity();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
}
