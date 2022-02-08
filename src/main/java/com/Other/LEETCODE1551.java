package com.Other;

public class LEETCODE1551 {

    /**
     *最少操作次数是前若干个偶数或者奇数的和——取决于n的奇偶性。本质是“等差数列的”中间项.
     *https://blog.csdn.net/bluebiy/article/details/118580083
     *
     * @param args
     */
    public static void main(String args[]){

        System.out.println(minOperation(6));

    }

    public static int minOperation(int n ){

        //n&1 代表奇数伟1 偶数为0
        return (n * n - (n&1)) >>2;


    }
}
