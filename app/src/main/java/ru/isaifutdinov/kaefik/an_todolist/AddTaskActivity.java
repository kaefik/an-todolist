package ru.isaifutdinov.kaefik.an_todolist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import ru.isaifutdinov.kaefik.an_todolist.Task.TaskToDo;

public class AddTaskActivity extends AppCompatActivity {

    EditText mTitleTaskEditText;
    CheckBox mDoneTaskCheckBox;
    TextView mDataCreateTaskTextView;
    Button mApplyButton;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTitleTaskEditText = (EditText) findViewById(R.id.titleTaskEditText);
        mDoneTaskCheckBox = (CheckBox) findViewById(R.id.doneTaskCheckBox);
        mDataCreateTaskTextView = (TextView) findViewById(R.id.dataCreateTaskTextView);
        mApplyButton = (Button) findViewById(R.id.createTaskButton);

        mApplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TaskToDo tempTaskTODo = new TaskToDo("");
                tempTaskTODo.setId(0l);
                tempTaskTODo.setTitle(mTitleTaskEditText.getText().toString());
                tempTaskTODo.setDateToDoCreate(mDataCreateTaskTextView.getText().toString());
                tempTaskTODo.setCheck(mDoneTaskCheckBox.isChecked());

                setResult(RESULT_OK, tempTaskTODo.putExtraIntent(getApplicationContext(), MainActivity.class));
                finish();

            }
        });

        // получение данных от основного активити
//        Intent intent = getIntent();
        TaskToDo tempTaskTodo = new TaskToDo("");
        tempTaskTodo.getExtraIntent(getIntent());
        //TODO: сделать получение ID и DateCreate
//        tempTaskTodo.getId();
        mTitleTaskEditText.setText(tempTaskTodo.getTitle());
        mDoneTaskCheckBox.setChecked(tempTaskTodo.isCheck());
//        mDataCreateTaskTextView.setText(tempTaskTodo.getDateToDoCreate());

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


//    public void onApplyButton(View v) {
//
//        Intent intent = new Intent(this, MainActivity.class);
//        intent.putExtra(MainActivity.TASK_TITLE, mTitleTaskEditText.getText());
//        intent.putExtra(MainActivity.TASK_ID, 0);
//        intent.putExtra(MainActivity.TASK_DATECREATE, mDataCreateTaskTextView.getText());
//        intent.putExtra(MainActivity.TASK_CHECK, mDoneTaskCheckBox.isChecked());
//
//        setResult(RESULT_OK, intent);
//        finish();
//
//    }

}
