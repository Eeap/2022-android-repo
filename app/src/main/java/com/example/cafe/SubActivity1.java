package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SubActivity1 extends AppCompatActivity {
    private String name,price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        TextView textName = (TextView) findViewById(R.id.text1);
        TextView textPrice = (TextView) findViewById(R.id.price1);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        Log.d("sub", name);
        textName.setText(name);
        textPrice.setText(price);

    }
}