package org.abc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if(s == null || s.isEmpty()) {
            return -1;
        }

        int[] cache = new int[26];

        final char[] strChars = s.toCharArray();
        for(char c : strChars) {
            cache[c - 'a']++;
        }

        for(int i=0;i<strChars.length;i++) {
            if(cache[strChars[i]-'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
