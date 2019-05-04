package com.example.javaapi.sort;

import java.util.Arrays;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 15:53 2019/5/4
 * @company:北京今汇在线
 */
public class MergeSort2 {
    public static void main(String[] args) {
        int[] ats = {2,1,3,7,0};
        ats = sort(ats,0,ats.length-1);
        System.out.println("result:"+Arrays.toString(ats));
    }
    //拆分成了以2长度为单位的小数组进行排序
    private static int[] sort(int[] ats, int start, int end) {
          if(start<end){
            int middle = (start+end)/2;
            System.out.println(start+","+end+","+middle);
            sort(ats,start,middle);
            sort(ats,middle+1,end);
            merge(ats,start,middle,end);
          }

          return ats;
    }

    private static void merge(int[] ats, int start, int middle, int end) {
        System.out.println(start+",222,"+end+","+middle);
        int[] tmp = new int[end-start+1];
        int tmpIdx = 0;
        int k = start;
        int t = middle+1;
        while(k<=middle&&t<=end){
            if(ats[k]<ats[t]){
                tmp[tmpIdx] = ats[k];
                k++;
            }else{
                tmp[tmpIdx] = ats[t];
                t++;
            }
            tmpIdx++;
        }

        while (k<=middle){
            tmp[tmpIdx] = ats[k];
            tmpIdx++;
            k++;
        }

        while (t<=end){
            tmp[tmpIdx] = ats[t];
            tmpIdx++;
            t++;
        }
//        System.out.println("result1tmp111:"+Arrays.toString(tmp));
        for (int i = 0; i < tmpIdx; i++) {
            ats[start] = tmp[i];
            start++;
        }
        System.out.println("result1tmp:"+Arrays.toString(tmp));
//        System.out.println("result11:"+Arrays.toString(ats));
    }


}
