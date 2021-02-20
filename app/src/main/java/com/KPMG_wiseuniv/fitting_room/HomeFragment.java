package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

//fragment for home
public class HomeFragment extends Fragment {
    MainActivity mainActivity;
    ViewFlipper home_viewflipper;//this is for automatic moving of 3 images, home_img1, home_img2, home_img3
    ImageView home_img1, home_img2, home_img3;//3 images that automatic moving
    RelativeLayout start_fittingroom_btn;
    RelativeLayout fittingroom_history_btn;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mainActivity=(MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mainActivity=(MainActivity)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.home_fragment, container, false);

        setting_view(v);
        setting_viewflipper();
        setting_start_fittingroom_btn();
        setting_fittingroom_history_btn();
        return v;
    }

    public void setting_view(View v){//for inflate and basic setting
        home_viewflipper=v.findViewById(R.id.home_viewflipper);
        home_img1=v.findViewById(R.id.home_img1);
        home_img2=v.findViewById(R.id.home_img2);
        home_img3=v.findViewById(R.id.home_img3);
        start_fittingroom_btn=v.findViewById(R.id.start_fittingroom_btn);
        fittingroom_history_btn=v.findViewById(R.id.fittingroom_history_btn);
    }

    public void setting_viewflipper(){//for setting viewflipper, automatic moving 3 images
        Glide.with(mainActivity).load(R.drawable.home_img1).into(home_img1);
        Glide.with(mainActivity).load(R.drawable.home_img2).into(home_img2);
        Glide.with(mainActivity).load(R.drawable.home_img3).into(home_img3);
        home_viewflipper.setFlipInterval(3000);
        home_viewflipper.setAutoStart(true);
        home_viewflipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        home_viewflipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }

    public void setting_start_fittingroom_btn(){//start survey button
        start_fittingroom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, FirstSurveyActivity.class));
            }
        });
    }

    public void setting_fittingroom_history_btn(){//for seeing survey history
        fittingroom_history_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mainActivity, HistoryActivity.class));
            }
        });
    }
}
