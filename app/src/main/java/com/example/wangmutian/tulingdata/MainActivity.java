package com.example.wangmutian.tulingdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HttpGetDataListener {

    private HttpData mhttpdata;
    private List<ListData> lists;
    private Button bt1;
    private EditText et1;
    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= (Button) findViewById(R.id.bt1);
        et1= (EditText) findViewById(R.id.et1);
        tv1= (TextView) findViewById(R.id.tv);
        bt1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                String str1=et1.getText().toString();
                //System.out.println(str1);
                mhttpdata= (HttpData) new HttpData("http://www.tuling123.com/openapi/api?key=a3cc529092a54ad0bf108285509d89c3&info="+str1+"",MainActivity.this).execute();
            }
        });
        initView();
    }

    private void initView(){
        lists=new ArrayList<ListData>();

    }


    @Override
    public void getDataUrl(String data) {

        //System.out.println(data);

        parseText(data);

    }
    //你是谁？
    public void parseText(String data){

        try {
            JSONObject jb=new JSONObject(data);
            lists.add(new ListData(jb.getString("text")));

            tv1.setText(jb.getString("text"));
//            System.out.println("=====================");
//            System.out.println(jb.getString("code"));
//            System.out.println(jb.getString("text"));
            //System.out.println(jb.getString("text"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
