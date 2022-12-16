package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class SubActivity2 extends AppCompatActivity {

    private ArrayList<String> name,cnt,price;
    private TextView text1,price1,cnt1,text2,price2,cnt2,text3,price3,cnt3;
    private ImageView img1,img2,img3;
    private TextView resultView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        resultView = (TextView) findViewById(R.id.sum);
        text1 = (TextView) findViewById(R.id.text1);
        price1 = (TextView) findViewById(R.id.price1);
        cnt1 = (TextView) findViewById(R.id.cnt1);
        img1 = (ImageView) findViewById(R.id.img1);

        text2 = (TextView) findViewById(R.id.text2);
        price2 = (TextView) findViewById(R.id.price2);
        cnt2 = (TextView) findViewById(R.id.cnt2);
        img2 = (ImageView) findViewById(R.id.img2);

        text3 = (TextView) findViewById(R.id.text3);
        price3 = (TextView) findViewById(R.id.price3);
        cnt3 = (TextView) findViewById(R.id.cnt3);
        img3 = (ImageView) findViewById(R.id.img3);

        int sum = 0;
        Intent intent = getIntent();
        name = intent.getStringArrayListExtra("name");
        price = intent.getStringArrayListExtra("price");
        cnt = intent.getStringArrayListExtra("cnt");

        Iterator<String> iteratorName = name.iterator();
        String menuName = iteratorName.next();

        Iterator<String> iteratorPrice = price.iterator();
        String menuPrice = iteratorPrice.next();

        Iterator<String> iteratorCnt = cnt.iterator();
        String menuCnt = iteratorCnt.next();

        text1.setText(menuName);
        price1.setText(menuPrice);
        setImage(img1,menuName);
        cnt1.setText(menuCnt);
        sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        if (iteratorName.hasNext()){
            menuName = iteratorName.next();
            menuPrice = iteratorPrice.next();
            menuCnt = iteratorCnt.next();

            text2.setText(menuName);
            price2.setText(menuPrice);
            setImage(img2,menuName);
            cnt2.setText(menuCnt);
            sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        }
        if (iteratorName.hasNext()){
            menuName = iteratorName.next();
            menuPrice = iteratorPrice.next();
            menuCnt = iteratorCnt.next();

            text3.setText(menuName);
            price3.setText(menuPrice);
            setImage(img3,menuName);
            cnt3.setText(menuCnt);
            sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        }
        resultView.setText("총 결제 할 금액  :  "+sum);

    }
    public void m0nClickOrder(View v) {
        Intent data = new Intent();
        setResult(RESULT_OK,data);
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
}