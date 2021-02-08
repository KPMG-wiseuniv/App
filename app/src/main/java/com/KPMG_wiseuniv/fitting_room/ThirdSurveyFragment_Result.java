package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdSurveyFragment_Result#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdSurveyFragment_Result extends Fragment {

    MainActivity activity;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ThirdSurveyFragment_Result() {
        // Required empty public constructor
    }

    public static ThirdSurveyFragment_Result newInstance() {
        return new ThirdSurveyFragment_Result();
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
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity=(MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_third_survey_result, container, false);
        TextView result_furniture=view.findViewById(R.id.result_furniture);
        TextView result_charge=view.findViewById(R.id.result_charge);
        TextView result_function=view.findViewById(R.id.result_function);
        TextView result_style=view.findViewById(R.id.result_style);

        result_charge.setText(activity.getPrice());
        result_function.setText(activity.getFunction());
        result_style.setText(activity.getStyle());

        return view;
    }
}