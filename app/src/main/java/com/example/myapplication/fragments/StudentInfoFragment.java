package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.classes.StudentInfo;
import com.google.android.material.textfield.TextInputLayout;

public class StudentInfoFragment extends Fragment implements DataChangedListener {

    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private TextInputLayout className;
    private TextInputLayout academYear;
    private TextInputLayout hoursLection;
    private TextInputLayout hoursLV;

    public StudentInfo StudentInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);



        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        firstName = view.findViewById(R.id.txtProfesorFirstName);
        lastName = view.findViewById(R.id.txtProfesorLastName);
        className = view.findViewById(R.id.txtClassName);
        academYear = view.findViewById(R.id.txtAcademYear);
        hoursLection = view.findViewById(R.id.txtClassHoursLection);
        hoursLV = view.findViewById(R.id.txtHoursLV);
    }

    @Override
    public void setData() {
        try {
            StudentInfo.SetStudentInfo(firstName.getEditText().getText().toString(), lastName.getEditText().getText().toString(), className.getEditText().getText().toString(), academYear.getEditText().getText().toString(), hoursLection.getEditText().getText().toString(), hoursLV.getEditText().getText().toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}