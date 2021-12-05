package com.example.myapplication.models;

import java.util.ArrayList;

public class Course {

    private String title;
    private ArrayList<Instructor> instructors;


    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Instructor> getInstructors() {
        return instructors;
    }
}
