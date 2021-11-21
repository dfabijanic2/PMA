package com.example.myapplication.classes;

import java.io.Serializable;

public class StudentInfo implements Serializable {
    public String firstName;
    public String lastName;
    public String className;
    public String academYear;
    public String hoursLection;
    public String hoursLV;

    public StudentInfo(String firstName, String lastName, String className, String academYear, String hoursLection, String hoursLV) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.academYear = academYear;
        this.hoursLection = hoursLection;
        this.hoursLV = hoursLV;
    }
}
