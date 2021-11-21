package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.StudentInfo;
import com.google.android.material.textfield.TextInputLayout;

public class SummaryActivity extends AppCompatActivity {

    private TextView txtPIFirstName;
    private TextView txtPILastName;
    private TextView txtPIBirthDate;

    private TextView txtSIFirstName;
    private TextView txtSILastName;
    private TextView txtSIClassName;
    private TextView txtSIAcademyYear;
    private TextView txtSIhoursLection;
    private TextView txtSIhoursLV;

    private Button btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        txtPIFirstName = (TextView) findViewById(R.id.txtPIFirstName);
        txtPILastName = (TextView) findViewById(R.id.txtPILastName);
        txtPIBirthDate = (TextView) findViewById(R.id.txtPIBirthDate);

        txtSIFirstName = (TextView) findViewById(R.id.txtSIFirstName);
        txtSILastName = (TextView) findViewById(R.id.txtSILastName);
        txtSIClassName = (TextView) findViewById(R.id.txtSIClassName);
        txtSIAcademyYear = (TextView) findViewById(R.id.txtSIAcademyYear);
        txtSIhoursLection = (TextView) findViewById(R.id.txtSIhoursLection);
        txtSIhoursLV = (TextView) findViewById(R.id.txtSIhoursLV);

        btnReturn = (Button) findViewById(R.id.btnReturn);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            PersonalInfo personalInfo = (PersonalInfo) extras.getSerializable("personal_info");
            StudentInfo studentInfo = (StudentInfo) extras.getSerializable("student_info");

            txtPIFirstName.setText(personalInfo.FirstName);
            txtPILastName.setText(personalInfo.LastName);
            txtPIBirthDate.setText(personalInfo.BirthDate);

            txtSIFirstName.setText(studentInfo.firstName);
            txtSILastName.setText(studentInfo.lastName);
            txtSIClassName.setText(studentInfo.className);
            txtSIAcademyYear.setText(studentInfo.academYear);
            txtSIhoursLection.setText(studentInfo.hoursLection);
            txtSIhoursLV.setText(studentInfo.hoursLV);
        }

        btnReturn.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        });

    }
}