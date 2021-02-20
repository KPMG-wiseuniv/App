package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstSurvey_Adapter extends RecyclerView.Adapter {
    public static ArrayList<String> data;
    Context context;
    OnItemClickListener listener;
    public static List<String> cat= Arrays.asList("Studyroom", "Furniture", "Chair", "Table");//activating posible category
    public interface OnItemClickListener{//interface for each item click listener
        void OnItemClick(FirstSurvey_ViewHolder holder, View view, int position, String cat);
    }
    public FirstSurvey_Adapter(ArrayList<String> data, Context context){
        this.data=data;
        this.context=context;
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener=listener;
    }

    static final class FirstSurvey_ViewHolder extends RecyclerView.ViewHolder{//viewholder for firstsurvey_adapter
        LinearLayout category_layout;
        TextView category_item;

        OnItemClickListener  listener;

        public FirstSurvey_ViewHolder(@NonNull View itemView) {
            super(itemView);
            category_layout=itemView.findViewById(R.id.each_item_layout);
            category_item=itemView.findViewById(R.id.each_item);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();

                    if(listener!=null){
                        listener.OnItemClick(FirstSurvey_ViewHolder.this, v, position, data.get(position));
                    }
                }
            });
        }
        public void setItem(String item){
            category_item.setText(item);
            int flag=0;
            for(int i=0; i<cat.size(); i++){
                System.out.println(cat.get(i));
                if(cat.get(i).equals(item)){
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                category_item.setTextColor(Color.LTGRAY);
            }else if(flag==1){
                category_item.setTextColor(Color.parseColor("#5E35B1"));
            }
        }

        public void setOnItemClickListener(OnItemClickListener listener){
            this.listener=listener;
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.first_survey_item, parent, false);
        return new FirstSurvey_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FirstSurvey_ViewHolder vh=(FirstSurvey_ViewHolder)holder;
        vh.setItem(data.get(position));

        vh.setOnItemClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
    public void changeData(ArrayList<String> newdata){//for change recyclerview items
        if(data!=null){
            data=null;
        }
        data=newdata;
        notifyDataSetChanged();
    }
}
