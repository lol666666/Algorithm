package com.Other;

import java.util.HashMap;

public class LEETCODE01 {

    public static void main (String args[]){

         int [] nums = {2,7,11,15};
        System.out.println(twoSum(nums,9));
    }

//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for(int i=0;i<nums.length;i++){
//            int comSult = target - nums[i];
//
//            if(map.containsKey(comSult) && map.get(nums[i]) != i){
//
//                return new int [] {map.get(comSult),i};
//            }
//            map.put(nums[i],i);
//        }
//          return new int[] {};
//
//    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hashmap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            int comResult = target - nums[i];
            System.out.println(comResult);
            //一定为 hashmap.get(comResult) != i 来判断是否重用
            if(hashmap.containsKey(comResult) && hashmap.get(comResult) != i){
                return new int [] {hashmap.get(comResult),i};
            }
            hashmap.put(nums[i],i);
        }
        return new int [] {};
    }

}
