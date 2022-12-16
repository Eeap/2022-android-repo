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
    private TextView textName,textPrice,textCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        textName = (TextView) findViewById(R.id.text1);
        textPrice = (TextView) findViewById(R.id.price1);
        textCnt = (TextView) findViewById(R.id.cntText);
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
        Intent data = new Intent();
        data.putExtra("name", textName.getText().toString());
        data.putExtra("cnt", textCnt.getText().toString());
        setResult(RESULT_FIRST_USER,data);
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
            case "카페라떼":
                mImg.setImageResource(R.drawable.latte);
                break;
            case "카푸치노":
                mImg.setImageResource(R.drawable.cappucino);
                break;
            case "캐모마일":
                mImg.setImageResource(R.drawable.chamomile);
                break;
            case "녹차":
                mImg.setImageResource(R.drawable.green);
                break;
            case "딸기주스":
                mImg.setImageResource(R.drawable.strawberry);
                break;
            case "망고주스":
                mImg.setImageResource(R.drawable.mango);
                break;
        }
    }
    public void m0nClickPlus(View v) {
        textCnt.setText(String.valueOf(Integer.parseInt(textCnt.getText().toString())+1));
    }
    public void m0nClickMinus(View v) {
        if (Integer.parseInt(textCnt.getText().toString()) > 1) {
            textCnt.setText(String.valueOf(Integer.parseInt(textCnt.getText().toString())-1));
        }
    }
}