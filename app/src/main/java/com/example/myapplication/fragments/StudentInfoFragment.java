package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.myapplication.R;
import com.example.myapplication.classes.StudentInfo;
import com.example.myapplication.models.ApiManager;
import com.example.myapplication.models.Course;
import com.example.myapplication.models.CourseResponse;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements DataChangedListener, Callback<CourseResponse> {

    private TextInputLayout firstName;
    private TextInputLayout lastName;
    private Spinner className;
    private TextInputLayout academYear;
    private TextInputLayout hoursLection;
    private TextInputLayout hoursLV;


    CourseResponse courses = new CourseResponse();

    public StudentInfo StudentInfo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_info, container, false);

        ApiManager.getInstance().service().getCourses().enqueue(this); //asinkroni poziv

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
        className = view.findViewById(R.id.spinnerClasses);
        hoursLV = view.findViewById(R.id.txtHoursLV);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<courses>(getActivity(),
                android.R.layout.simple_spinner_item, courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        className.setAdapter(adapter);
    }

    @Override
    public void setData() {
        try {
            StudentInfo.SetStudentInfo(firstName.getEditText().getText().toString(), lastName.getEditText().getText().toString(), className.getEditText().getText().toString(), academYear.getEditText().getText().toString(), hoursLection.getEditText().getText().toString(), hoursLV.getEditText().getText().toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {

        if (response.isSuccessful() && response.body() != null){
            courses=response.body();
        }

    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

}