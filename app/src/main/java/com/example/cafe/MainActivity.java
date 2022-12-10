package com.example.cafe;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView mText1, mText2, mText3;
    private TextView mPrice1, mPrice2, mPrice3;
    private ImageView mImg1,mImg2,mImg3;
    private Button mBtn1,mBtn2,mBtn3;
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
    }

    public void m0nClick(View v) {
        switch (v.getId()) {
            case R.id.btnCoffee:
                Map<String, Integer> coffee = readLine(R.id.btnCoffee);
                Log.d("test", coffee.toString());
                String key1 = coffee.keySet().iterator().next();
                Log.d("test", key1);
//                Intent intent = new Intent(this, SubActivity1.class);
//                intent.putExtra("name", key);
//                intent.putExtra("price",menu.get(key).toString());
//                startActivityForResult(intent, 0);
                mText1.setText(key1);
                mPrice1.setText(coffee.get(key1).toString());
                mImg1.setImageResource(R.drawable.coffee);
                mBtn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnJuice:
                Map<String, Integer> juice = readLine(R.id.btnJuice);
                Log.d("test", juice.toString());
                String key2 = juice.keySet().iterator().next();
                Log.d("test", key2);
//                Intent intent = new Intent(this, SubActivity1.class);
//                intent.putExtra("name", key);
//                intent.putExtra("price",menu.get(key).toString());
//                startActivityForResult(intent, 0);
                mText1.setText(key2);
                mPrice1.setText(juice.get(key2).toString());
                mImg1.setImageResource(R.drawable.juice);
                mBtn1.setVisibility(View.VISIBLE);
                break;
            case R.id.btnTea:
                Map<String, Integer> tea = readLine(R.id.btnTea);
                Log.d("test", tea.toString());
                String key3 = tea.keySet().iterator().next();
                Log.d("test", key3);
//                Intent intent = new Intent(this, SubActivity1.class);
//                intent.putExtra("name", key);
//                intent.putExtra("price",menu.get(key).toString());
//                startActivityForResult(intent, 0);
                mText1.setText(key3);
                mPrice1.setText(tea.get(key3).toString());
                mImg1.setImageResource(R.drawable.tea);
                mBtn1.setVisibility(View.VISIBLE);
                break;
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
        switch (v.getId()) {
            case R.id.btnOrder1:

                Intent intent = new Intent(this, SubActivity1.class);
                intent.putExtra("name", mText1.getText().toString());
                intent.putExtra("price",mPrice1.getText().toString());
                intent.putExtra("img", R.drawable.coffee);
                startActivityForResult(intent, 0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Toast.makeText(this,mText1.getText().toString()+"주문 완료",Toast.LENGTH_SHORT).show();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}