package com.KPMG_wiseuniv.fitting_room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//first page when running application
//in Splash, getting furniture data from server

public class SplashActivity extends AppCompatActivity {
    RetrofitAPI myAPI;
    ArrayList<Imgdata> total;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        total=new ArrayList<>();
        myAPI=RetrofitClient.getApiService();

        get_Image_data();


    }

    public void get_Image_data(){
        Call<ArrayList<Imgdata>> getimgdata=myAPI.get_imgdata();//for getting furniture data from server
        getimgdata.enqueue(new Callback<ArrayList<Imgdata>>() {
            @Override
            public void onResponse(Call<ArrayList<Imgdata>> call, Response<ArrayList<Imgdata>> response) {
                if(response.isSuccessful()){//when getting furniture data from server successfully
                    for(Imgdata item: response.body()){
                        item.setImage(RetrofitClient.getBaseUrl()+item.getImage());
                        total.add(item);
                    }
                    ManageImgdata.getInstance().setTotal_imgdata(total);
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                }
                else{
                    System.out.println("get data fail");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Imgdata>> call, Throwable t) {
                System.out.println("server communication fail");
                System.out.println(t);
            }
        });
    }
}
