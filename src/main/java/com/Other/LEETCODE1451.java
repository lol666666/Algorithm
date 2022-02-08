package com.Other;

import java.util.Arrays;
import java.util.Comparator;

public class LEETCODE1451 {
    /**
     * 重新排列句子中的单词
     * https://its301.com/article/JR_Chan/106268054
     * @param args
     */
    public static void main(String args[]){
        String text = "test hell aa";

        String test = getNewString(text);
        System.out.println(test);

    }

    public static String getNewString(String text){
       String str [] =  text.split(" ");
       str[0] = str[0].toLowerCase();
       for (int i=0;i<str.length;i++){
           for (int j=0;j<str.length-i-1;j++){
               if(str[j].length() > str[j+1].length()){
                   String temp = str[j+1];
                   str[j+1]=str[j];
                   str[j] = temp;
               }

           }
       }

       str[0]= str[0].substring(0,1).toUpperCase() + str[0].substring(1);
       StringBuilder sfb = new StringBuilder();
       for (int i=0;i<str.length;i++){
           sfb.append(str[i]);
           if(i != str.length-1) {
               sfb.append(" ");
           }
       }
       return sfb.toString();

    }


    public String arrangeWords(String text) {
        String[] str = text.trim().split(" ");
        str[0] = str[0].toLowerCase();
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        str[0] = str[0].substring(0,1).toUpperCase() + str[0].substring(1);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i]);
            if(i != str.length -1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
