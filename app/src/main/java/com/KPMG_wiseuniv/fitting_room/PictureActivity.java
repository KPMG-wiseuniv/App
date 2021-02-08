package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;

import static android.os.SystemClock.sleep;

public class PictureActivity extends AppCompatActivity {
    Picture_choose_Fragment choose_fragment;
    Picture_train_Fragment train_fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_picture);

        setting_fragment();
    }

    public void setting_fragment(){
        choose_fragment=new Picture_choose_Fragment();
        train_fragment=new Picture_train_Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.picturelayout_container, choose_fragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.picturelayout_container, train_fragment).commit();
        getSupportFragmentManager().beginTransaction().hide(train_fragment).commit();
    }

    public void training_image(){
        sleep(500);
        getSupportFragmentManager().beginTransaction().hide(choose_fragment).commit();
        getSupportFragmentManager().beginTransaction().show(train_fragment).commit();
    }
}