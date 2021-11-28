package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.myapplication.classes.PersonalInfo;
import com.example.myapplication.classes.StudentInfo;
import com.example.myapplication.fragments.DataChangedListener;
import com.example.myapplication.fragments.PersonalInfoFragment;
import com.example.myapplication.fragments.StudentInfoFragment;
import com.example.myapplication.fragments.SummaryFragment;
import com.google.firebase.inappmessaging.ExperimentPayloadProto;

import java.lang.reflect.Array;
import java.util.Observable;
import java.util.Observer;

public class CreateNewRecordActivity extends FragmentActivity {

    private static final int NUM_PAGES = 3;
    private Fragment[] fragments;

    private StudentInfo studentInfo;
    private PersonalInfo personalInfo;

    private ViewPager2 viewPager;
    private FragmentStateAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_record);

        viewPager = findViewById(R.id.view_pager);
        pagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(pagerAdapter);


        studentInfo = new StudentInfo();
        personalInfo = new PersonalInfo();


        PersonalInfoFragment pifr = new PersonalInfoFragment();
        pifr.PersonalInfo = personalInfo;

        StudentInfoFragment sifr = new StudentInfoFragment();
        sifr.StudentInfo = studentInfo;

        Fragment sf = new SummaryFragment();
        ((Observable) personalInfo).deleteObservers();
        ((Observable) personalInfo).addObserver((Observer) sf);
        ((Observable) studentInfo).deleteObservers();
        ((Observable) studentInfo).addObserver((Observer) sf);

        sf.getView();

        fragments = new Fragment[] { pifr, sifr, sf};

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(fragments[position] instanceof SummaryFragment){
                    pifr.setData();
                    sifr.setData();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    private class ViewPagerAdapter extends FragmentStateAdapter{
        public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return fragments[position];
        }



        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }

}