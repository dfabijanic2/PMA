package com.example.myapplication.classes;

public class StudentInfoView {
    public String FirstName;
    public String LastName;
    public String ClassName;
    public StudentInfoView(String firstName, String lastName, String className)
    {
        FirstName = firstName;
        LastName = lastName;
        ClassName = className;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getClassName() {
        return ClassName;
    }
}
