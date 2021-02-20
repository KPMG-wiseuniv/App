package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

//fragment for showing result of second survey

public class ThirdSurveyFragment_Result extends Fragment {

    ConditionSurveyActivity activity;

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
        activity=(ConditionSurveyActivity) getActivity();
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
        Button ok_button=view.findViewById(R.id.ok_button);
        Button again_button=view.findViewById(R.id.again_button);

        result_furniture.setText(ManageFurniture.getInstance().getFurniture().getTh_cat());
        result_charge.setText(activity.getPrice());
        result_function.setText(activity.getFunction());
        result_style.setText(activity.getStyle());

        setting_ok_button(ok_button);
        setting_again_button(again_button);

        setting_date();

        return view;
    }

    public void setting_ok_button(Button btn){//setting ok button that go to next step
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ManageFurniture.getInstance().getFurniture().setStyle(activity.getStyle());
//                ManageFurniture.getInstance().getFurniture().setFunction(activity.getFunction());
//                ManageFurniture.getInstance().getFurniture().setPrice(activity.getPrice());

                Furniture newdata=new Furniture();
                newdata.setDate(ManageFurniture.getInstance().getDate());
                newdata.setBig_cat(ManageFurniture.getInstance().getBig_cat());
                newdata.setSec_cat(ManageFurniture.getInstance().getSec_cat());
                newdata.setTh_cat(ManageFurniture.getInstance().getTh_cat());
                newdata.setStyle(activity.getStyle());
                newdata.setFunction(activity.getFunction());
                newdata.setPrice(activity.getPrice());
                ManageFurniture.getInstance().addnewdata(newdata);

                activity.finish();
                startActivity(new Intent(activity, PictureActivity.class));
            }
        });
    }

    public void setting_again_button(Button btn){//setting back button that back to first category of second survey
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.replaceFragment(ThirdSurveyFragment_Style.newInstance());
            }
        });
    }

    public void setting_date(){
        long now=System.currentTimeMillis();
        Date mDate=new Date(now);
        SimpleDateFormat today=new SimpleDateFormat("yyyy-MM-dd");
        ManageFurniture.getInstance().setDate(today.format(mDate));
    }
}