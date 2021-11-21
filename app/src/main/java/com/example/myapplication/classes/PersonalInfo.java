package com.example.myapplication.classes;

import java.io.Serializable;
import java.util.Date;

public class PersonalInfo implements Serializable {
    public String FirstName;
    public String LastName;
    public String BirthDate;

    public PersonalInfo(String firstName, String lastName, String birthDate){
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
    }
}
