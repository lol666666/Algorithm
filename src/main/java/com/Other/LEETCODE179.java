package com.Other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LEETCODE179 {


    public static void main(String args[]) {
        int nums[] = {10, 2, 3};
        System.out.println(largestNumberN(nums));
//        System.out.println("10".substring(0));
    }

    // 数组的数据可拆解
    public static String largestNumber(int[] nums) {
        List<Integer> ano = new ArrayList();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() > 1) {
                for (int j = 0; j < String.valueOf(nums[i]).length(); j++) {
                    System.out.println("-----------");
                    System.out.println((String.valueOf(nums[i]).substring(j, j + 1)));
                    ano.add(Integer.valueOf(String.valueOf(nums[i]).substring(j, j + 1)));
                }
            } else {
                ano.add(nums[i]);
            }
        }
        ano.sort(Integer::compareTo);
        StringBuilder sbb = new StringBuilder();
        for (int i = ano.size() - 1; i >= 0; i--) {
            sbb.append(ano.get(i));
        }
        return sbb.toString();
    }

    //数组数据不可拆解
//    public static String largestNumberNon(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return "";
//
//        }
//        List<String> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(String.valueOf(num));
//        }
//        PriorityQueue<String> priorityQueue = new PriorityQueue<>((o1, o2) -> {
//            String str1 = o1 + o2;
//            String str2 = o2 + o1;
//            return str2.compareTo(str1);
//        }
//        );
//        priorityQueue.addAll(list);
//        StringBuilder stringBuilder = new StringBuilder();
//        while (!priorityQueue.isEmpty()) {
//            stringBuilder.append(priorityQueue.remove());
//        }
//        if (stringBuilder.toString().charAt(0) == '0') {
//            return "0";
//        }
//        return stringBuilder.toString();
//    }
    public static String largestNumberN(int[] nums) {
        List<String> ano = new ArrayList();
        if (nums ==null || nums.length==0){

            return "";
        }
        for (int num:nums){
            ano.add(String.valueOf(num));
        }
        PriorityQueue<String> priorityQueue = new PriorityQueue <>((o1,o2) ->{
            String l1 = o1 + o2;
            String l2=  o2 + o1;
            return l2.compareTo(l1);
        });
        priorityQueue.addAll(ano);
        StringBuilder sb = new StringBuilder();
        while(!priorityQueue.isEmpty()){
            sb.append(priorityQueue.remove());
            System.out.println(priorityQueue.size());

        }

        //错误示例 priorityQueue的size（）一直在减小
//        if(!priorityQueue.isEmpty()){
//            System.out.println(priorityQueue.size());
//            for(int i=0;i<priorityQueue.size();i++){
//                sb.append(priorityQueue.remove());
//              System.out.println(priorityQueue.remove());
//            }
//        }
        if(sb.toString().charAt(0) =='0'){
            return "0";
        }


        return sb.toString();



    }
}
