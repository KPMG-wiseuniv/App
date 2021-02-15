package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;

import static android.os.SystemClock.sleep;

public class PictureActivity extends AppCompatActivity {
    Picture_choose_Fragment choose_fragment;
    Picture_train_Fragment train_fragment;
    Uri selected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_picture);

        setting_fragment();
    }

    public void setting_fragment(){
        choose_fragment=new Picture_choose_Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.picturelayout_container, choose_fragment).commit();
            }

    public void training_image(){
        sleep(500);
        getSupportFragmentManager().beginTransaction().hide(choose_fragment).commit();
        train_fragment=new Picture_train_Fragment();
        getSupportFragmentManager().beginTransaction().add(R.id.picturelayout_container, train_fragment).commit();
    }

    public void setSelected(Uri selected) {
        this.selected = selected;
    }
}