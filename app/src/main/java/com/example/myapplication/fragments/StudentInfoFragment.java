package com.example.myapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.classes.StudentInfo;
import com.example.myapplication.models.ApiManager;
import com.example.myapplication.models.Course;
import com.example.myapplication.models.CourseResponse;
import com.example.myapplication.models.Instructor;
import com.google.android.material.textfield.TextInputLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StudentInfoFragment extends Fragment implements DataChangedListener, Callback<CourseResponse>, AdapterView.OnItemSelectedListener {
    private TextInputLayout academYear;
    private TextInputLayout hoursLection;
    private TextInputLayout hoursLV;
    private Spinner spinerCourses;
    private Spinner spinerInstructors;


    ArrayList<Course> courses;
    ArrayList<Instructor> instructors;

    public StudentInfo StudentInfo;
    private String selectedCourseTitle = "";
    private String selectedInstructorName = "";

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
        academYear = view.findViewById(R.id.txtAcademYear);
        hoursLection = view.findViewById(R.id.txtClassHoursLection);
        hoursLV = view.findViewById(R.id.txtHoursLV);

        spinerCourses = (Spinner) view.findViewById(R.id.spinnerClasses);
        spinerCourses.setOnItemSelectedListener(this);

        spinerInstructors = (Spinner) view.findViewById(R.id.spinnerInstructors);
        spinerInstructors.setOnItemSelectedListener(this);
    }

    @Override
    public void setData() {
        try {
            StudentInfo.SetStudentInfo(selectedInstructorName, "", selectedCourseTitle, academYear.getEditText().getText().toString(), hoursLection.getEditText().getText().toString(), hoursLV.getEditText().getText().toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {

        if (response.isSuccessful() && response.body() != null){
            courses = response.body().getCoursesList();
            List<String > coursesTitle = courses.stream().map(c -> c.GetTitle()).collect(Collectors.toList());
            ArrayAdapter aa = new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item, coursesTitle);
            aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            spinerCourses.setAdapter(aa);
        }

    }

    @Override
    public void onFailure(Call<CourseResponse> call, Throwable t) {
        t.printStackTrace();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(parent.getId() == R.id.spinnerClasses){
            Course selectedCourse = courses.get(position);
            selectedCourseTitle = selectedCourse.GetTitle();
            instructors = selectedCourse.getInstructors();
            if(instructors != null){
                List<String > instructorsNames = instructors.stream().map(c -> c.getName()).collect(Collectors.toList());
                ArrayAdapter aa = new ArrayAdapter(this.getContext(),android.R.layout.simple_spinner_item, instructorsNames);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                //Setting the ArrayAdapter data on the Spinner
                spinerInstructors.setAdapter(aa);
            }
        }else if(parent.getId() == R.id.spinnerInstructors){
            Instructor selectedInstructor = instructors.get(position);
            selectedInstructorName = selectedInstructor.getName();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        selectedCourseTitle = "";
        selectedInstructorName = "";
    }
}