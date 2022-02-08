package com.NoRepeatString;

import java.util.HashMap;
import java.util.Map;

public class MostLongNoRepeat {

    /**
     * 无重复最长字符串
     * @param s
     * @return
     */
    public static int getMostLongNoRepeat(String s){
        int right =0;
        int left = 0;
        int len = 0;
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        while (right<s.length()){
            //获取index 移动指针，如果index存在则存在重复的字符串
            Integer index = map.get(s.charAt(right));
            map.put(s.charAt(right),right);
            //index 必须>=left 如果只大于就会略过首位
            if(index !=null && index>=left) {
                left =index+1;
            }
            // right 和 left的差值为不重复串的长度
            if(right-left+1>len){
                len=right-left+1;
            }
            right ++;
        }

        return len;
    }


    public static void main(String[] args) {
        String s="sssssssssadjsadasaasdaa";
        int len = getMostLongNoRepeat(s);
        System.out.println(len);

    }
}
