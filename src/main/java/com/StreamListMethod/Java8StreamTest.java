package com.StreamListMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamTest {

    /**
     * 有一个集合：
     *
     * List<User> users = getList(); //从数据库查询的用户集合
     *
     * 现在想获取User的身份证号码；在后续的逻辑处理中要用；
     *
     * 常用的方法我们大家都知道，用for循环，
     *
     * List<String> idcards=new ArrayList<String>();//定义一个集合来装身份证号码
     *
     * for(int i=0;i<users.size();i++){
     *
     * 　　idcards.add(users.get(i).getIdcard());
     *
     * }
     *
     * 这种方法要写好几行代码，有没有简单点的，有，java8 API能一行搞定：
     *
     * List<String> idcards= users.stream().map(User::getIdcard).collect(Collectors.toList())
     *
     * 解释下一这行代码：
     *
     * users：一个实体类的集合，类型为List<User>
     * User：实体类
     * getIdcard：实体类中的get方法，为获取User的idcard
     *
     *
     *
     *
     * stream()优点
     *
     * 无存储。stream不是一种数据结构，它只是某种数据源的一个视图，数据源可以是一个数组，Java容器或I/O channel等。
     * 为函数式编程而生。对stream的任何修改都不会修改背后的数据源，比如对stream执行过滤操作并不会删除被过滤的元素，而是会产生一个不包含被过滤元素的新stream。
     * 惰式执行。stream上的操作并不会立即执行，只有等到用户真正需要结果的时候才会执行。
     * 可消费性。stream只能被“消费”一次，一旦遍历过就会失效，就像容器的迭代器那样，想要再次遍历必须重新生成。
     * stream().map()方法的使用示例:
     */


    public static void main(String args []){


        List<String> list= Arrays.asList("a", "b", "c", "d");

        List<String> collect =list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(collect); //[A, B, C, D]

        //map 数组所有元素，按某种规律计算：
        List<Integer> num = Arrays.asList(1,2,3,4,5);
        List<Integer> collect1 = num.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println(collect1); //[2, 4, 6, 8, 10]
        //map map算是最常用的一种操作了，遍历原stream中的元素，转换后构成新的stream：
        List<String> stringList = Arrays.asList("abc","cde","def","erw");
        List<String> stringList1 = stringList.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(stringList1);
        //filter 根据某个条件筛选数据流
        List<String> strings = Arrays.asList("abcsdsad","cde","fdsdasdas","sda","sadsadsa","s");
        long counts = strings.parallelStream().filter(x->x.length()<5).count();
        long counts1 = strings.parallelStream().filter(x->x.startsWith("a")).count();
        System.out.println(counts);
        System.out.println(counts1);
        //distinct操作 去重
        List<String> stringDistinct = Arrays.asList("abcsdsad","cde","abcsdsad","sda","sadsadsa","s","cde");
        Stream<String> sortedDistinct =  stringDistinct.stream().distinct().sorted(Comparator.comparing(String::length));
        sortedDistinct.forEach(x-> System.out.print(x + " "));










    }
}
