package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class History_Adapter extends RecyclerView.Adapter {
    ArrayList<Furniture> data;
    Context context;
    public History_Adapter(ArrayList<Furniture> data, Context context){
        this.data=data;
        this.context=context;
    }
    static final class History_ViewHolder extends RecyclerView.ViewHolder{
        TextView date, firstcat, style, price;
        public History_ViewHolder(@NonNull View itemView) {
            super(itemView);
            date=itemView.findViewById(R.id.history_date);
            firstcat=itemView.findViewById(R.id.history_first_cat);
            style=itemView.findViewById(R.id.history_style);
            price=itemView.findViewById(R.id.history_price);
        }

        public void setfurnitureItem(Furniture nowdata){
            date.setText(nowdata.getDate());
            firstcat.setText(nowdata.getBig_cat()+"-"+nowdata.getSec_cat()+"-"+nowdata.getTh_cat());
            style.setText(nowdata.getStyle()+"-"+nowdata.getFunction()+" Preferred");
            price.setText("Under $ "+nowdata.getPrice());
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(R.layout.history_item, parent, false);
        return new History_ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        History_ViewHolder vh=(History_ViewHolder)holder;
        vh.setfurnitureItem(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.size();
    }

    public void change_history(ArrayList<Furniture> newdata){
        if(data!=null){
            data=null;
        }
        data=newdata;
        notifyDataSetChanged();
    }
}
