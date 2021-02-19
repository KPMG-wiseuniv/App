package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    LinearLayout aimy_layout, random_layout;
    TextView result_message, random_result_message, result_detail_message;
    RecyclerView airesult_recyclerview, myresult_recyclerview, random_recyclerview;
    int dAIinterior, AIcolor, AIFD, nowchoice;
    Furniture now_furniture;
    ArrayList<Imgdata> ai, my, random;
    String mybig, mymiddle, myfurniture, mystyle, myfd;
    int myprice;
    String AIinterior, AIdetail;

    AIResult_Adapter aiadapter;
    MyResult_Adapter myadapter;
    Random_Adapter randomadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        setting_view();
        furniture_filtering();
        setting_recyclerview();
    }

    public void setting_view(){
        aimy_layout=findViewById(R.id.aimy_layout);
        random_layout=findViewById(R.id.random_layout);
        result_message=findViewById(R.id.result_message);
        result_detail_message=findViewById(R.id.result_detail_message);
        random_result_message=findViewById(R.id.random_result_message);
        airesult_recyclerview=findViewById(R.id.ai_result_recyclerview);
        myresult_recyclerview=findViewById(R.id.my_result_recyclerview);
        random_recyclerview=findViewById(R.id.random_result_recyclerview);

        Intent intent=getIntent();
        dAIinterior=intent.getIntExtra("AIinterior", 0);
        if(dAIinterior==0){
            AIinterior="Modern";
        }else if(dAIinterior==1){
            AIinterior="Natural";
        }
        AIcolor=intent.getIntExtra("AIcolor", 0);
        AIFD=intent.getIntExtra("AIFD", 0);
        nowchoice=intent.getIntExtra("nowchoice", 0);
        now_furniture=ManageFurniture.getInstance().getTotal_furniture().get(nowchoice);

        ai=new ArrayList<>();
        my=new ArrayList<>();
        random=new ArrayList<>();
    }

    public void furniture_filtering(){
        mybig=now_furniture.getBig_cat();
        mymiddle=now_furniture.getSec_cat();
        myfurniture=now_furniture.getTh_cat();
        mystyle=now_furniture.getStyle();
        myfd=now_furniture.getFunction();
        if (now_furniture.getPrice().equals("700+")) {
            myprice=700;
        }else{
            myprice=Integer.parseInt(now_furniture.getPrice());
        }
        System.out.println(mybig+" "+mymiddle+" "+myfurniture+" "+mystyle+" "+myfd+" "+myprice);
        if(myfurniture.equals("Chair")){
            if(myfd.equals("Design")){
                if(AIFD==1){
                    AIdetail="bar chair";
                }else if(AIFD==2){
                    AIdetail="cafe chair";
                }
            }else if(myfd.equals("Function")){
                if(AIFD==1){
                    AIdetail="desk chair";
                }else if(AIFD==2){
                    AIdetail="armchair";
                }else if(AIFD==3){
                    AIdetail="stem stool";
                }
            }
        }
        else if(myfurniture.equals("Table")){
            if(myfd.equals("Design")){
                if(AIFD==1){
                    AIdetail="bar table";
                }else if(AIFD==2){
                    AIdetail="cafe table";
                }
            }else if(myfd.equals("Function")){
                if(AIFD==1){
                    AIdetail="console table";
                }else if(AIFD==2){
                    AIdetail="beside table";
                }
            }
        }

        for(int i=0; i<ManageImgdata.getInstance().getTotal_imgdata().size(); i++){
            Imgdata now=ManageImgdata.getInstance().getTotal_imgdata().get(i);
            if(now.getBigcategory().equals(mybig)&&now.getMiddlecategory().equals(mymiddle)
                    &&now.getFurniturename().equals(myfurniture)){
                if(myprice==700){
                    if(now.getStyle().equals(mystyle)&&now.getSelectfd().equals(myfd)){
                        my.add(now);
                    }
                }else{
                    if(myprice>=now.getPrice()){
                        if(now.getStyle().equals(mystyle)&&now.getSelectfd().equals(myfd)){
                            my.add(now);
                        }
                    }
                }
                if(now.getColor()==AIcolor&&now.getStyle().equals(AIinterior)&&now.getDetail().equals(AIdetail)){
                    ai.add(now);
                }
            }
        }
        if(ai.size()==0){
            for(int i=0; i<ManageImgdata.getInstance().getTotal_imgdata().size(); i++){
                Imgdata now=ManageImgdata.getInstance().getTotal_imgdata().get(i);
                if(now.getFurniturename().equals(myfurniture)){
                    if(now.getColor()==AIcolor&&now.getStyle().equals(AIinterior)){
                        ai.add(now);
                    }
                }
            }
        }
        result_message.setText("We found "+(ai.size()+my.size())+" fitting products\nfor you!");
        if(ai.size()+my.size()==0){
            for(int i=0; i<ManageImgdata.getInstance().getTotal_imgdata().size(); i++){
                Imgdata now=ManageImgdata.getInstance().getTotal_imgdata().get(i);
                if(now.getBigcategory().equals(mybig)&&now.getMiddlecategory().equals(mymiddle)
                &&now.getFurniturename().equals(myfurniture)){
                    random.add(now);
                }
            }
        }
    }

    public void setting_recyclerview(){
        if(ai.size()+my.size()!=0){
            LinearLayoutManager ailayoutmanager=new GridLayoutManager(this, 2);
            LinearLayoutManager mylayoutmanager=new GridLayoutManager(this, 2);
            aiadapter=new AIResult_Adapter(ai, this);
            myadapter=new MyResult_Adapter(my, this);
            airesult_recyclerview.setLayoutManager(ailayoutmanager);
            myresult_recyclerview.setLayoutManager(mylayoutmanager);
            airesult_recyclerview.setAdapter(aiadapter);
            myresult_recyclerview.setAdapter(myadapter);
            String color=null;
            if(AIcolor==0){
                color="black";
            }else if(AIcolor==1){
                color="white";
            }else if(AIcolor==2){
                color="gray";
            }else if(AIcolor==3){
                color="beige";
            }else if(AIcolor==4){
                color="brown";
            }else if(AIcolor==5){
                color="light brown";
            }
            result_detail_message.setText("AI result: "+myfurniture+" that\n"+color+" and "+AIinterior+","+AIdetail+"\nfits on your Room!");
            aimy_layout.setVisibility(View.VISIBLE);
            random_layout.setVisibility(View.GONE);
        }
        else{
            LinearLayoutManager randomlayoutmanager=new GridLayoutManager(this, 2);
            randomadapter=new Random_Adapter(random, this);
            random_recyclerview.setLayoutManager(randomlayoutmanager);
            random_recyclerview.setAdapter(randomadapter);
            String color=null;
            if(AIcolor==0){
                color="black";
            }else if(AIcolor==1){
                color="white";
            }else if(AIcolor==2){
                color="gray";
            }else if(AIcolor==3){
                color="beige";
            }else if(AIcolor==4){
                color="brown";
            }else if(AIcolor==5){
                color="light brown";
            }
            random_result_message.setText("Sorry, we don't have products for you\nBut AI result: "+myfurniture+" that\n"+color+" and "+AIinterior+","+AIdetail+"\nfits on your Room!");
            aimy_layout.setVisibility(View.GONE);
            random_layout.setVisibility(View.VISIBLE);
        }
    }
}