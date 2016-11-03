package ru.isaifutdinov.kaefik.an_todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {

    EditText mTitleTaskEditText;
    CheckBox mDoneTaskCheckBox;
    TextView mDataCreateTaskTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        mTitleTaskEditText = (EditText) findViewById(R.id.titleTaskEditText);
        mDoneTaskCheckBox = (CheckBox) findViewById(R.id.doneTaskCheckBox);
        mDataCreateTaskTextView = (TextView) findViewById(R.id.dataCreateTaskTextView);

        // получение данных от основного активити
        Intent intent = getIntent();
//        intent.putExtra(TASK_ID,item.getId());
        mTitleTaskEditText.setText(intent.getStringExtra(MainActivity.TASK_TITLE));
        mDoneTaskCheckBox.setChecked(intent.getBooleanExtra(MainActivity.TASK_CHECK, false));
        mDataCreateTaskTextView.setText(intent.getStringExtra(MainActivity.TASK_DATECREATE));


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


    public void onApplyButton(View v) {

         Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra(MainActivity.TASK_TITLE,mTitleTaskEditText.getText());
        intent.putExtra(MainActivity.TASK_ID,0);
        intent.putExtra(MainActivity.TASK_DATECREATE, mDataCreateTaskTextView.getText());
        intent.putExtra(MainActivity.TASK_CHECK,mDoneTaskCheckBox.isChecked());

        setResult(RESULT_OK, intent);
        finish();

    }


}
