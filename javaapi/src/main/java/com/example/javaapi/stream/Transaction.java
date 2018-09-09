package com.example.javaapi.stream;

import com.alibaba.fastjson.JSON;

/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 21:44 2018/9/6/006
 * @company:北京今汇在线
 */
public class Transaction {
    private Integer id;
    private String time;
    private int num;

    public Transaction() {}

    public Transaction(String time, int num) {
        this.time = time;
        this.num = num;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
      return  JSON.toJSONString(this);
    }
}
