package com.example.wangmutian.tulingdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements HttpGetDataListener {

    private HttpData mhttpdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhttpdata= (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=a3cc529092a54ad0bf108285509d89c3&info=%E4%BD%A0%E5%8F%AB%E4%BB%80%E4%B9%88",this).execute();
    }

    @Override
    public void getDataUrl(String data) {
        System.out.println("++++++++++++++");
        System.out.println(data);
        System.out.println("++++++++++++++");

    }
}
