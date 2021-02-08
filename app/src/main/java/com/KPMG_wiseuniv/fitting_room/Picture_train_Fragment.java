package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Picture_train_Fragment extends Fragment {
    PictureActivity pictureActivity;
    ManageFurniture alltrain;
    Furniture nowdata;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        pictureActivity=(PictureActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        pictureActivity=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.picture_train, container, false);

        alltrain=ManageFurniture.getInstance();
        nowdata=alltrain.getFurniture();

        System.out.println(nowdata.getBig_cat());
        System.out.println(nowdata.getSec_cat());
        System.out.println(nowdata.getTh_cat());
        System.out.println(nowdata.getStyle());
        System.out.println(nowdata.getFunction());
        System.out.println(nowdata.getPrice());

        return v;
    }
}
