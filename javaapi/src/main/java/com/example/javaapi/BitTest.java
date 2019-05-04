package com.example.javaapi;

import java.util.TreeSet;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 13:37 2019/5/3
 * @company:北京今汇在线
 */
public class BitTest {
    public static void main(String[] args) {
        byte[] a=new byte[100];
        byte[] bys = new byte[12500000];
//        for (int i = 0; i < 12500000; i++) {
            System.out.println(bys.length);
//        }
        TreeSet treeSet = new TreeSet();


        System.out.println(toBinary(1,8));
        System.out.println(toBinary("1").length());
        System.out.println(toBinary("1"));
     /*   char[] chs = "1".toCharArray(); //100000000
        for (int i = 0; i < chs.length; i++) { 2*2*2*2*2  32+16+1
            System.out.print(Integer.toBinaryString(chs[i]));
        }*/
    }

    public static String toBinary(String str){
        //把字符串转成字符数组
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)返回变量的二进制表示的字符串
            //toHexString(int i) 八进制
            //toOctalString(int i) 十六进制
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        return result;
    }
    /**
     * 将一个int数字转换为二进制的字符串形式。
     * @param num 需要转换的int类型数据
     * @param digits 要转换的二进制位数，位数不足则在前面补0
     * @return 二进制的字符串形式
     */
    public static String toBinary(int num, int digits) {
        int value = 1 << digits | num;
        String bs = Integer.toBinaryString(value); //0x20 | 这个是为了保证这个string长度是6位数
        return  bs.substring(1);
    }


}
