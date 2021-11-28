package com.example.myapplication.classes;

import java.io.Serializable;
import java.util.Observable;

public class StudentInfo  extends Observable implements Serializable{
    public String firstName;
    public String lastName;
    public String className;
    public String academYear;
    public String hoursLection;
    public String hoursLV;

    public  StudentInfo(){}

    public StudentInfo(String firstName, String lastName, String className, String academYear, String hoursLection, String hoursLV) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.academYear = academYear;
        this.hoursLection = hoursLection;
        this.hoursLV = hoursLV;
    }

    public void SetStudentInfo(String firstName, String lastName, String className, String academYear, String hoursLection, String hoursLV) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.className = className;
        this.academYear = academYear;
        this.hoursLection = hoursLection;
        this.hoursLV = hoursLV;

        setChanged();
        notifyObservers();
    }
}
