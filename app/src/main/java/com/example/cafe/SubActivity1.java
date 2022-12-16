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
    private TextView textName,textPrice,textCnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        textName = (TextView) findViewById(R.id.text1);
        textPrice = (TextView) findViewById(R.id.price1);
        textCnt = (TextView) findViewById(R.id.cntText);
        ImageView imageView = (ImageView) findViewById(R.id.img1);

        // intent를 가져와서 데이터를 불러옴
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        textName.setText(name);
        textPrice.setText(price);
        setImage(imageView,name);
    }
    /*
    * 담기 버튼을 눌렀을 때 수행할 함수
    * */
    public void m0nClickOrder(View v) {
        Intent data = new Intent();
        // 결과로 메뉴 이름과 개수를 어느정도 했는 지 데이터를 넘겨준다.
        data.putExtra("name", textName.getText().toString());
        data.putExtra("cnt", textCnt.getText().toString());
        setResult(RESULT_FIRST_USER,data);
        finish();
    }
    /*
    * 이미지뷰의 이미지를 지정해주기 위한 함수
    * */
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
    /*
    * 주문할 개수를 + 버튼을 눌렀을 때 작동할 함수
    * */
    public void m0nClickPlus(View v) {
        textCnt.setText(String.valueOf(Integer.parseInt(textCnt.getText().toString())+1));
    }
    /*
     * 주문할 개수를 - 버튼을 눌렀을 때 작동할 함수
     * 현재 개수가 1보다 클 때만 버튼이 작동하도록 함
     * */
    public void m0nClickMinus(View v) {
        if (Integer.parseInt(textCnt.getText().toString()) > 1) {
            textCnt.setText(String.valueOf(Integer.parseInt(textCnt.getText().toString())-1));
        }
    }
}