package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.adapter.StudentAdapter;
import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.Storage;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class MainActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Storage spremnik = Storage.getInstance();
        List<Object> students = spremnik.getStudents();

        mRecyclerView = (RecyclerView) findViewById(R.id.ListStudents);
        mAdapter = new StudentAdapter(students);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Button btnStart = (Button) findViewById(R.id.btnStart);
        btnStart.setOnClickListener(v -> {

            Intent i = new Intent(this, CreateNewRecordActivity.class);
            startActivity(i);
        });
    }


}