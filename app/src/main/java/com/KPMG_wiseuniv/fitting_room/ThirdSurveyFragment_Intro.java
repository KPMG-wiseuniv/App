package com.KPMG_wiseuniv.fitting_room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ThirdSurveyFragment_Intro extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdSurveyFragment_Intro() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ThirdSurveyFragment_Intro newInstance() {
        return new ThirdSurveyFragment_Intro();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_survey_intro, null);
        Button btn = (Button)view.findViewById(R.id.ok_button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((ConditionSurveyActivity)getActivity()).replaceFragment(ThirdSurveyFragment_Style.newInstance());
            }
        });
        return view;
    }
}