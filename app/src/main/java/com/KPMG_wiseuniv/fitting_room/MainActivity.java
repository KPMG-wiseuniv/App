package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

//this is main page that appear right after Splash

public class MainActivity extends AppCompatActivity {
    HomeFragment homeFragment;//for home
    ShopFragment shopFragment;//for cart
    LinearLayout home_tab_layout;
    RelativeLayout shop_tab_layout;
    ImageView home_tab, shop_tab;
    LinearLayout cart_countlayout;
    TextView cart_counttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setting_view();
        setting_fragment();
        setting_clicklistener();
    }
    public void setting_view(){//for inflate and basic setting
        home_tab_layout=findViewById(R.id.home_tab_layout);
        shop_tab_layout=findViewById(R.id.shop_tab_layout);
        home_tab=findViewById(R.id.home_tab);
        shop_tab=findViewById(R.id.shop_tab);
        cart_countlayout=findViewById(R.id.cart_countlayout);
        cart_counttext=findViewById(R.id.cart_counttext);

        Glide.with(this).load(R.drawable.home_on).into(home_tab);
        Glide.with(this).load(R.drawable.cart_off).into(shop_tab);

        ManageFurniture.getInstance();
    }

    public void setting_fragment(){//setting fragment
        homeFragment=new HomeFragment();
        shopFragment=new ShopFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, shopFragment).commit();
        getSupportFragmentManager().beginTransaction().hide(shopFragment).commit();
    }

    public void setting_clicklistener(){
        home_tab_layout.setOnClickListener(new View.OnClickListener() {//for showing home page
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(homeFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(shopFragment).commit();
                Glide.with(getApplicationContext()).load(R.drawable.home_on).into(home_tab);
                Glide.with(getApplicationContext()).load(R.drawable.cart_off).into(shop_tab);
            }
        });
        shop_tab_layout.setOnClickListener(new View.OnClickListener() {//for showing cart page
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().show(shopFragment).commit();
                getSupportFragmentManager().beginTransaction().hide(homeFragment).commit();
                Glide.with(getApplicationContext()).load(R.drawable.home_off).into(home_tab);
                Glide.with(getApplicationContext()).load(R.drawable.cart_on).into(shop_tab);
            }
        });
    }

    public void setting_cartcount(int number){
        if(number==0){
            cart_countlayout.setVisibility(View.GONE);
        }
        else{
            cart_countlayout.setVisibility(View.VISIBLE);
            cart_counttext.setText(Integer.toString(number));
        }
    }

}