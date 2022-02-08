package com.Other;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LEETCODE15 {

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param args
     */
    public static void main(String args[]){
        int nums [] = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));
        List<Integer> list = new ArrayList<>();

    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            //正整数之和肯定不为0
            if(nums[i] >0){
                return ans;
            }
            //与上个数字相同不需要计算
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum ==0){
                    ans.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (i>0 && nums[left]==nums[left +1]){
                        left ++;
                    }
                    while (i>0 && nums[right]  == nums[right-1]){
                        right --;
                    }
                    left ++;
                    right --;
                }else if(sum <0){
                    left ++;
                }else if(sum >0){
                    right --;
                }
            }
        }

        return ans;
    }
}

