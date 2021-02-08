package com.KPMG_wiseuniv.fitting_room;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ThirdSurveyFragment_Function extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdSurveyFragment_Function() {
        // Required empty public constructor
    }

    public static ThirdSurveyFragment_Function newInstance() {
        return new ThirdSurveyFragment_Function();
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
        View view = inflater.inflate(R.layout.fragment_third_survey_function, container, false);
        Button btn1 = (Button)view.findViewById(R.id.design_button);
        Button btn2 = (Button)view.findViewById(R.id.function_button);
        TextView txt = (TextView)view.findViewById(R.id.style_result);

        Bundle data = getArguments();
        String styleResult = null;
        if (data != null) {
            styleResult = data.getString("result");
        }
        txt.setText(styleResult);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(ThirdSurveyFragment_Charge.newInstance());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).replaceFragment(ThirdSurveyFragment_Charge.newInstance());
            }
        });
        return view;
    }
}