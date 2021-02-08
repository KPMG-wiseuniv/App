package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FinishSurvey_Fragment extends Fragment {
    FirstSurveyActivity surveyActivity;
    TextView second_choice, third_choice;
    Button firstsurvey_okbtn, firstsurvey_backbtn;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        surveyActivity=(FirstSurveyActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        surveyActivity=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.finishfirstsurvey_fragment, container, false);

        setting_view(v);
        setting_okbtn();
        setting_backbtn();

        return v;
    }

    public void setting_view(View v){
        second_choice=v.findViewById(R.id.second_choice);
        third_choice=v.findViewById(R.id.third_choice);
        firstsurvey_okbtn=v.findViewById(R.id.firstsurvey_okbtn);
        firstsurvey_backbtn=v.findViewById(R.id.firstsurvey_backbtn);


    }

    public void setting_result(){
        second_choice.setText(surveyActivity.getSecond_cat());
        third_choice.setText(surveyActivity.getThird_cat());
    }
    public void setting_okbtn(){
        firstsurvey_okbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surveyActivity.finish();
                startActivity(new Intent(surveyActivity, ConditionSurveyActivity.class));
            }
        });
    }

    public void setting_backbtn(){
        firstsurvey_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                surveyActivity.backtosurvey();
            }
        });
    }
}
