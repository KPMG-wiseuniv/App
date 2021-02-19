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

public class MyResult_Adapter extends RecyclerView.Adapter {
    ArrayList<Imgdata> data;
    public static Context context;
    public MyResult_Adapter(ArrayList<Imgdata> data, Context context){
        this.data=data;
        this.context=context;
    }
    static final class MyResult_ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView price;
        public MyResult_ViewHolder(@NonNull View itemView) {
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.result_item, parent, false);
        return new MyResult_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        MyResult_ViewHolder vh=(MyResult_ViewHolder)holder;
        vh.setItem(data.get(position).getImage(), Integer.toString(data.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }
}
