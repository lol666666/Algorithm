package com.TwoNum;

import java.util.HashMap;
import java.util.Map;

public class TwoNumSum {


    /**
     * 两数之和暴力法
     */

    public static int[] getTwoSumVoliet(int[] nums, int target){
        int[] result =new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0]=nums[i];
                    result[1]=nums[j];
                    return result;
                }
            }
        }
        return null;

    }

    /**
     * 两数之和hash
     * @param nums
     * @param target
     * @return
     */

    public static int[] getTwonumMap(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i=0;i<nums.length;i++){
            int compotent = target -nums[i];
            if(map.containsKey(compotent) && map.get(compotent) != i){
                return new int[]{map.get(compotent),i};
            }
            map.put(nums[i],i);
        }
        return null;

    }

    public static void main(String[] args) {
        int [] num = {2,1,5,3,4};
        int target = 5;
        int [] a = getTwoSumVoliet(num,target);
        System.out.println(a[0]);
        System.out.println(a[1]);
        int[] b = getTwonumMap(num,target);
        for (int i=0;i<b.length;i++){
            System.out.println(b[i]);
        }

    }
}
