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
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private TextView mText1, mText2, mText3,mText4,mText5,mText6,mText7,mText8,mText9;
    private TextView mPrice1, mPrice2, mPrice3,mPrice4,mPrice5,mPrice6,mPrice7,mPrice8,mPrice9;
    private ImageView mImg1,mImg2,mImg3,mImg4,mImg5,mImg6,mImg7,mImg8,mImg9;
    private Button mBtn1,mBtn2,mBtn3,mBtn4,mBtn5,mBtn6,mBtn7,mBtn8,mBtn9;
    private EditText editText;
    private List<Map<String,Integer>> shopList = new ArrayList<>();
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

        mText4 = (TextView) findViewById(R.id.text4);
        mText5 = (TextView) findViewById(R.id.text5);
        mText6 = (TextView) findViewById(R.id.text6);
        mPrice4 = (TextView) findViewById(R.id.price4);
        mPrice5 = (TextView) findViewById(R.id.price5);
        mPrice6 = (TextView) findViewById(R.id.price6);
        mImg4 = (ImageView) findViewById(R.id.img4);
        mImg5 = (ImageView) findViewById(R.id.img5);
        mImg6 = (ImageView) findViewById(R.id.img6);
        mBtn4 = (Button) findViewById(R.id.btnOrder4);
        mBtn5 = (Button) findViewById(R.id.btnOrder5);
        mBtn6 = (Button) findViewById(R.id.btnOrder6);

        mText7 = (TextView) findViewById(R.id.text7);
        mText8 = (TextView) findViewById(R.id.text8);
        mText9 = (TextView) findViewById(R.id.text9);
        mPrice7 = (TextView) findViewById(R.id.price7);
        mPrice8 = (TextView) findViewById(R.id.price8);
        mPrice9 = (TextView) findViewById(R.id.price9);
        mImg7 = (ImageView) findViewById(R.id.img7);
        mImg8 = (ImageView) findViewById(R.id.img8);
        mImg9 = (ImageView) findViewById(R.id.img9);
        mBtn7 = (Button) findViewById(R.id.btnOrder7);
        mBtn8 = (Button) findViewById(R.id.btnOrder8);
        mBtn9 = (Button) findViewById(R.id.btnOrder9);

        editText = (EditText) findViewById(R.id.text);
    }

    public void m0nClick(View v) {
        init();
        switch (v.getId()) {
            case R.id.btnCoffee:
                Map<String, Integer> coffee = readLine(R.id.btnCoffee);
                Log.d("test", coffee.toString());
                Iterator<String> itrC = coffee.keySet().iterator();
                String keyC = itrC.next();
                mText1.setText(keyC);
                mPrice1.setText(coffee.get(keyC).toString());
                setImage(mImg1,keyC);
                mBtn1.setVisibility(View.VISIBLE);

                keyC = itrC.next();
                mText2.setText(keyC);
                mPrice2.setText(coffee.get(keyC).toString());
                setImage(mImg2,keyC);
                mBtn2.setVisibility(View.VISIBLE);

                keyC = itrC.next();
                mText3.setText(keyC);
                mPrice3.setText(coffee.get(keyC).toString());
                setImage(mImg3,keyC);
                mBtn3.setVisibility(View.VISIBLE);
                break;
            case R.id.btnJuice:
                Map<String, Integer> juice = readLine(R.id.btnJuice);
                Log.d("test", juice.toString());

                Iterator<String> itrJ = juice.keySet().iterator();
                String keyJ = itrJ.next();
                mText1.setText(keyJ);
                mPrice1.setText(juice.get(keyJ).toString());
                setImage(mImg1,keyJ);
                mBtn1.setVisibility(View.VISIBLE);

                keyJ = itrJ.next();
                mText2.setText(keyJ);
                mPrice2.setText(juice.get(keyJ).toString());
                setImage(mImg2,keyJ);
                mBtn2.setVisibility(View.VISIBLE);

                keyJ = itrJ.next();
                mText3.setText(keyJ);
                mPrice3.setText(juice.get(keyJ).toString());
                setImage(mImg3,keyJ);
                mBtn3.setVisibility(View.VISIBLE);

                break;
            case R.id.btnTea:
                Map<String, Integer> tea = readLine(R.id.btnTea);
                Log.d("test", tea.toString());

                Iterator<String> itrT = tea.keySet().iterator();
                String keyT = itrT.next();
                mText1.setText(keyT);
                mPrice1.setText(tea.get(keyT).toString());
                setImage(mImg1,keyT);
                mBtn1.setVisibility(View.VISIBLE);

                keyT = itrT.next();
                mText2.setText(keyT);
                mPrice2.setText(tea.get(keyT).toString());
                setImage(mImg2,keyT);
                mBtn2.setVisibility(View.VISIBLE);

                keyT = itrT.next();
                mText3.setText(keyT);
                mPrice3.setText(tea.get(keyT).toString());
                setImage(mImg3,keyT);
                mBtn3.setVisibility(View.VISIBLE);

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

                key = iterator.next();
                mText4.setText(key);
                mPrice4.setText(allList.get(key).toString());
                setImage(mImg4,key);
                mBtn4.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText5.setText(key);
                mPrice5.setText(allList.get(key).toString());
                setImage(mImg5,key);
                mBtn5.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText6.setText(key);
                mPrice6.setText(allList.get(key).toString());
                setImage(mImg6,key);
                mBtn6.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText7.setText(key);
                mPrice7.setText(allList.get(key).toString());
                setImage(mImg7,key);
                mBtn7.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText8.setText(key);
                mPrice8.setText(allList.get(key).toString());
                setImage(mImg8,key);
                mBtn8.setVisibility(View.VISIBLE);

                key = iterator.next();
                mText9.setText(key);
                mPrice9.setText(allList.get(key).toString());
                setImage(mImg9,key);
                mBtn9.setVisibility(View.VISIBLE);
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
            System.out.println(split[0]);
            result.put(split[0],Integer.parseInt(split[1]));
            result.put(split[2],Integer.parseInt(split[3]));
            result.put(split[4],Integer.parseInt(split[5]));

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
            case R.id.btnOrder4:
                intent.putExtra("name", mText4.getText().toString());
                intent.putExtra("price",mPrice4.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder5:
                intent.putExtra("name", mText5.getText().toString());
                intent.putExtra("price",mPrice5.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder6:
                intent.putExtra("name", mText6.getText().toString());
                intent.putExtra("price",mPrice6.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder7:
                intent.putExtra("name", mText7.getText().toString());
                intent.putExtra("price",mPrice7.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder8:
                intent.putExtra("name", mText8.getText().toString());
                intent.putExtra("price",mPrice8.getText().toString());
                startActivityForResult(intent, 0);
                break;
            case R.id.btnOrder9:
                intent.putExtra("name", mText9.getText().toString());
                intent.putExtra("price",mPrice9.getText().toString());
                startActivityForResult(intent, 0);
                break;

        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_FIRST_USER) {
            String name = data.getStringExtra("name");
            int cnt = Integer.parseInt(data.getStringExtra("cnt"));
            Toast.makeText(this,name+" "+cnt+"개 담기 완료",Toast.LENGTH_SHORT).show();
            HashMap<String, Integer> shop = new HashMap<>();
            shop.put(name, cnt);
            shopList.add(shop);
        } else if (requestCode == 0 && resultCode == RESULT_OK) {
            Toast.makeText(this,"주문 완료",Toast.LENGTH_SHORT).show();
            shopList.clear();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void m0nClickSearch(View v) {
        init();
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
    public void m0nClickShop(View v) {
        init();
        if (shopList.isEmpty()) {
            Toast.makeText(this,"장바구니에 아무것도 없습니다.",Toast.LENGTH_SHORT).show();
        } else {
            Map<String, Integer> result = makeAllList();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> price = new ArrayList<>();
            ArrayList<String> cnt = new ArrayList<>();
            Intent intent = new Intent(this, SubActivity2.class);
            for (Map<String, Integer> item : shopList) {
                Set<Map.Entry<String, Integer>> entries = item.entrySet();
                Map.Entry<String, Integer> ent = entries.iterator().next();
                String itemName = ent.getKey();
                String itemCnt = ent.getValue().toString();
                String itemPrice = result.get(itemName).toString();
                name.add(itemName);
                price.add(itemPrice);
                cnt.add(itemCnt);
            }
            intent.putExtra("name", name);
            intent.putExtra("price",price);
            intent.putExtra("cnt",cnt);
            startActivityForResult(intent, 0);
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
    public void init() {
        mText1.setText(null);
        mPrice1.setText(null);
        mImg1.setImageDrawable(null);
        mBtn1.setVisibility(View.GONE);

        mText2.setText(null);
        mPrice2.setText(null);
        mImg2.setImageDrawable(null);
        mBtn2.setVisibility(View.GONE);

        mText3.setText(null);
        mPrice3.setText(null);
        mImg3.setImageDrawable(null);
        mBtn3.setVisibility(View.GONE);

        mText4.setText(null);
        mPrice4.setText(null);
        mImg4.setImageDrawable(null);
        mBtn4.setVisibility(View.GONE);

        mText5.setText(null);
        mPrice5.setText(null);
        mImg5.setImageDrawable(null);
        mBtn5.setVisibility(View.GONE);

        mText6.setText(null);
        mPrice6.setText(null);
        mImg6.setImageDrawable(null);
        mBtn6.setVisibility(View.GONE);

        mText7.setText(null);
        mPrice7.setText(null);
        mImg7.setImageDrawable(null);
        mBtn7.setVisibility(View.GONE);

        mText8.setText(null);
        mPrice8.setText(null);
        mImg8.setImageDrawable(null);
        mBtn8.setVisibility(View.GONE);

        mText9.setText(null);
        mPrice9.setText(null);
        mImg9.setImageDrawable(null);
        mBtn9.setVisibility(View.GONE);
    }
}