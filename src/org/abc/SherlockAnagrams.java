package org.abc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SherlockAnagrams {

    public static void main(String[] args) {
        System.out.println(sherlockAndAnagrams("abba"));
        System.out.println(sherlockAndAnagrams("ifailuhkqq"));
        System.out.println(sherlockAndAnagrams("kkkk"));
        System.out.println(sherlockAndAnagrams("cdcd"));
    }

    private static int sherlockAndAnagrams(String str) {
        int count = 0;
        if(!(str == null || str.isEmpty())) {
            char[] chars = str.toCharArray();
            Map<String,Integer> set = new HashMap<String,Integer>();
            for(int i=1;i<chars.length;i++) {
                set.clear();
                char[] newStr = new char[i];
                for(int j=0;j<=chars.length-i;j++) {
                    System.arraycopy(chars,j,newStr,0,newStr.length);
                    Arrays.sort(newStr);
                    String anagram = String.valueOf(newStr);
                    Integer counter = set.get(anagram);
                    if(counter == null) {
                        counter =0;
                    }
                    set.put(anagram,++counter);
                }
                count+=getCounts(set);

            }
        }
        return count;
    }

    private static int getCounts(Map<String, Integer> map) {
        int count = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            int val = entry.getValue()-1;
            count += (val*(val+1))/2;
        }
        return count;
    }
}
