package com.StringNum;

//正则表达式


 import java.util.*;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;


public class GetNum {

    public static void main(String[] args) {
        String a= "CEX210105174632648765217129111";
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(a);
        System.out.println(matcher.replaceAll("").trim());
//        System.out.println(matcher.replaceFirst("").trim());

//       String value = increase("CEX210105174632648765217129111");
//        System.out.println(value);

    }

    public static String increase(String value){
        int index=1;
        int n=Integer.parseInt(value.substring(index))+1;
        String newValue=String.valueOf(n);
        int len=value.length()-newValue.length()-index;

        for(int i=0;i<len;i++){
            newValue="0"+newValue;
        }
        return value.substring(0,index)+newValue;
    }
}
