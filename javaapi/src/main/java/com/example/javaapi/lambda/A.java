package com.example.javaapi.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author: wuzhicheng
 * @date: 22:01 2019/6/7
 * @company:北京今汇在线
 */
public class A {
    public static void main(String[] args) {
       List lts = Arrays.asList(1,2);
       lts.forEach(System.out::println);
        A a = new A();
//        函数式编程 https://blog.csdn.net/blueheart20/article/details/80403735
//        https://blog.csdn.net/ioriogami/article/details/12782141
//        把a的getHeader方法作为参数传递进去
        String result =  RpcMediator.getInstance().acquire(a::getHeader);
        System.out.println(result);
    }

    public String getHeader(String aa){
        System.out.println("222");
        return "bb";
    }

}
