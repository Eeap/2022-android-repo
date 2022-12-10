package com.example.cafe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView mText1, mText2, mText3;
    private TextView mPrice1, mPrice2, mPrice3;
    private ImageView mImg1,mImg2,mImg3;
    private Button mBtn1,mBtn2,mBtn3;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText1 = (TextView) findViewById(R.id.text1);
        mText2 = (TextView) findViewById(R.id.text2);
        mText3 = (TextView) findViewById(R.id.text3);
        mPrice1 = (TextView) findViewById(R.id.price1);
        mPrice2 = (TextView) findViewById(R.id.price2);
        mPrice3 = (TextView) findViewById(R.id.price3);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mBtn1 = (Button) findViewById(R.id.btnOrder1);
        mBtn2 = (Button) findViewById(R.id.btnOrder2);
        mBtn3 = (Button) findViewById(R.id.btnOrder3);
        editText = (EditText) findViewById(R.id.text);
    }

    public void m0nClick(View v) {
        switch (v.getId()) {
            case R.id.btnCoffee:
                Map<String, Integer> coffee = readLine(R.id.btnCoffee);
                Log.d("test", coffee.toString());
                String key1 = coffee.keySet().iterator().next();
                Log.d("test", key1);
                mText1.setText(key1);
                mPrice1.setText(coffee.get(key1).toString());
                setImage(mImg1,key1);
                mBtn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnJuice:
                init();
                Map<String, Integer> juice = readLine(R.id.btnJuice);
                Log.d("test", juice.toString());
                String key2 = juice.keySet().iterator().next();
                Log.d("test", key2);
                mText1.setText(key2);
                mPrice1.setText(juice.get(key2).toString());
                setImage(mImg1,key2);
                mBtn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnTea:
                Map<String, Integer> tea = readLine(R.id.btnTea);
                Log.d("test", tea.toString());
                String key3 = tea.keySet().iterator().next();
                Log.d("test", key3);
                mText1.setText(key3);
                mPrice1.setText(tea.get(key3).toString());
                setImage(mImg1,key3);
                mBtn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnPrice:
                Map<String, Integer> allList = makeAllList();
                String key;
                Log.d("test", allList.toString());
                Iterator<String> iterator = allList.keySet().iterator();
                key = iterator.next();
                mText1.setText(key);
                mPrice1.setText(allList.get(key).toString());
                setImage(mImg1,key);
                mBtn1.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText2.setText(key);
                mPrice2.setText(allList.get(key).toString());
                setImage(mImg2,key);
                mBtn2.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText3.setText(key);
                mPrice3.setText(allList.get(key).toString());
                setImage(mImg3,key);
                mBtn3.setVisibility(View.VISIBLE);
        }
    }
    public Map<String, Integer> readLine(int btn) {
        Map<String, Integer> result = new HashMap<>();
        try {
            InputStream inputStream = null;
            switch (btn) {
                case R.id.btnCoffee:
                    inputStream = getResources().openRawResource(R.raw.coffee);
                    break;
                case R.id.btnJuice:
                    inputStream = getResources().openRawResource(R.raw.juice);
                    break;
                case R.id.btnTea:
                    inputStream = getResources().openRawResource(R.raw.tea);
                    break;
            }
            byte[] nbytes = new byte[inputStream.available()];
            inputStream.read(nbytes);
            String str = new String(nbytes);
            String[] split = str.split("\n");
            result.put(split[0],Integer.parseInt(split[1]));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void m0nClickImg(View v) {
        Intent intent = new Intent(this, SubActivity1.class);
        switch (v.getId()) {
            case R.id.btnOrder1:
                intent.putExtra("name", mText1.getText().toString());
                intent.putExtra("price",mPrice1.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder2:
                intent.putExtra("name", mText2.getText().toString());
                intent.putExtra("price",mPrice2.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder3:
                intent.putExtra("name", mText3.getText().toString());
                intent.putExtra("price",mPrice3.getText().toString());
                startActivityForResult(intent, 0);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Toast.makeText(this,data.getStringExtra("name")+"주문 완료",Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void m0nClickSearch(View v) {
        Map<String, Integer> result = makeAllList();
        String search = editText.getText().toString();
        if (result.containsKey(search)) {
            mText1.setText(search);
            mPrice1.setText(result.get(search).toString());
            setImage(mImg1,search);
            mBtn1.setVisibility(View.VISIBLE);
        } else {
            Toast.makeText(this,search+" 메뉴는 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
        }
    }
    public Map<String, Integer> makeAllList() {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        Map<String, Integer> coffee = readLine(R.id.btnCoffee);
        for (String key: coffee.keySet()){
            map.put(key, coffee.get(key));
        }
        Map<String, Integer> juice = readLine(R.id.btnJuice);
        for (String key: juice.keySet()){
            map.put(key, juice.get(key));
        }
        Map<String, Integer> tea = readLine(R.id.btnTea);
        for (String key: tea.keySet()){
            map.put(key, tea.get(key));
        }
        Map<String, Integer> result = sortByValue(map);
        return result;
    }
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm){
        List<Map.Entry<String, Integer> > list =
                new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2){
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
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