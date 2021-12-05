package com.example.myapplication.fragments;

import android.content.PeriodicSync;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.StudentInfo;

import java.util.Observable;
import java.util.Observer;

public class SummaryFragment extends Fragment implements Observer {

    private TextView imeStudenta;
    private  TextView prezimeStudenta;
    private  TextView datumRodenja;

    private TextView imeProfesora;
    private  TextView prezimeProfesora;
    private  TextView predmet;
    private  TextView akademskaGodina;
    private  TextView satiPredavanja;
    private  TextView satiLV;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary, container, false);

        imeStudenta = view.findViewById(R.id.txtPIFirstName);
        prezimeStudenta = view.findViewById(R.id.txtPILastName);
        datumRodenja = view.findViewById(R.id.txtPIBirthDate);

        imeProfesora = view.findViewById(R.id.txtSIFirstName);
        predmet = view.findViewById(R.id.txtSIClassName);
        akademskaGodina = view.findViewById(R.id.txtSIAcademyYear);
        satiPredavanja = view.findViewById(R.id.txtSIhoursLection);
        satiLV = view.findViewById(R.id.txtSIhoursLV);
        return  view;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PersonalInfo){
            PersonalInfo pi = (PersonalInfo) o;
            try {
                imeStudenta.setText(pi.FirstName);
                prezimeStudenta.setText(pi.LastName);
                datumRodenja.setText(pi.BirthDate);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }else if(o instanceof StudentInfo){
            StudentInfo si = (StudentInfo) o;
            try {
                    imeProfesora.setText(si.firstName);
                    predmet.setText(si.className);
                    akademskaGodina.setText(si.academYear);
                    satiPredavanja.setText(si.hoursLection);
                    satiLV.setText(si.hoursLV);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}