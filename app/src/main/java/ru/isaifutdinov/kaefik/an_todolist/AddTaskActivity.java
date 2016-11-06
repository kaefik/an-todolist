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

                Intent intent = new Intent();
                intent.putExtra(MainActivity.TASK_TITLE, mTitleTaskEditText.getText().toString());
                intent.putExtra(MainActivity.TASK_ID, 0);
                intent.putExtra(MainActivity.TASK_DATECREATE, mDataCreateTaskTextView.getText().toString());
                intent.putExtra(MainActivity.TASK_CHECK, mDoneTaskCheckBox.isChecked());

                setResult(RESULT_OK, intent);
                finish();

            }
        });

        // получение данных от основного активити
        Intent intent = getIntent();
//        intent.putExtra(TASK_ID,item.getId());
        mTitleTaskEditText.setText(intent.getStringExtra(MainActivity.TASK_TITLE));
        mDoneTaskCheckBox.setChecked(intent.getBooleanExtra(MainActivity.TASK_CHECK, false));
        mDataCreateTaskTextView.setText(intent.getStringExtra(MainActivity.TASK_DATECREATE));


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("AddTask Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
