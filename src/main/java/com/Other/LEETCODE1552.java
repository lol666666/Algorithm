package com.Other;

import java.util.Arrays;

/**
 * 时间复杂度：O(n\log (nS))O(nlog(nS))，其中 nn 为篮子的个数，SS 为篮子位置的上限。对篮子位置排序需要 O(n\log n)O(nlogn) 的时间复杂度，二分查找对篮子位置间隔进行二分，需要 O(\log S)O(logS) 的时间复杂度。每次统计答案是否符合要求需要 O(n)O(n) 的时间复杂度，因此总时间复杂度为 O(n\log n+n\log S) = O(n\log (nS))O(nlogn+nlogS)=O(nlog(nS))
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/magnetic-force-between-two-balls/solution/liang-qiu-zhi-jian-de-ci-li-by-leetcode-solution/
 *
 *空间复杂度：O(\log n)O(logn)，即为排序需要的栈空间。
 *
 */

public class LEETCODE1552 {

    //两球之间的磁力
    //https://blog.csdn.net/weixin_44337475/article/details/108038259
    //-首先，对数组进行排序。
    //-其次，找到磁力的边界。即任意两球最大磁力与最小磁力。最大磁力是position[length-1]-position[0]/(m-1)。最小磁力是1。
    //-接下来，采用我们的核心算法，二分查找。查找最小磁力的最大值。
    //-设置check函数，如果当前距离可以放下m个或多于m个球，则返回true；否则返回false。
    //-如果当前距离可以放下放下m个或多于m个球，则让距离往右移动；否则往左移动。
    //————————————————
    //版权声明：本文为CSDN博主「weixin_Akian」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
    //原文链接：https://blog.csdn.net/weixin_44337475/article/details/108038259
    public static void main(String args[]){
//        int position [] = {1,2,3,4,7};
        int position [] = {6,7,8,9,10};
        System.out.println(maxDistance(position,6));



    }

    public static int maxDistance(int [] position,int m){
        Arrays.sort(position);
        int len = position.length;
        int hight = position[len-1]-position[0];
        System.out.println(hight);
        int low = 1;
        int res = 1;
        while (low <= hight){
            int mid = low +(hight -low)/2;

            if(check(position,mid,m)){
                res =mid;
                low=mid +1;
            }else{
                hight=mid-1;
            }

        }

           return res;

    }




    public static boolean check(int position[],int distance,int m){
        int count =1;
        int i = 0;
        for(int j=1;j<position.length;j++) {
            if (position[j] -position[i] >= distance){

                i=j;
                count ++;
                if (count >= m) return true;

            }
        }

        return  false;
    }

//    public static int maxDistance(int[] position, int m) {
//        Arrays.sort(position);
//        int len = position.length;
//        int hight = (position[len-1]-position[0])/m-1;
//        int low =1;
//        int res =1;
//        while(low <=hight){
//            int mid = low + (hight-low)/2;
//            if(check(position,mid,m)){
//                res =mid;
//                low = mid +1;
//            }else{
//                hight = mid -1;
//            }
//
//        }
//        return res;
//
//    }
//
//    public static boolean check(int position [], int distance,int m){
//        int i=0;
//        int count=1;
//        for (int j=1;j<position.length;j++){
//            if (position[j]-position[i] >=distance){
//                i=j;
//                count ++;
//                if (count >=m) return true;
//            }
//        }
//        return false;
//
//
//    }
}
