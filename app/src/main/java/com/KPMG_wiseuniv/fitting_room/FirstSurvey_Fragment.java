package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSurvey_Fragment extends Fragment {
    FirstSurveyActivity firstactivity;
    TextView order_number, each_question;
    RecyclerView firstsurvey_recyclerview;//for survey
    int question_order;//order of question
    String first_cat, second_cat, third_cat;//for three result of each three category
    ArrayList<String> survey_data;//items for survey
    FirstSurvey_Adapter survey_adapter;//adapter for firstsurvey_recyclerview
    public static List<String> cat_enable= Arrays.asList("Studyroom", "Furniture", "Chair", "Table");
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        firstactivity=(FirstSurveyActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        firstactivity=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.firstsurvey_fragment, container, false);

        setting_view(v);
        setting_survey_recyclerview();

        return v;
    }
    public void setting_view(View v){//for inflation and basic setting
        order_number=v.findViewById(R.id.order_number);
        each_question=v.findViewById(R.id.each_question);
        firstsurvey_recyclerview=v.findViewById(R.id.firstsurvey_recyclerview);

        question_order=1;
        order_number.setText("(1/3)");
        each_question.setText("Which residential space\ndo you want to style?");
        first_cat=null;second_cat=null;third_cat=null;

        survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngBig)));
    }
    public void setting_survey_recyclerview(){//for setting survey
        survey_adapter=new FirstSurvey_Adapter(survey_data, firstactivity);
        firstsurvey_recyclerview.setLayoutManager(new LinearLayoutManager(firstactivity));
        firstsurvey_recyclerview.setAdapter(survey_adapter);

        survey_adapter.setOnItemClickListener(new FirstSurvey_Adapter.OnItemClickListener() {
            @Override
            public void OnItemClick(FirstSurvey_Adapter.FirstSurvey_ViewHolder holder, View view, int position, String cat) {//if user select one, then go to next question
                int flag=0;
                for(int i=0; i<cat_enable.size(); i++){
                    if(cat_enable.get(i).equals(cat)){
                        flag=1;
                        break;
                    }
                }
                if(flag==0){
                    Toast.makeText(firstactivity, "Will be updated", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(question_order==1){
                    first_cat=holder.category_item.getText().toString();
                    ManageFurniture.getInstance().getFurniture().setBig_cat(first_cat);
                    ManageFurniture.getInstance().setBig_cat(first_cat);
                    setting_new_recyclerview_data();
                    survey_adapter.changeData(survey_data);
                    order_number.setText("(2/3)");
                    each_question.setText("Which category of products do you want?");
                }
                else if(question_order==2){
                    second_cat=holder.category_item.getText().toString();
                    ManageFurniture.getInstance().getFurniture().setSec_cat(second_cat);
                    ManageFurniture.getInstance().setSec_cat(second_cat);
                    setting_new_recyclerview_data();
                    survey_adapter.changeData(survey_data);
                    order_number.setText("(3/3)");
                    each_question.setText("What kind of products do you want?");
                }
                else if(question_order==3){//if finish all 3 questions, then go to another page
                    third_cat=holder.category_item.getText().toString();
                    ManageFurniture.getInstance().getFurniture().setTh_cat(third_cat);
                    ManageFurniture.getInstance().setTh_cat(third_cat);
                    firstactivity.setSecond_cat(second_cat);
                    firstactivity.setThird_cat(third_cat);
                    firstactivity.finish_firstsurvey();
                    System.out.println(second_cat);
                    System.out.println(third_cat);
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

    public void setting_again(){
        question_order=1;
        order_number.setText("(1/3)");
        each_question.setText("Which residential space\ndo you want to style?");
        first_cat=null;second_cat=null;third_cat=null;

        survey_data=null;
        survey_data=new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.EngBig)));
        survey_adapter.changeData(survey_data);
    }
}
