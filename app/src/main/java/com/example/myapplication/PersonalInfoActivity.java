package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.Storage;
import com.example.myapplication.classes.StudentInfo;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        Button btnPersonalInfo = (Button) findViewById(R.id.btnPersonalInfo);
        btnPersonalInfo.setOnClickListener(v -> {
            TextInputLayout firstNameLayout = (TextInputLayout) findViewById(R.id.txtFirstName);
            String firstName = firstNameLayout.getEditText().getText().toString();

            TextInputLayout lastNameLayout = (TextInputLayout) findViewById(R.id.txtLastName);
            String lastName = lastNameLayout.getEditText().getText().toString();

            EditText birthDateLayout = (EditText) findViewById(R.id.txtBirthDate);
            String birthDate = birthDateLayout.getText().toString();

            PersonalInfo personalInfo = new PersonalInfo(firstName, lastName, birthDate, null);

            Intent i = new Intent(this, StudentInfoActivity.class);
            i.putExtra("personal_info", personalInfo);
            startActivity(i);
        });
    }

}