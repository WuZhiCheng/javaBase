package com.example.javaapi.sort;

/**
 * @Description: 冒泡排序
 * @author: wuzhicheng
 * @date: 15:27 2019/5/4
 * @company:北京今汇在线
 */
public class MaoPao {
    public static void main(String[] args) {
        int[] ats = {2,3,4,8,1,7,2,15,0};
        int len = ats.length;
        int swap = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(ats[j]<ats[i]){
                    swap = ats[i];
                    ats[i] = ats[j];
                    ats[j] = swap;
                }
            }
        }
        System.out.println(ats);
    }
}
