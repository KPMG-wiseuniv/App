package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import static android.os.SystemClock.sleep;

public class FirstSurveyActivity extends AppCompatActivity {
    FirstSurvey_Fragment survey_fragment;//fragment for three category survey
    FinishSurvey_Fragment finish_fragment;//fragment for showing result of three category survey
    String second_cat=null;
    String third_cat=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_survey);

        setting_fragment();

    }

    public void setting_fragment(){//for inflate fragment on memory
        survey_fragment=new FirstSurvey_Fragment();
        finish_fragment=new FinishSurvey_Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.firstsurveylayout_container, survey_fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.firstsurveylayout_container, finish_fragment).commit();
        getSupportFragmentManager().beginTransaction().hide(finish_fragment).commit();
    }

    public void finish_firstsurvey(){//for showing result of three category survey
        sleep(500);
        getSupportFragmentManager().beginTransaction().hide(survey_fragment).commit();
        getSupportFragmentManager().beginTransaction().show(finish_fragment).commit();
        finish_fragment.setting_result();
    }

    public void backtosurvey(){//for back to survey
        getSupportFragmentManager().beginTransaction().hide(finish_fragment).commit();
        getSupportFragmentManager().beginTransaction().show(survey_fragment).commit();
        second_cat=null;
        third_cat=null;
        survey_fragment.setting_again();
    }
    public String getSecond_cat() {
        return second_cat;
    }

    public void setSecond_cat(String second_cat) {
        this.second_cat = second_cat;
    }

    public String getThird_cat() {
        return third_cat;
    }

    public void setThird_cat(String third_cat) {
        this.third_cat = third_cat;
    }
}