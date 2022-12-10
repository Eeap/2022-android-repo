package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SubActivity1 extends AppCompatActivity {
    private String name,price;
    private int imgId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        TextView textName = (TextView) findViewById(R.id.text1);
        TextView textPrice = (TextView) findViewById(R.id.price1);
        ImageView imageView = (ImageView) findViewById(R.id.img1);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        imgId = intent.getIntExtra("img",-1);
        Log.d("sub", String.valueOf(imgId));
        textName.setText(name);
        textPrice.setText(price);
        if (imgId != -1) {
            imageView.setImageResource(imgId);
        }
    }
    public void m0nClickOrder(View v) {
        setResult(RESULT_OK);
        finish();
    }
}