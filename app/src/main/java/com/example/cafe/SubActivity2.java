package com.example.cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class SubActivity2 extends AppCompatActivity {

    private ArrayList<String> name,cnt,price;
    private TextView text1,price1,cnt1,text2,price2,cnt2,text3,price3,cnt3;
    private ImageView img1,img2,img3;
    private TextView resultView;
    private Button btn1,btn2,btn3;
    private int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);
        resultView = (TextView) findViewById(R.id.sum);
        text1 = (TextView) findViewById(R.id.text1);
        price1 = (TextView) findViewById(R.id.price1);
        cnt1 = (TextView) findViewById(R.id.cnt1);
        img1 = (ImageView) findViewById(R.id.img1);
        btn1 = (Button) findViewById(R.id.btn1);

        text2 = (TextView) findViewById(R.id.text2);
        price2 = (TextView) findViewById(R.id.price2);
        cnt2 = (TextView) findViewById(R.id.cnt2);
        img2 = (ImageView) findViewById(R.id.img2);
        btn2 = (Button) findViewById(R.id.btn2);

        text3 = (TextView) findViewById(R.id.text3);
        price3 = (TextView) findViewById(R.id.price3);
        cnt3 = (TextView) findViewById(R.id.cnt3);
        img3 = (ImageView) findViewById(R.id.img3);
        btn3 = (Button) findViewById(R.id.btn3);

        sum = 0;
        Intent intent = getIntent();
        // intent로부터 데이터를 arrayList로 받아옴.
        name = intent.getStringArrayListExtra("name");
        price = intent.getStringArrayListExtra("price");
        cnt = intent.getStringArrayListExtra("cnt");

        //arrayList를 iterator를 이용해서 하나씩 불러옴
        Iterator<String> iteratorName = name.iterator();
        String menuName = iteratorName.next();
        //arrayList를 iterator를 이용해서 하나씩 불러옴
        Iterator<String> iteratorPrice = price.iterator();
        String menuPrice = iteratorPrice.next();
        //arrayList를 iterator를 이용해서 하나씩 불러옴
        Iterator<String> iteratorCnt = cnt.iterator();
        String menuCnt = iteratorCnt.next();

        text1.setText(menuName);
        price1.setText(menuPrice);
        setImage(img1,menuName);
        cnt1.setText(menuCnt);
        btn1.setVisibility(View.VISIBLE);
        sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        // 장바구니 데이터가 한개 더있는지 확인
        if (iteratorName.hasNext()){
            //데이터가 있는 경우 추가로 더 view를 설정해줌
            menuName = iteratorName.next();
            menuPrice = iteratorPrice.next();
            menuCnt = iteratorCnt.next();

            text2.setText(menuName);
            price2.setText(menuPrice);
            setImage(img2,menuName);
            cnt2.setText(menuCnt);
            btn2.setVisibility(View.VISIBLE);
            sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        }
        // 장바구니 데이터가 한개 더있는지 확인
        if (iteratorName.hasNext()){
            //데이터가 있는 경우 추가로 더 view를 설정해줌
            menuName = iteratorName.next();
            menuPrice = iteratorPrice.next();
            menuCnt = iteratorCnt.next();

            text3.setText(menuName);
            price3.setText(menuPrice);
            setImage(img3,menuName);
            cnt3.setText(menuCnt);
            btn3.setVisibility(View.VISIBLE);
            sum += Integer.parseInt(menuPrice)*Integer.parseInt(menuCnt);
        }
        // 총 결제 금액을 띄워주는 text뷰
        resultView.setText("총 결제 할 금액  :  "+sum);

    }
    /*
    * 주문하기 버튼을 눌렀을 때 수행할 함수
    * */
    public void m0nClickOrder(View v) {
        Intent data = new Intent();
        //result code만 보내고 intent로는 아무것도 보내지 않음
        setResult(RESULT_OK,data);
        finish();
    }
    /*
     * 취소 버튼을 눌렀을 때 수행할 함수
     * */
    public void m0nClickCancel(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                sum-=(Integer.parseInt(price1.getText().toString())*Integer.parseInt(cnt1.getText().toString()));
                text1.setText(null);
                price1.setText(null);
                cnt1.setText(null);
                img1.setImageDrawable(null);
                btn1.setVisibility(View.GONE);
                break;
            case R.id.btn2:
                sum-=(Integer.parseInt(price2.getText().toString())*Integer.parseInt(cnt2.getText().toString()));
                text2.setText(null);
                price2.setText(null);
                cnt2.setText(null);
                img2.setImageDrawable(null);
                btn2.setVisibility(View.GONE);
                break;
            case R.id.btn3:
                sum-=(Integer.parseInt(price3.getText().toString())*Integer.parseInt(cnt3.getText().toString()));
                text3.setText(null);
                price3.setText(null);
                cnt3.setText(null);
                img3.setImageDrawable(null);
                btn3.setVisibility(View.GONE);
                break;
        }

        resultView.setText("총 결제 할 금액  :  "+sum);
    }

    /*
    * 이미지뷰의 이미지를 설정하기 위한 함수
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
}