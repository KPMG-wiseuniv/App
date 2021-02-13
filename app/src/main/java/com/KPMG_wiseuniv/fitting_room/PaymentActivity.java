package com.KPMG_wiseuniv.fitting_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PaymentActivity extends AppCompatActivity {
    TextView item_charge, total_payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        setting_view();
    }

    public void setting_view(){
        item_charge=findViewById(R.id.item_charge);
        total_payment=findViewById(R.id.total_payment);

        Intent intent=getIntent();
        item_charge.setText(Float.toString(intent.getIntExtra("cnt", 0)));
        total_payment.setText(Float.toString(intent.getFloatExtra("total", 0)));
    }
}