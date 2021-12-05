package com.example.myapplication.interfaces;

import com.example.myapplication.models.Course;
import com.example.myapplication.models.CourseResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CoursesService {

        @GET("/v1/courses")
        Call<CourseResponse> getCourses();

}
