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
        Log.d("sub", String.valueOf(imgId));
        textName.setText(name);
        textPrice.setText(price);
        if (imgId != -1) {
            setImage(imageView,name);
        }
    }
    public void m0nClickOrder(View v) {
        setResult(RESULT_OK);
        finish();
    }
    public void setImage(ImageView mImg, String name) {
        switch (name) {
            case "아메리카노":
                mImg.setImageResource(R.drawable.coffee);
                break;
            case "자몽허니블랙티":
                mImg.setImageResource(R.drawable.tea);
                break;
            case "오렌지주스":
                mImg.setImageResource(R.drawable.juice);
                break;
        }
    }
}