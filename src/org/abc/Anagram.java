package org.abc;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram","nagaram"));
        System.out.println(isAnagram("rat","car"));
    }

    public static boolean isAnagram(String s, String t) {

        if(s == null || s.isEmpty()) {
            return (t==null || t.isEmpty());
        }

        if(s.length() != t.length()) {
            return false;
        }

        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        Arrays.sort(sCharArray);
        Arrays.sort(tCharArray);

        for(int i=0;i<sCharArray.length;i++) {
            if(sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }

        return true;
    }
}
