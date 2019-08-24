package com.example.javaapi.stream;


import java.util.*;
import java.util.stream.Collectors;
/**
 * All rights Reserved, Designed By a.96bill.com
 *
 * @version V1.0
 * @Title: *.java
 * @Package com
 * @Description: jdk1.8 stream 统计商户出发风控次数使用实例
 * stream介绍：  https://blog.csdn.net/piglite/article/details/53823584
 * @author: wuzhicheng
 * @date: 21:42 2018/9/6/006
 * @company:北京今汇在线
 */
public class StreamTest {


    public static void main(String[] args) {
        List<Transaction> transactions = new ArrayList<>();
        Transaction t2 = new Transaction();
        t2.setTime("20180909");
        t2.setNum(3);

        Transaction t1 = new Transaction();
        t1.setTime("20180910");
        t1.setNum(10);

        Transaction t11 = new Transaction();
        t11.setTime("20190910");
        t11.setNum(5);

        Transaction t111 = new Transaction();
        t111.setTime("20290910");
        t111.setNum(25);

        Transaction tt = new Transaction();
        tt.setTime("20090910");
        tt.setNum(3);

        Transaction ttt = new Transaction();
        ttt.setTime("20090910");
        ttt.setNum(3);

        transactions.add(ttt);
        transactions.add(t2);
        transactions.add(t111);
        transactions.add(t1);
        transactions.add(tt);
        transactions.add(t11);

        
        List<Transaction> tra2 = new ArrayList<>();
        transactions.parallelStream().filter(t->t.getTime().startsWith("2018")).forEach(tra->tra2.add(tra));
        System.out.println(tra2);
        Map<String,Integer> numMap = new HashMap<>();

        // 得到map之后循环map，设置月份数量也是可以的
        // lis分组 参考 https://blog.csdn.net/wangmuming/article/details/72743790
        Map m = transactions.parallelStream().collect(Collectors.groupingBy(x->x.getTime().substring(0,6)));

       Map<String,Integer> pp = transactions.parallelStream().
               collect(Collectors.groupingBy(x->x.getTime().substring(0,6),Collectors.summingInt(Transaction::getNum)));
        System.out.println("pp::"+pp);
        Map<String,Integer> finalMap = new HashMap<>();

        // map 排序 参考 https://www.cnblogs.com/woyaobianfei/p/9187127.html      pp.keySet().parallelStream() 不能用于排序 会出问题

        pp.keySet().stream().sorted().forEach(x->{
            finalMap.put(x,pp.get(x));
            System.out.println("x:::"+x);
        });
        // 倒序
       List<Transaction> list =  pp.entrySet().parallelStream()
               .map(map->new Transaction(map.getKey(),map.getValue())).collect(Collectors.toList());
       //  正叙
         List<Transaction> list2 =  pp.entrySet().parallelStream()
                       .map(map->new Transaction(map.getKey(),map.getValue())).sorted(Comparator.comparing(tra->tra.getTime())).collect(Collectors.toList());
//        List<Transaction> list3 =  pp.entrySet().parallelStream()
//                .map(map->new Transaction(map.getKey(),map.getValue())).sorted().collect(Collectors.toList());
        System.out.println("list:::"+list);
        System.out.println("list2:::"+list2);
//        System.out.println("list3:::"+list3);
        //Comparator.reverseOrder()
        System.out.println("finalMap::"+finalMap);
//        System.out.println("ppp::::"+pp);

//        transactions.parallelStream().map(Collectors.groupingBy());
//        transactions.parallelStream().collect(Collectors.groupingBy(x->x.getTime().substring(0,6)));



//       List<Integer> transactionsIds = transactions.parallelStream().
//                filter(t -> t.getId() == 1).
//                sorted(comparing(Transaction::getValue).reversed()).
//                map(Transaction::getId).
//                collect(toList());
////        https://www.cnblogs.com/andywithu/p/7404101.html
    }
}
