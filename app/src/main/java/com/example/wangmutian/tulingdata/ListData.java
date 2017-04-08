package com.example.wangmutian.tulingdata;

/**
 * Created by wangmutian on 2017/4/8.
 */

public class ListData {

    private String content;
    public ListData(String content){
        //this.content=content;
        setContent(content);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
