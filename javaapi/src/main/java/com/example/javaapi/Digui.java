package com.example.javaapi;

/**
 * @Description: 递归计算阶乘
 * @author: wuzhicheng
 * @date: 16:48 2019/5/27
 * @company:北京今汇在线
 */
public class Digui {

    public static int getJieCheng(int n){
        if(n==1){
            return 1;
        }
        return n*getJieCheng(n-1);
    }

    public static void main(String[] args) {
        System.out.println(getJieCheng(5));
    }
}
