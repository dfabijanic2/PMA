package com.example.myapplication.classes;

import android.graphics.Bitmap;

import java.io.Serializable;
import java.util.Date;
import java.util.Observable;

public class PersonalInfo extends Observable implements Serializable {
    public String FirstName;
    public String LastName;
    public String BirthDate;
    public Bitmap Image;

    public  PersonalInfo(){}

    public PersonalInfo(String firstName, String lastName, String birthDate, Bitmap image){
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        Image = image;

    }

    public void SetPersonalInfo(String firstName, String lastName, String birthDate, Bitmap image){
        FirstName = firstName;
        LastName = lastName;
        BirthDate = birthDate;
        Image = image;

        setChanged();
        notifyObservers();
    }


}
