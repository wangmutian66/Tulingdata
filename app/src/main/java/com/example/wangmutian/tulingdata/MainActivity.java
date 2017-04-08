package com.example.wangmutian.tulingdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpGetDataListener {

    private HttpData mhttpdata;
    private List<ListData> lists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhttpdata= (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=a3cc529092a54ad0bf108285509d89c3&info=%E4%BD%A0%E5%8F%AB%E4%BB%80%E4%B9%88",this).execute();
    }

    private void initView(){
        lists=new ArrayList<ListData>();
    }


    @Override
    public void getDataUrl(String data) {

        //System.out.println(data);
        parseText(data);

    }

    public void parseText(String data){

        try {
            JSONObject jb=new JSONObject(data);
            lists.add(new ListData(jb.getString("text")));


//            System.out.println("=====================");
//            System.out.println(jb.getString("code"));
//            System.out.println(jb.getString("text"));
            //System.out.println(jb.getString("text"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
