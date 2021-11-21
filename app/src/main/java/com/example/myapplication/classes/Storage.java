package com.example.myapplication.classes;
import java.util.ArrayList;
import java.util.List;

public class Storage {

    private List<Object> students;
    private Storage()
    {
        students = new ArrayList<Object>();
    }
    static private Storage instanca;

    public static Storage getInstance()
    {
        if(instanca==null)
        {
            instanca = new Storage();
            instanca.students.add("Studenti");
        }
        return  instanca;
    }

    public void setStudents(StudentInfoView student) {
        this.students.add(student);
    }

    public List<Object> getStudents() {
        return students;
    }
}
