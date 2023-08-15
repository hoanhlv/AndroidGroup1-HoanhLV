package com.huy.androidcourseapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.huy.androidcourseapp.practices.Practice1;
import com.huy.androidcourseapp.practices.Practice2;
import com.huy.androidcourseapp.practices.Practice3;
import com.huy.androidcourseapp.practices.Practice4;

public class MainActivity extends AppCompatActivity {
    String[] practiceList = new String[] {
            "Practice 1 - Android Components",
            "Practice 2 - Layouts",
            "Practice 3 - Widgets",
            "Practice 4 - Date, Time, Tab",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setTitle("Group 1");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_listpractice, practiceList);
        android.widget.ListView listView = findViewById(R.id.practice_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = null;
                Context appContext = getApplicationContext();
                switch (position + 1) {
                    case 1:
                    default:
                        intent = new Intent(appContext, Practice1.class);
                        break;
                    case 2:
                        intent = new Intent(appContext, Practice2.class);
                        break;
                    case 3:
                        intent = new Intent(appContext, Practice3.class);
                        break;
                    case 4:
                        intent = new Intent(appContext, Practice4.class);
                        break;
                }
                startActivity(intent);
            }
        });
    }
}