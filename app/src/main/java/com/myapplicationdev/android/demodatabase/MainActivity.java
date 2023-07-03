package com.myapplicationdev.android.demodatabase;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnInsert, btnGetTasks;
    TextView tvResults;
    ListView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnGetTasks = findViewById(R.id.btnGetTasks);
        tvResults = findViewById(R.id.tvResults);
        tv = findViewById(R.id.tv);
        DBHelper db = new DBHelper(MainActivity.this);
        EditText editTask = findViewById(R.id.editTask);
        EditText editDate = findViewById(R.id.editDate);

        btnInsert.setOnClickListener(v -> db.insertTask(editTask.getText().toString(), editDate.getText().toString()));
        btnGetTasks.setOnClickListener(v -> {
            ArrayList<Task> data = db.getTasks();
            ArrayAdapter<?> aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
            tv.setAdapter(aaTask);
            db.close();
            String txt = "";
//            String txtListItem = "";
            for (int i = 0; i < data.size(); i++) {
                Log.d("Database Content", i + ". " + data.get(i));
                txt += data.get(i) + "\n";
                /*txtListItem += i + "\n"
                        + data.get(i).getDecription() + "\n"
                        + data.get(i).getDate() + "\n";*/
                aaTask.notifyDataSetChanged();
            }

            tvResults.setText(txt);

        });

    }
}