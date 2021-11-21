package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.Storage;
import com.example.myapplication.classes.StudentInfo;
import com.example.myapplication.classes.StudentInfoView;
import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        Button btnInput = (Button) findViewById(R.id.btnActivityInfo);
        btnInput.setOnClickListener(v -> {
            TextInputLayout professorFirstNameLayout = (TextInputLayout) findViewById(R.id.txtProfesorFirstName);
            String firstName = professorFirstNameLayout.getEditText().getText().toString();

            TextInputLayout professorLastNameLayout = (TextInputLayout) findViewById(R.id.txtProfesorLastName);
            String lastName = professorLastNameLayout.getEditText().getText().toString();

            TextInputLayout classNameLayout = (TextInputLayout) findViewById(R.id.txtClassName);
            String className = classNameLayout.getEditText().getText().toString();

            TextInputLayout academYearLayout = (TextInputLayout) findViewById(R.id.txtAcademYear);
            String academYear = academYearLayout.getEditText().getText().toString();

            TextInputLayout hoursLectionLayout = (TextInputLayout) findViewById(R.id.txtClassHoursLection);
            String hoursLection = hoursLectionLayout.getEditText().getText().toString();

            TextInputLayout hoursLVLayout = (TextInputLayout) findViewById(R.id.txtHoursLV);
            String hoursLV = hoursLVLayout.getEditText().getText().toString();

            StudentInfo studentInfo = new StudentInfo(firstName, lastName, className, academYear, hoursLection, hoursLV);

            Intent i = new Intent(this, SummaryActivity.class);
            i.putExtra("student_info", studentInfo);
            Bundle extras = getIntent().getExtras();
            if (extras != null){
                PersonalInfo personalInfo = (PersonalInfo) extras.getSerializable("personal_info");
                if(personalInfo != null){
                    i.putExtra("personal_info", personalInfo);
                    Storage.getInstance().setStudents(new StudentInfoView(personalInfo.FirstName, personalInfo.LastName, className));
                }
            }

            startActivity(i);
        });
    }
}