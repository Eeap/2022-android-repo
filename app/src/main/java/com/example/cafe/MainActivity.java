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
        /*
        * 초기에 create 될때 각종 textView, priceView, imageView,btnView 초기화
        * 추가로 검색 기능을 위한 editText 초기화
        * */
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
    /*
    * 카테고리를 눌렀을 때 불러와질 함수
    * 커피, 주스, 차, 가격별 카테고리가 존재
    *  */
    public void m0nClick(View v) {
        //카테고리 버튼 누르기 전 초기화를 해서 그 전 뷰에 있는 내용 지우기
        init();
        switch (v.getId()) {
            // 커피 버튼을 눌렀을 때 수행할 작업
            case R.id.btnCoffee:
                //커피 정보를 읽어와서 map으로 key, value 형식으로 저장
                Map<String, Integer> coffee = readLine(R.id.btnCoffee);
                Log.d("test", coffee.toString());
                Iterator<String> itrC = coffee.keySet().iterator();
                String keyC = itrC.next();
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                mText1.setText(keyC);
                mPrice1.setText(coffee.get(keyC).toString());
                setImage(mImg1,keyC);
                mBtn1.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyC = itrC.next();
                mText2.setText(keyC);
                mPrice2.setText(coffee.get(keyC).toString());
                setImage(mImg2,keyC);
                mBtn2.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyC = itrC.next();
                mText3.setText(keyC);
                mPrice3.setText(coffee.get(keyC).toString());
                setImage(mImg3,keyC);
                mBtn3.setVisibility(View.VISIBLE);
                break;
            // 주스 버튼을 눌렀을 때 수행할 작업
            case R.id.btnJuice:
                //주스 정보를 읽어와서 map으로 key, value 형식으로 저장
                Map<String, Integer> juice = readLine(R.id.btnJuice);
                Log.d("test", juice.toString());
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                Iterator<String> itrJ = juice.keySet().iterator();
                String keyJ = itrJ.next();
                mText1.setText(keyJ);
                mPrice1.setText(juice.get(keyJ).toString());
                setImage(mImg1,keyJ);
                mBtn1.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyJ = itrJ.next();
                mText2.setText(keyJ);
                mPrice2.setText(juice.get(keyJ).toString());
                setImage(mImg2,keyJ);
                mBtn2.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyJ = itrJ.next();
                mText3.setText(keyJ);
                mPrice3.setText(juice.get(keyJ).toString());
                setImage(mImg3,keyJ);
                mBtn3.setVisibility(View.VISIBLE);

                break;
            // 차 버튼을 눌렀을 때 수행할 작업
            case R.id.btnTea:
                //차 정보를 읽어와서 map으로 key, value 형식으로 저장
                Map<String, Integer> tea = readLine(R.id.btnTea);
                Log.d("test", tea.toString());
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                Iterator<String> itrT = tea.keySet().iterator();
                String keyT = itrT.next();
                mText1.setText(keyT);
                mPrice1.setText(tea.get(keyT).toString());
                setImage(mImg1,keyT);
                mBtn1.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyT = itrT.next();
                mText2.setText(keyT);
                mPrice2.setText(tea.get(keyT).toString());
                setImage(mImg2,keyT);
                mBtn2.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                keyT = itrT.next();
                mText3.setText(keyT);
                mPrice3.setText(tea.get(keyT).toString());
                setImage(mImg3,keyT);
                mBtn3.setVisibility(View.VISIBLE);
                break;
            // 가격별 버튼을 눌렀을 때 수행할 작업
            case R.id.btnPrice:
                //가격별 정보를 읽어와서 map으로 key, value 형식으로 저장
                Map<String, Integer> allList = makeAllList();
                String key;
                Log.d("test", allList.toString());
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                Iterator<String> iterator = allList.keySet().iterator();
                key = iterator.next();
                mText1.setText(key);
                mPrice1.setText(allList.get(key).toString());
                setImage(mImg1,key);
                mBtn1.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText2.setText(key);
                mPrice2.setText(allList.get(key).toString());
                setImage(mImg2,key);
                mBtn2.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText3.setText(key);
                mPrice3.setText(allList.get(key).toString());
                setImage(mImg3,key);
                mBtn3.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText4.setText(key);
                mPrice4.setText(allList.get(key).toString());
                setImage(mImg4,key);
                mBtn4.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText5.setText(key);
                mPrice5.setText(allList.get(key).toString());
                setImage(mImg5,key);
                mBtn5.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText6.setText(key);
                mPrice6.setText(allList.get(key).toString());
                setImage(mImg6,key);
                mBtn6.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText7.setText(key);
                mPrice7.setText(allList.get(key).toString());
                setImage(mImg7,key);
                mBtn7.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText8.setText(key);
                mPrice8.setText(allList.get(key).toString());
                setImage(mImg8,key);
                mBtn8.setVisibility(View.VISIBLE);
                // iterator를 이용해서 각각의 메뉴와 가격 이미지 띄우기
                key = iterator.next();
                mText9.setText(key);
                mPrice9.setText(allList.get(key).toString());
                setImage(mImg9,key);
                mBtn9.setVisibility(View.VISIBLE);
        }
    }
    /*
    * raw에 저장된 카테고리 별 메뉴를 읽어오는 함수
    * inputstream으로 정보를 읽어온다.
    * return 은 map타입으로 key value 형식으로 반환되며
    * 저장되는 데이터는 key는 menu이름 value는 가격이다.
    * */
    public Map<String, Integer> readLine(int btn) {
        Map<String, Integer> result = new HashMap<>();
        try {
            InputStream inputStream = null;
            //카테고리 별로 파일을 다르기 때문에 switch문을 써서 버튼 id로 구분
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
            //데이터를 읽어오는 부분
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
    /*
    * 각각의 메뉴에 대해 담기 버튼을 눌렀을 때 작동할 함수
    * 만약 담기 버튼을 누르면 다른 activity화면으로 넘어감
    * intent로 메뉴 이름과 가격을 함께 넘긴다.
    * */
    public void m0nClickImg(View v) {
        Intent intent = new Intent(this, SubActivity1.class);
        //버튼 번호에 따른 분리 부분
        //어떤 버튼이 눌렀는지 구분하기 위해서 넘버링으로 구분
        switch (v.getId()) {
            //1번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder1:
                intent.putExtra("name", mText1.getText().toString());
                intent.putExtra("price",mPrice1.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //2번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder2:
                intent.putExtra("name", mText2.getText().toString());
                intent.putExtra("price",mPrice2.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //3번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder3:
                intent.putExtra("name", mText3.getText().toString());
                intent.putExtra("price",mPrice3.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //4번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder4:
                intent.putExtra("name", mText4.getText().toString());
                intent.putExtra("price",mPrice4.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //5번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder5:
                intent.putExtra("name", mText5.getText().toString());
                intent.putExtra("price",mPrice5.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //6번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder6:
                intent.putExtra("name", mText6.getText().toString());
                intent.putExtra("price",mPrice6.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //7번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder7:
                intent.putExtra("name", mText7.getText().toString());
                intent.putExtra("price",mPrice7.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //8번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder8:
                intent.putExtra("name", mText8.getText().toString());
                intent.putExtra("price",mPrice8.getText().toString());
                startActivityForResult(intent, 0);
                break;
            //9번 메뉴를 눌렀을 때 작동할 부분
            case R.id.btnOrder9:
                intent.putExtra("name", mText9.getText().toString());
                intent.putExtra("price",mPrice9.getText().toString());
                startActivityForResult(intent, 0);
                break;
        }
    }
    /*
    * 액티비티가 끝나고 result를 보냈을 때 처리하는 함수
    * resultcode가 다른 경우를 구분
    * 첫번째의 경우 장바구니에 담기 기능을 했을 경우
    * 두번째의 경우엔 장바구니에 담겨져 있는걸 결제하는 경우
    * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_FIRST_USER) {
            String name = data.getStringExtra("name");
            int cnt = Integer.parseInt(data.getStringExtra("cnt"));
            Toast.makeText(this,name+" "+cnt+"개 담기 완료",Toast.LENGTH_SHORT).show();
            HashMap<String, Integer> shop = new HashMap<>();
            //장바구니에 담기위해서 별도의 map타입을 이용해서 데이터를 저장하고
            //shopList에 데이터를 추가
            shop.put(name, cnt);
            shopList.add(shop);
        } else if (requestCode == 0 && resultCode == RESULT_OK) {
            Toast.makeText(this,"주문 완료",Toast.LENGTH_SHORT).show();
            //이미 결제가 완료된 장바구니는 초기화 작업을 진행
            shopList.clear();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    /*
    * 검색 버튼을 눌렀을 때 수행할 함수
    * */
    public void m0nClickSearch(View v) {
        //전체 뷰를 초기화
        init();
        //전체 리스트를 불러옴 -> 전체 리스트에서 해당 메뉴를 찾기 위해서
        Map<String, Integer> result = makeAllList();
        String search = editText.getText().toString();
        //메뉴가 존재하는 메뉴인지 검증
        if (result.containsKey(search)) {
            //존재하는 경우 첫번째 뷰에 해당 내용을 띄워준다.
            mText1.setText(search);
            mPrice1.setText(result.get(search).toString());
            setImage(mImg1,search);
            mBtn1.setVisibility(View.VISIBLE);
        } else {
            //존재하지 않을 경우 문구를 띄워준다.
            Toast.makeText(this,search+" 메뉴는 존재하지 않습니다.",Toast.LENGTH_SHORT).show();
        }
    }
    /*
    * 장바구니 버튼을 눌렀을 때 수행할 함수
    * */
    public void m0nClickShop(View v) {
        //전체 뷰를 초기화
        init();
        //장바구니 리스트가 비워졌는 경우 문구 출력
        if (shopList.isEmpty()) {
            Toast.makeText(this,"장바구니에 아무것도 없습니다.",Toast.LENGTH_SHORT).show();
        } else {
            Map<String, Integer> result = makeAllList();
            ArrayList<String> name = new ArrayList<>();
            ArrayList<String> price = new ArrayList<>();
            ArrayList<String> cnt = new ArrayList<>();
            Intent intent = new Intent(this, SubActivity2.class);
            //장바구니에 있는 메뉴 이름과 해당 개수를 각각의 리스트에 넣고
            //전체 리스트로부터 메뉴의 가격을 가져와서 가격도 저장
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
            //intent를 이용해서 다른 액티비티에 값을 넘겨줌
            intent.putExtra("name", name);
            intent.putExtra("price",price);
            intent.putExtra("cnt",cnt);
            startActivityForResult(intent, 0);
        }
    }
    /*
    * 전체 메뉴리스트를 가져오는 함수
    * return으로 전체 메뉴가 담긴 map타입의 데이터를 넘김
    * 여기서 map타입은 정렬이 되어있는 상태로 넘어가게 된다.
    * */
    public Map<String, Integer> makeAllList() {
        HashMap<String, Integer> map = new HashMap<String,Integer>();
        // 커피 종류 데이터 불러오기
        Map<String, Integer> coffee = readLine(R.id.btnCoffee);
        for (String key: coffee.keySet()){
            map.put(key, coffee.get(key));
        }
        // 주스 종류 데이터 불러오기
        Map<String, Integer> juice = readLine(R.id.btnJuice);
        for (String key: juice.keySet()){
            map.put(key, juice.get(key));
        }
        // 차 종류 데이터 불러오기
        Map<String, Integer> tea = readLine(R.id.btnTea);
        for (String key: tea.keySet()){
            map.put(key, tea.get(key));
        }
        // 전체 리스트 정렬
        Map<String, Integer> result = sortByValue(map);
        return result;
    }
    /*
    * 데이터를 정렬하기 위한 함수
    * 리턴으로 정렬된 map타입의 데이터를 넘겨준다.
    *  */
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
    /*
    * 해당 위치의 이미지 뷰의 이미지를 지정해주기 위한 함수
    * 메뉴 이름에 따라 이미지를 지정해주는 방식
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
    * 전체 뷰를 초기화하기 위한 함수
    * */
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