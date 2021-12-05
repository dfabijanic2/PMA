package com.example.myapplication.models;

import com.example.myapplication.interfaces.CoursesService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {
    static ApiManager instance;
    private CoursesService service;
    private ApiManager(){
        Retrofit.Builder builder = new Retrofit.Builder();
        //postavljanje retrofit-a
        Retrofit retrofit = builder.baseUrl("https://catalog-api.udacity.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(CoursesService.class);
    }
    public static ApiManager getInstance(){
        if (instance == null){
            instance = new ApiManager();
        }
        return instance;
    }
    public CoursesService service(){
        return service;
    }
}
