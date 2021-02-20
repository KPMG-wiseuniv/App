package com.KPMG_wiseuniv.fitting_room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShopFragment extends Fragment {
    ConditionSurveyActivity activity;
    MainActivity mainActivity;
    RecyclerView cart_recyclerview;
    TextView cart_totalprice;
    TextView payment_btn;
    Cart_Adapter cart_adapter;
    ArrayList<Cart_Item> data;
    float total;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        mainActivity=(MainActivity)getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();

        mainActivity=null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.shop_fragment, container, false);

        setting_view(v);
        setting_cart_item();
        setting_recyclerview();


        return v;
    }
    public void setting_view(View v){
        cart_recyclerview=v.findViewById(R.id.cart_recyclerview);
        cart_totalprice=v.findViewById(R.id.cart_totalprice);
        payment_btn=v.findViewById(R.id.payment_btn);

        payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(mainActivity, PaymentActivity.class);
                intent.putExtra("total", total);
                intent.putExtra("cnt", data.size());
                startActivity(intent);
            }
        });
    }

    public void setting_cart_item(){
        data=new ArrayList<>();
//        data.add(new Cart_Item("First Product", "$100", Float.parseFloat("100")));
//        data.add(new Cart_Item("Second Product", "$200", Float.parseFloat("200")));
//        data.add(new Cart_Item("Third Product", "$300", Float.parseFloat("300")));
        total=0;
        cart_totalprice.setText("$"+total);
        mainActivity.setting_cartcount(data.size());
    }
    public void setting_recyclerview(){

        cart_adapter=new Cart_Adapter(data, mainActivity);
        cart_recyclerview.setLayoutManager(new LinearLayoutManager(mainActivity));
        cart_recyclerview.setAdapter(cart_adapter);

        cart_adapter.setOnCartItemClickListener(new Cart_Adapter.OnCartItemClickListener() {
            @Override
            public void deleteItemClick(Cart_Adapter.CartViewHolder holder, View view, int position) {
                total=total-data.get(position).getPrice_num();
                cart_totalprice.setText("$"+total);
                data.remove(position);
                cart_adapter.changeData(data);
                mainActivity.setting_cartcount(data.size());
            }
        });
    }
}
