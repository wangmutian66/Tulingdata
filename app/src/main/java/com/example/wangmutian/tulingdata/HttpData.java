package com.example.wangmutian.tulingdata;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by wangmutian on 2017/4/8.
 */

public class HttpData extends AsyncTask<String,Void,String>{

    private HttpClient mHttpClient;
    private HttpGet mHttpGet;
    private HttpResponse mHttpResponse;
    private HttpEntity mhttpentity;
    private InputStream is;
    private HttpGetDataListener listener;

    private String url;
    public HttpData(String url,HttpGetDataListener listener){
        this.url=url;
        this.listener=listener;
    }

    @Override
    protected void onPostExecute(String s) {
         listener.getDataUrl(s);

    }

    @Override
    protected String doInBackground(String... params) {


        try {
            mHttpClient=new DefaultHttpClient();
            mHttpGet=new HttpGet(url);
            mHttpResponse=mHttpClient.execute(mHttpGet);
            mhttpentity= mHttpResponse.getEntity();
            is=mhttpentity.getContent();
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line=null;
            StringBuilder sb=new StringBuilder();
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            return sb.toString();



        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }




}
