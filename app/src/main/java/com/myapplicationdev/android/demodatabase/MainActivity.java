package com.myapplicationdev.android.demodatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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
        Button btnClear = findViewById(R.id.btnClear);
        DBHelper db = new DBHelper(MainActivity.this);
        ArrayList<Task> data = db.getTasks();
        ArrayAdapter<?> aaTask = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        tv.setAdapter(aaTask);

        btnClear.setOnClickListener(v -> db.clearTask());
        btnInsert.setOnClickListener(v -> db.insertTask("Submit RJ", "25 Apr 2021"));
        btnGetTasks.setOnClickListener(v -> {

            db.close();
            String txt = "";
//            String txtListItem = "";
            for (int i = 0; i < data.size(); i++) {
                Log.d("Database Content", i + ". " + data.get(i));
                txt += i + ". "+ data.get(i) + "\n";
                /*txtListItem += i + "\n"
                        + data.get(i).getDecription() + "\n"
                        + data.get(i).getDate() + "\n";*/
                aaTask.notifyDataSetChanged();
            }

            tvResults.setText(txt);

        });

    }
}