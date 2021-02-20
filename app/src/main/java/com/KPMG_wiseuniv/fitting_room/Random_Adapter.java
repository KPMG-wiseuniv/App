package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

//if there's no result suits for survey, AI result, showing just by furniture category user chose
//Recyclerview Adapter contains list of furniture category user chose

public class Random_Adapter extends RecyclerView.Adapter {
    ArrayList<Imgdata> data;
    public static Context context;
    public Random_Adapter(ArrayList<Imgdata> data, Context context){
        this.data=data;
        this.context=context;
    }
    static final class Random_ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView price;
        public Random_ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.result_img);
            price=itemView.findViewById(R.id.result_price);
        }
        public void setItem(String dimg, String dprice){
            Glide.with(context).load(dimg).into(img);
            price.setText("$"+dprice);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//viewholder for Random_Adapter
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.result_item, parent, false);
        return new Random_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Random_ViewHolder vh=(Random_ViewHolder)holder;
        vh.setItem(data.get(position).getImage(), Integer.toString(data.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
}
