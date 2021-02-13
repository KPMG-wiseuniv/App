package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdSurveyFragment_Charge#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdSurveyFragment_Charge extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private TextView money;
    ConditionSurveyActivity activity;

    public ThirdSurveyFragment_Charge() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ThirdSurveyFragment_Charge newInstance() {
        return new ThirdSurveyFragment_Charge();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity=(ConditionSurveyActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_third_survey_charge, container, false);
        Button btn = (Button) view.findViewById(R.id.finish_button);
        final SeekBar seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        money = (TextView) view.findViewById(R.id.charge);

        seekBar.setProgress(0);
        money.setText("0");

        seekBar.setOnSeekBarChangeListener(this);

        if(seekBar.getProgress() == seekBar.getMax()){
            money.setText(seekBar + "+");
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.setPrice(money.getText().toString());
                activity.replaceFragment(ThirdSurveyFragment_Result.newInstance());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        money.setText("" + progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}