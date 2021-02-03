package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class FirstSurveyActivity extends AppCompatActivity {
    TextView order_number, each_question;
    RecyclerView firstsurvey_recyclerview;//for survey
    int question_order;//order of question
    String first_cat, second_cat, third_cat;//for three result of each three category
    ArrayList<String> survey_data;//items for survey
    FirstSurvey_Adapter survey_adapter;//adapter for firstsurvey_recyclerview
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_survey);

        setting_view();
        setting_survey_recyclerview();
    }
    public void setting_view(){//for inflation and basic setting
        order_number=findViewById(R.id.order_number);
        each_question=findViewById(R.id.each_question);
        firstsurvey_recyclerview=findViewById(R.id.firstsurvey_recyclerview);

        question_order=1;
        order_number.setText("(1/3)");
        each_question.setText("Which residential space\ndo you want to style?");
        first_cat=null;second_cat=null;third_cat=null;

        survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngBig)));
    }



    public void setting_survey_recyclerview(){//for setting survey
        survey_adapter=new FirstSurvey_Adapter(survey_data, this);
        firstsurvey_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        firstsurvey_recyclerview.setAdapter(survey_adapter);

        survey_adapter.setOnItemClickListener(new FirstSurvey_Adapter.OnItemClickListener() {
            @Override
            public void OnItemClick(FirstSurvey_Adapter.FirstSurvey_ViewHolder holder, View view, int position) {//if user select one, then go to next question
                if(question_order==1){
                    first_cat=holder.category_item.getText().toString();
                    setting_new_recyclerview_data();
                    survey_adapter.changeData(survey_data);
                    order_number.setText("(2/3)");
                    each_question.setText("Which category of products do you want?");
                }
                else if(question_order==2){
                    second_cat=holder.category_item.getText().toString();
                    setting_new_recyclerview_data();
                    survey_adapter.changeData(survey_data);
                    order_number.setText("(3/3)");
                    each_question.setText("What kind of products do you want?");
                }
                else if(question_order==3){//if finish all 3 questions, then go to another page
                    third_cat=holder.category_item.getText().toString();
                    Intent intent=new Intent(FirstSurveyActivity.this, FinishFirstSurveyActivity.class);
                    intent.putExtra("secondchoice", second_cat);
                    intent.putExtra("thirdchoice", third_cat);
                    finish();
                    startActivity(intent);
                }
            }
        });
    }

    public void setting_new_recyclerview_data(){//for changing items of each question
        survey_data=null;
        if(question_order==1){//after first question, show second question items
            if(first_cat.equals("Livingroom")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngMiddel1)));
            }
            else if(first_cat.equals("Bedroom")||first_cat.equals("Studyroom")||first_cat.equals("Kitchen")||first_cat.equals("Walk-in closet")||first_cat.equals("For Kids")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngMiddel2)));
            }
            else if(first_cat.equals("Washroom")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngMiddel3)));
            }
        }
        else if(question_order==2){//after second question, show third question items
            if(first_cat.equals("Livingroom")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall1)));
            }
            else if(first_cat.equals("Livingroom")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall2)));
            }
            else if(first_cat.equals("Livingroom")&&second_cat.equals("For pets")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall3)));
            }
            else if(first_cat.equals("Bedroom")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall4)));
            }
            else if(first_cat.equals("Bedroom")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall5)));
            }
            else if(first_cat.equals("Bedroom")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall6)));
            }
            else if(first_cat.equals("Studyroom")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall7)));
            }
            else if(first_cat.equals("Studyroom")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall8)));
            }
            else if(first_cat.equals("Studyroom")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall9)));
            }
            else if(first_cat.equals("Kitchen")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall10)));
            }
            else if(first_cat.equals("Kitchen")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall11)));
            }
            else if(first_cat.equals("Kitchen")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall12)));
            }
            else if(first_cat.equals("Walk-in closet")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall13)));
            }
            else if(first_cat.equals("Walk-in closet")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall14)));
            }
            else if(first_cat.equals("Walk-in closet")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall15)));
            }
            else if(first_cat.equals("Washroom")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall16)));
            }
            else if(first_cat.equals("Washroom")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall17)));
            }
            else if(first_cat.equals("For Kids")&&second_cat.equals("Home Appliance")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall18)));
            }
            else if(first_cat.equals("For Kids")&&second_cat.equals("Furniture")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall19)));
            }
            else if(first_cat.equals("For Kids")&&second_cat.equals("Lighting")){
                survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngSmall20)));
            }
        }
        question_order++;
    }
}