package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    Context historycontext;
    RecyclerView history;
    History_Adapter adapter;
    ArrayList<Furniture> furniture;
    LinearLayoutManager linearLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        setting_view();
        setting_recyclerview();
    }

    public void setting_view(){
        historycontext=this;
        history=findViewById(R.id.history_recyclerview);

    }

    public void setting_recyclerview(){
        furniture=new ArrayList<>();
        furniture=ManageFurniture.getInstance().getTotal_furniture();
        adapter=new History_Adapter(furniture, historycontext);
        linearLayoutManager=new LinearLayoutManager(historycontext);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        history.setLayoutManager(linearLayoutManager);
        history.setAdapter(adapter);
    }
}